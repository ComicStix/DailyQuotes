package nld.dailyquotes;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;

import org.jsoup.nodes.Element;

public class Window extends JFrame implements ActionListener {

	private JPanel contentPane;
	private DailyQuotes dq;
	private ArrayList<Element> allElements;
	private ArrayList<Element> newElements;
	private Element selection;
	private int currentIndex = 0;
	public JLabel quote;
	public JLabel author;
	private String[] quoteAndAuthor;
	private int pageNumber = 2;
	private int index = 1;
	private boolean testBosolean = true;
	private Calendar cal1 = Calendar.getInstance();
	private Calendar cal2;
	private Calendar temp;
	

	// private Timer timer;
	// private Timer timer;

	/**
	 * Launch the application.
	 */

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				// Time timer = new Time();
				Window window = new Window();
				try {
					Window frame = new Window();
					frame.setVisible(true);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Window() {

		dq = new DailyQuotes();
		dq.setDocument("http://www.brainyquote.com/quotes/topics/topic_inspirational.html");
		allElements = dq.elementsArray("div.boxyPaddingBig");
		selection = allElements.get(0);
		quoteAndAuthor = dq.getQuoteAndAuthor(selection);
		String quote1 = quoteAndAuthor[0];
		String author1 = quoteAndAuthor[1];

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 182);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel title = new JLabel("Daily Quote", JLabel.CENTER);
		title.setBounds(155, 6, 135, 33);
		title.setFont(new Font("Lucida Blackletter", Font.BOLD, 25));
		contentPane.add(title);

		JLabel acknowledgement = new JLabel("Content provided by BrainyQuote");
		acknowledgement.setForeground(Color.LIGHT_GRAY);
		acknowledgement.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		acknowledgement.setBounds(6, 138, 167, 16);
		contentPane.add(acknowledgement);

		quote = new JLabel("<html>" + quote1 + "<html>");
		quote.setFont(new Font("Lucida Grande", Font.PLAIN, 12));
		quote.setBounds(6, 42, 438, 66);
		contentPane.add(quote);

		author = new JLabel("- " + author1);
		author.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		author.setBounds(6, 110, 214, 16);
		contentPane.add(author);

		JButton btnNextQuote = new JButton("Next");
		btnNextQuote.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean endOfArray = dq.outOfQuotes(allElements, currentIndex);
				if (endOfArray == true) {
					dq.setDocument("http://www.brainyquote.com/quotes/topics/topic_inspirational"
							+ pageNumber + ".html");
					newElements = dq.elementsArray("div.boxyPaddingBig");
					/*
					 * for (Element j : newElements) { String[] test =
					 * dq.getQuoteAndAuthor(j); String blah = test[0]; String
					 * blah2 = test[1]; System.out.println(index + ":");
					 * System.out.println(blah); System.out.println(blah2);
					 * System.out.println(); }
					 */
					allElements = newElements;
					pageNumber++;
					System.out.println("Page number: " + pageNumber);
					System.out.println("---");
				}

				currentIndex++;
				Element newSelection = allElements.get(currentIndex);
				String[] nextQuoteAndAuthor = dq
						.getQuoteAndAuthor(newSelection);
				String nextQuote = nextQuoteAndAuthor[0];
				String nextAuthor = nextQuoteAndAuthor[1];
				quote.setText("<html>" + nextQuote + "<html>");
				author.setText("- " + nextAuthor);
			}
		});
		btnNextQuote.setBounds(327, 125, 117, 29);
		contentPane.add(btnNextQuote);

		JButton btnPreviousQuote = new JButton("Previous");
		btnPreviousQuote.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int previousIndex = currentIndex - 1;
				if (previousIndex < 0) {
					previousIndex = 0;
					currentIndex = previousIndex;
				} else {
					Element newSelection = allElements.get(previousIndex);
					String[] previousQuoteAndAuthor = dq
							.getQuoteAndAuthor(newSelection);
					String previousQuote = previousQuoteAndAuthor[0];
					String previousAuthor = previousQuoteAndAuthor[1];
					quote.setText("<html>" + previousQuote + "<html>");
					author.setText("- " + previousAuthor);
					currentIndex = previousIndex;
				}
			}
		});
		btnPreviousQuote.setBounds(198, 125, 117, 29);
		contentPane.add(btnPreviousQuote);

		Timer timer = new Timer(5000, this);
		timer.start();
	}

	public void actionPerformed(ActionEvent e) {
		cal2 = Calendar.getInstance();
		boolean sameDay = cal1.get(Calendar.YEAR) == cal2.get(Calendar.YEAR) &&
		                  cal1.get(Calendar.DAY_OF_YEAR) == cal2.get(Calendar.DAY_OF_YEAR);
		if (sameDay == false){
		boolean endOfArray = dq.outOfQuotes(allElements, currentIndex);
		if (endOfArray == true) {
			dq.setDocument("http://www.brainyquote.com/quotes/topics/topic_inspirational"
					+ pageNumber + ".html");
			newElements = dq.elementsArray("div.boxyPaddingBig");
			allElements = newElements;
			pageNumber++;
			System.out.println("Page number: " + pageNumber);
			System.out.println("---");
		}
		currentIndex++;
		Element newSelection = allElements.get(currentIndex);
		String[] nextQuoteAndAuthor = dq
				.getQuoteAndAuthor(newSelection);
		String nextQuote = nextQuoteAndAuthor[0];
		String nextAuthor = nextQuoteAndAuthor[1];
		quote.setText("<html>" + nextQuote + "<html>");
		author.setText("- " + nextAuthor);
		}
		cal1 = cal2;

	}

}
