package com.atspickem.backend.util;

import com.atspickem.backend.models.BettingOdd;
import com.atspickem.backend.models.NflSchedule;
import com.atspickem.backend.models.NflSpread;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

//TODO Refactor the code in this and schedule cron task
@Component
public class OddsScraper implements CommandLineRunner {

    @Autowired
    private NflScheduleService nflScheduleService;

    public OddsScraper() {
    }


    @Override
    public void run(String... args) throws Exception {
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
        BettingOdd bettingOddDTO = new BettingOdd();
        String[] oddStringSplit = new String[0];
        List<BettingOdd> bettingOddList = new ArrayList<>();

        for (Element e : divsWithOdds) {
            odds = e.attr("aria-label");
            boolean endsWithDigit = Character.isDigit(odds.charAt(odds.length() - 1));

            // Scrape only Spreads, no O/U etc
            // this is VERY hacky
            // TODO Fix this logic and hardcoded values
            if (!(odds.startsWith("O") || odds.startsWith("U") || !endsWithDigit))
                counter++;
            if (counter == 1) {
                oddStringSplit = odds.split(" ");

                if (oddStringSplit[0].equals("WAS")) {
                    bettingOddDTO.setFirstTeam(oddStringSplit[0] + " " + oddStringSplit[1] + " " + oddStringSplit[2]);
                    bettingOddDTO.setFirstSpread((oddStringSplit[3]));
                } else {
                    bettingOddDTO.setFirstTeam(oddStringSplit[0] + " " + oddStringSplit[1]);
                    bettingOddDTO.setFirstSpread(oddStringSplit[2]);
                }
            }
            if (counter == 2) {
                counter = 0;
                oddStringSplit = odds.split(" ");

                if (oddStringSplit[0].equals("WAS")) {

                    bettingOddDTO.setSecondTeam(oddStringSplit[0] + " " + oddStringSplit[1] + " " + oddStringSplit[2]);
                    bettingOddDTO.setSecondSpread((oddStringSplit[3]));
                    bettingOddList.add(bettingOddDTO);
                } else {
                    bettingOddDTO.setSecondTeam(oddStringSplit[0] + " " + oddStringSplit[1]);
                    bettingOddDTO.setSecondSpread(oddStringSplit[2]);

                    BettingOdd tempBettingOdd = new BettingOdd(bettingOddDTO);
                    bettingOddList.add(tempBettingOdd);
                }
            }
        }
        int currentWeek = 1;
        // Load NFL schedule for week = current week
        List<NflSchedule> nflScheduleList = new ArrayList<>();
        nflScheduleList = nflScheduleService.findByWeek(currentWeek);
        int length = nflScheduleList.size();


        // Create NflSpread objects where where the matchups match the odds matchup
        // persist the nflspreads to database
        List<NflSpread> nflSpreadList = new ArrayList<>();

        for(NflSchedule i : nflScheduleList) {
            for(BettingOdd j : bettingOddList) {
                // Nfl Schedule and betting odds contain the same teams
                // very hacky again.... but this is only ran once a week so perhaps we are okay
                if((i.getHomeTeam().equals(j.getFirstTeam())
                    || i.getHomeTeam().equals(j.getSecondTeam()))
                    && (i.getAwayTeam().equals(j.getFirstTeam())
                        || i.getAwayTeam().equals(j.getSecondSpread()))) {

                    NflSpread tempSpread = new NflSpread();
                    if (i.getHomeTeam().equals(j.getFirstTeam())) {
                        tempSpread.setWeek(currentWeek);

                        tempSpread.setHomeTeam(j.getFirstTeam());
                        tempSpread.setHomeSpread(j.getFirstSpread());

                        tempSpread.setAwayTeam(j.getSecondTeam());
                        tempSpread.setAwaySpread(j.getSecondSpread());

                        nflSpreadList.add(tempSpread);
                    } else {
                        tempSpread.setWeek(currentWeek);

                        tempSpread.setHomeTeam(j.getSecondTeam());
                        tempSpread.setHomeSpread(j.getSecondSpread());
                        tempSpread.setAwayTeam(j.getFirstTeam());
                        tempSpread.setAwaySpread(j.getFirstSpread());

                        nflSpreadList.add(tempSpread);
                    }

                }
            }
        }
        System.out.print(nflSpreadList.toString());


    }
}
