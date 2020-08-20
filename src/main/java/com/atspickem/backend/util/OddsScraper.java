package com.atspickem.backend.util;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

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

        String odds;
        int counter = 0;
        Elements parentDiv = doc.getElementsByClass("sportsbook-outcome-cell");
        Elements divsWithOdds = parentDiv.select("div.sportsbook-outcome-cell__body[aria-label]");
//        System.out.println(parentDiv.toString());

        for(Element e : divsWithOdds) {
            odds = e.attr("aria-label");
            boolean endsWithDigit = Character.isDigit(odds.charAt(odds.length() - 1));

            if(!(odds.startsWith("O") || odds.startsWith("U") || !endsWithDigit))
                counter++;
                if(counter == 1) {
                    System.out.print(odds);
                }
                if(counter == 2) {
                    counter = 0;
                    System.out.println(" " + odds);
                }
        }
    }
}
