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

        List<Element> oddsDiv = null;
        String odds = null;
        Elements parentDiv = doc.getElementsByClass("sportsbook-outcome-cell");
        Elements test = parentDiv.select("div.sportsbook-outcome-cell__body[aria-label]");

        for(Element e1 : test) {
            odds = e1.attr("aria-label");
            System.out.println(odds);
        }
    }
}
