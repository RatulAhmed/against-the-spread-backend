package com.atspickem.backend.util;

import com.atspickem.backend.models.BettingOdd;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class OddsScraper {

    public static void main(String[] args) {
        String oddsUrl = "https://sportsbook.draftkings.com/leagues/football/3?category=game-lines&subcategory=game";
        Document doc = null;
        {
            try {
                doc = Jsoup.connect(oddsUrl).userAgent("Mozilla").referrer("http://google.com").get();
            } catch (IOException e) {
                System.out.println("Error in connecting to url");
            }
        }
        Elements parentDiv = doc.getElementsByClass("sportsbook-outcome-cell");
        Elements divsWithOdds = parentDiv.select("div.sportsbook-outcome-cell__body[aria-label]");
        String odds;
        int counter = 0;
        List<BettingOdd> oddList = new ArrayList<>();
        BettingOdd bettingOddDTO = new BettingOdd();
        String[] oddStringSplit = new String[0];

        for(Element e : divsWithOdds) {
            odds = e.attr("aria-label");
            boolean endsWithDigit = Character.isDigit(odds.charAt(odds.length() - 1));

            // Scrape only Spreads, no O/U etc
            // this is really bad
            // TODO Fix this logic and hardcoded values
            if(!(odds.startsWith("O") || odds.startsWith("U") || !endsWithDigit))
                counter++;
                if(counter == 1) {
                    oddStringSplit = odds.split(" ");

                    if(oddStringSplit[0].equals("WAS")) {
                        bettingOddDTO.setFirstTeam(oddStringSplit[0] + " " + oddStringSplit[1] + " " + oddStringSplit[2]);
                        bettingOddDTO.setFirstSpread((oddStringSplit[3]));
                    } else {
                        bettingOddDTO.setFirstTeam(oddStringSplit[0] + " " + oddStringSplit[1]);
                        bettingOddDTO.setFirstSpread(oddStringSplit[2]);
                    }
                }
                if(counter == 2) {
                    counter = 0;
                    oddStringSplit = odds.split(" ");

                    if(oddStringSplit[0].equals("WAS")) {

                        bettingOddDTO.setSecondTeam(oddStringSplit[0] + " " + oddStringSplit[1] + " " + oddStringSplit[2] );
                        bettingOddDTO.setSecondSpread((oddStringSplit[3]));
                    } else {
                        bettingOddDTO.setSecondTeam(oddStringSplit[0] + " " + oddStringSplit[1]);
                        bettingOddDTO.setSecondSpread(oddStringSplit[2]);
                    }
                    System.out.println(bettingOddDTO.toString());
                }
        }
    }
}
