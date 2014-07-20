package nld.dailyquotes;

import java.io.IOException;
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
		Elements quotes = doc.getElementsByClass("bqQuoteLink");
		System.out.println(title);
		
		for (Element specificQuote: quotes){
			String quote = specificQuote.select("a").text();
			System.out.println(quote + "\n");
		}
			
	}

}
