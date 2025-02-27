public class Book{
	String title;
	String isbn;
	Author author;
	public Book(String title, String isbn, Author author){
		this.title = title;
		this.isbn = isbn;
		this.author = author;
	}
	
	public String gettitle(){
		return title;
	}
	
	public String getisbn(){
		return isbn;
	}
	
	public Author getauthor(){
		return author;
	}
	
}
