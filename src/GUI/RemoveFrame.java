package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import main.Book;
import main.LibrarySys;

import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import java.awt.Window.Type;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RemoveFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private DisplayFrame df;
	private String[] combo = {"Author","Book"};

	
	public RemoveFrame(DisplayFrame df) {
		this.df = df;
		setTitle("REMOVE FRAME");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 270);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(185, 6, 127, 27);
		comboBox.setModel(new DefaultComboBoxModel(combo));
		contentPane.add(comboBox);
		
		JLabel lblNewLabel_1 = new JLabel("ID:");
		lblNewLabel_1.setBounds(175, 50, 18, 16);
		contentPane.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(195, 45, 130, 26);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("STATUS");
		lblNewLabel_2.setBounds(219, 210, 51, 26);
		contentPane.add(lblNewLabel_2);
		
		JTextArea textArea = new JTextArea();
		textArea.setEditable(false);
		textArea.setLineWrap(true);
		textArea.setBounds(163, 150, 166, 72);
		contentPane.add(textArea);
		
		JButton btnClose = new JButton("Close");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				df.setVisible(true);
				dispose();
			}
		});
		btnClose.setBounds(377, 207, 117, 29);
		contentPane.add(btnClose);
		
		JButton btnRemove = new JButton("Remove");
		btnRemove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (textField.getText().equals("")) {
					textArea.setText("Fill the id area to remove author or book with the specified id.");
				}
				else {
					if(comboBox.getSelectedIndex() == 0) {
						if(LibrarySys.getMap().containsKey(Integer.parseInt(textField.getText()))) {
							LibrarySys.getMap().remove(Integer.parseInt(textField.getText()));
							//Currently it's not being deleted from file.
						}
						else {
							textArea.setText("There is no match found with the given ID.");
						}
					}
					else if (comboBox.getSelectedIndex() == 1) {
						boolean isFound = false;
						for (Book book : LibrarySys.getList()) {
							if(book.getId() == Integer.parseInt(textField.getText())) {
								isFound = true;
								LibrarySys.getList().remove(book);
							}
						}
						if(!isFound) {
							textArea.setText("There is no match found with the given ID.");
						}
					}
					else {
						textArea.setText("Choose either author or book from combo box.");
					}
				}
				
			}
		});
		btnRemove.setBounds(185, 97, 127, 29);
		contentPane.add(btnRemove);

	}
}
