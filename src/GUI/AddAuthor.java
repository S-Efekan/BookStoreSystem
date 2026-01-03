package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import main.LibrarySys;

import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class AddAuthor extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private DisplayFrame df;
	private JTextField textFieldID;
	private JTextField textFieldName;

	
	public AddAuthor(DisplayFrame df) {
		setTitle("ADD AUTHOR");
		this.df = df;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(20, 27, 137, 220);
		contentPane.add(textArea);
		
		textFieldID = new JTextField();
		textFieldID.setBounds(297, 81, 147, 26);
		contentPane.add(textFieldID);
		textFieldID.setColumns(10);
		
		textFieldName = new JTextField();
		textFieldName.setBounds(297, 109, 147, 26);
		contentPane.add(textFieldName);
		textFieldName.setColumns(10);
		
		JLabel lblLabel = new JLabel("STATUS");
		lblLabel.setBounds(61, 6, 48, 16);
		contentPane.add(lblLabel);
		
		JLabel lblNewLabel = new JLabel("Author ID:");
		lblNewLabel.setBounds(185, 86, 65, 16);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Author Name:");
		lblNewLabel_1.setBounds(185, 114, 87, 16);
		contentPane.add(lblNewLabel_1);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Adding new Author
				if(textFieldID.getText().equals("") || textFieldName.getText().equals("")) {
					textArea.setText("FILL ALL THE NECESSARY FIELDS!!!");
				}
				else {
					if(LibrarySys.addAuthor(Integer.parseInt(textFieldID.getText()), textFieldName.getText())) {
						textArea.setText("Author added successfully.");
					}
					else {
						textArea.setText("A problem accured during process. Check LibrarySys.class.");
					}
					
				}
			}
		});
		btnAdd.setBounds(245, 157, 117, 29);
		contentPane.add(btnAdd);
		
		JButton btnNewButton = new JButton("Close");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				df.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setBounds(245, 198, 117, 29);
		contentPane.add(btnNewButton);

	}
}
