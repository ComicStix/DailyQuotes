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
		
		public String [] getQuoteAndAuthor(Element specificElement){
			quote = specificElement.select("a").get(0).text();
			author = specificElement.select("a").get(1).text();
			return new String[]{quote, author};
		}
		public Element getNextElement (int currentIndex, ArrayList<Element>allElements){
			int nextIndex = currentIndex + 1;
			Element nextElement = allElements.get(nextIndex);
			return nextElement;
		}
		public boolean outOfQuotes (ArrayList<Element> array, int currentIndex)
		{
			if(array.size()-1==currentIndex){
				return true;
			}
			return false;
		}
}
