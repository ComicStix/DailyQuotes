package nld.dailyquotes;


import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.FlowLayout;
import net.miginfocom.swing.MigLayout;
import javax.swing.BoxLayout;
import java.awt.Color;

public class Window extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
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
		
		JLabel quote = new JLabel("");
		quote.setBounds(6, 54, 438, 16);
		contentPane.add(quote);
		
		JLabel author = new JLabel("");
		author.setBounds(6, 82, 214, 16);
		contentPane.add(author);
	}
}
