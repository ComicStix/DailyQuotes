package nld.dailyquotes;

import java.io.IOException;
import java.util.ArrayList;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class DailyQuotes {
		
		private Document doc;
		private String quote;
		private String author;
		private ArrayList<Element>elements = new ArrayList<Element>();
		
		public void setDocument(String url){
		// TODO Auto-generated method stub
			try {
				doc = Jsoup.connect(url)
						.userAgent("Chrome")
						.get();
			}
			catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		public Document getDocument () {
			return doc;
		}
		
		public String getTitle(){
			return doc == null ? null : doc.title();
		}
		
		public ArrayList<Element> elementsArray(String selectedDiv){
		Elements containingDiv = doc.select(selectedDiv);
		for (Element div: containingDiv){
			elements.add(div);
		}
		return elements;
		}
		
		public String [] specificElement(ArrayList<Element> div, int index){
			Element currentQuote = div.get(index);
			quote = currentQuote.select("a").get(0).text();
			author = currentQuote.select("a").get(1).text();
			return new String[]{quote, author};
		}
	
		public static void main (String[] args){
			DailyQuotes dq = new DailyQuotes();
			dq.setDocument("http://www.brainyquote.com/quotes/topics/topic_inspirational.html");
			System.out.println(dq.getTitle());
			
			
			ArrayList<Element> allElements = dq.elementsArray("div.boxyPaddingBig");
			String [] quoter = dq.specificElement(allElements, 0);
			String quote1 = quoter[0];
			String author1 = quoter[1];
			System.out.println(quote1);
			System.out.println(author1);
			
			
			}
}
