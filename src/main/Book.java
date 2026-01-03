package main;

public class Book {
	private int id;
	private String title;
	private int AuthorId;
	
	public Book() {
		super();
	}
	
	public Book(int id, String title, int AuthorId) {
		this.id = id;
		this.title = title;
		this.AuthorId = AuthorId;
	}
	
	public int getId() {
		return id;
	}
	
	public String getTitle() {
		return title;
	}
	
	public int getAuthorId() {
		return AuthorId;
	}
	
	@Override
	public String toString() {
		return "Book ID: "+id+"\nBook Title: "+title+"\nAuthor ID: "+AuthorId+"\n";
	}
	
	
	//End of class
}
