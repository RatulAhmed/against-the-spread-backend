package com.atspickem.backend.util;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.List;

public class OddsScraper {

    public static void main(String[] args) {
        String oddsUrl = "https://sportsbook.draftkings.com/leagues/football/3?category=game-lines&subcategory=game";
        Document doc = null;

        {
            try {
                doc = Jsoup.connect(oddsUrl).userAgent("Mozilla").referrer("http://google.com").get();
            } catch (IOException e) {
                System.out.println("Error in connecting to odds url");
            }
        }
//        Elements tableData = doc.getElementsByClass("sportsbook-outcome-cell");
//        String result = tableData.toString();
//        Element spread = tableData.first().child(0);
//        Elements outcomeCell = spread.select("div.sportsbook-outcome-cell__body[aria-label]");
//        String ariaLabel = outcomeCell.attr("aria-label");
//        System.out.println(ariaLabel);

        List<Element> oddsDiv = null;
        String odds = null;
        Elements parentDiv = doc.getElementsByClass("sportsbook-outcome-cell");
        Elements test = parentDiv.select("div.sportsbook-outcome-cell__body[aria-label]");
//        System.out.println(test.toString());

        for(Element e1 : test) {
            odds = e1.attr("aria-label");
            System.out.println(odds);
        }

    }
}
