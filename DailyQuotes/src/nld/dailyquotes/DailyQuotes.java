package nld.dailyquotes;

import java.io.IOException;
import java.util.Iterator;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class DailyQuotes {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Document doc = Jsoup.connect("http://www.brainyquote.com/quotes/topics/topic_inspirational.html")
				.userAgent("Chrome")
				.get();
		String title = doc.title();
		System.out.println(title);
		
		Elements containingDiv = doc.select("div.boxyPaddingBig");

		for (Element div: containingDiv){
			String quote = div.select("a").get(0).text();
			String author = div.select("a").get(1).text();
			System.out.println(quote + "\n" + author);
			System.out.println();
		}
	}
}

		
		
		
			
	



