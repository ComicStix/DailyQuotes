package nld.dailyquotes;



import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;



import javax.swing.JLabel;

import java.awt.Font;


import org.jsoup.nodes.Element;

import java.awt.Color;
import java.util.ArrayList;

public class Window extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	DailyQuotes dq = new DailyQuotes();

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
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
		DailyQuotes dq = new DailyQuotes();
		dq.setDocument("http://www.brainyquote.com/quotes/topics/topic_inspirational.html");
		ArrayList<Element> allElements = dq.elementsArray("div.boxyPaddingBig");
		String [] quoteAndAuthor = dq.specificElement(allElements, 3);
		String quote1 = quoteAndAuthor[0];
		String author1 = quoteAndAuthor[1];
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 182);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel title = new JLabel("Daily Quote",JLabel.CENTER);
		title.setBounds(155, 6, 135, 33);
		title.setFont(new Font("Lucida Blackletter", Font.BOLD, 25));
		contentPane.add(title);
		
		JLabel acknowledgement = new JLabel("Content provided by BrainyQuote");
		acknowledgement.setForeground(Color.LIGHT_GRAY);
		acknowledgement.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		acknowledgement.setBounds(6, 138, 167, 16);
		contentPane.add(acknowledgement);
		
		JLabel quote = new JLabel("<html>"+quote1+"<html>");
		quote.setFont(new Font("Lucida Grande", Font.PLAIN, 12));
		quote.setBounds(6, 42, 438, 66);
		contentPane.add(quote);
		
		JLabel author = new JLabel("- " + author1);
		author.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		author.setBounds(6, 110, 214, 16);
		contentPane.add(author);
	}
}
