package main;

public class Authors {
	private int id;
	private String name;
	
	public Authors(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	public Authors() {
		super();
	}
	
	public int getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	
	@Override
	public String toString() {
		return "Author ID: "+id+"\nAuthor Name: "+name+"\n";
	}
}
