package GUI;

import java.awt.EventQueue;
import java.awt.TextArea;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


import main.*;
import javax.swing.JScrollPane;


public class DisplayFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextArea textArea;
	private AddAuthor aa = new AddAuthor(this);
	private DisplayFrame currentFrame;
	
	public DisplayFrame() {
		currentFrame = this;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 750, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textArea = new JTextArea();
		textArea.setEditable(false);
		
		JScrollPane scrollPane = new JScrollPane(textArea);
		scrollPane.setBounds(20, 20, 430, 430);
		contentPane.add(scrollPane);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		
		JButton btnDisplayAuth = new JButton("Display Author");
		btnDisplayAuth.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LibrarySys.loadAuthors();
				textArea.setText(LibrarySys.displayAuthors());	
			}
		});
		btnDisplayAuth.setBounds(513, 122, 138, 29);
		contentPane.add(btnDisplayAuth);
		
		JButton btnAddAuthor = new JButton("Add Author");
		btnAddAuthor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				aa.setVisible(true);
				currentFrame.setVisible(false);
			}
		});
		btnAddAuthor.setBounds(591, 227, 117, 29);
		contentPane.add(btnAddAuthor);
		
		JButton btnAddBook = new JButton("Add Book");
		btnAddBook.setBounds(462, 227, 117, 29);
		contentPane.add(btnAddBook);
		
		JButton btnClose = new JButton("Close");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnClose.setBounds(524, 355, 117, 29);
		contentPane.add(btnClose);
		
		JButton btnDisplayBook = new JButton("Display Book");
		btnDisplayBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LibrarySys.loadBooks();
				textArea.setText(LibrarySys.displayBooks());
				
			}
		});
		btnDisplayBook.setBounds(524, 149, 117, 29);
		contentPane.add(btnDisplayBook);
		
		

	}
}
