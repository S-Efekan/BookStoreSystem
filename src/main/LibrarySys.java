package main;

import java.util.ArrayList;
import java.util.HashMap;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;

public class LibrarySys {

	private static HashMap<Integer, Authors> authorsMap = new HashMap<Integer, Authors>();
	private static ArrayList<Book> bookList = new ArrayList<Book>();
	
	public static void loadAuthors() {
		File f = new File("authors.txt");
		try {
			Scanner sc = new Scanner(f);
			while(sc.hasNext()) {
				int authId = sc.nextInt();
				String authName = sc.nextLine();
				Authors temp = new Authors(authId,authName);
				
				authorsMap.put(authId, temp);
				
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static void loadBooks() {
		File f = new File("books.txt");
		try {
			Scanner sc = new Scanner(f);
			while (sc.hasNext()) {
				String line = sc.nextLine();
				String[] fields;
				fields = line.split("-");
				
				Book temp = new Book(Integer.parseInt(fields[0]),fields[1],Integer.parseInt(fields[2]));
				bookList.add(temp);
				
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static String displayAuthors() {
		String out = "";
		int i = 1;
		
		for (Authors item : authorsMap.values()) {
			out += i +". Author;\n" + item.toString() + "\n";
			i++;
		}
		return out;
	}
	
	public static String displayBooks() {
		String out = "";
		int i = 1;
		
		for (Book book : bookList) {
			out += i+". Book;\n"+ book.toString() + "\n";
			i++;
		}
		return out;
	}
	
	public static boolean addAuthor(int id, String name) {
		
		if(authorsMap.containsKey(id)) {
			return false;
		}
		try {
			FileWriter fw = new FileWriter("authors.txt",true);
			Authors temp = new Authors(id,name);
			authorsMap.put(id, temp);
			String line = id + " "+ name + "\n";
			fw.write(line);
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
		
		return true;
	}
	
	
	
	
	
	//End of class
}
