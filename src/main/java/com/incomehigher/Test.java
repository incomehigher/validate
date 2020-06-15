package com.incomehigher;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class Test {

	public static void main(String[] args) {
			try {
	            Document doc = Jsoup.connect("https://btc.com/1AC4fMwgY8j9onSbXEWeH6Zan8QGMSdmtA").get();
	            
//	            System.out.println(doc.select(".abstract-section dl dd").first().text());
//	            System.out.println(doc.select("div.abstract-section dl:eq(1) dd").text());
	            System.out.println(doc.select("div.abstract-section dl").select("dd").first().text());
	            System.out.println(doc.select("div.abstract-section dl").select("dl:eq(1) dd").first().text());
	            
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	}

}
