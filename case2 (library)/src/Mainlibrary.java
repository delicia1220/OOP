import java.util.ArrayList;
import java.util.List;

class Author{
	
	String name;
	String desc;
	Author(String name, String desc){
		this.name = name;
		this.desc = desc;
	}
	
	public String getname(){
		return name;
	}
	
	public String getdesc(){
		return desc;
	}
}

class Book{
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


class Borrower{
	String name;
	List<Book> borrowedbook;
	
	public Borrower(String name) {
		this.name = name;
		this.borrowedbook = new ArrayList<>();
	}

	public String getName(){
		return name;
	}

	public void borrowBook (Book book){
		borrowedbook.add(book);
	}

	public void returnBook (Book book){
		borrowedbook.remove(book);
	} 

	public boolean hasBorrowed(Book book) {
		return borrowedbook.contains(book);
	}

	public void displayBorrowedBooks(){
        System.out.println(name + " borrowed books:");
        for(Book book : borrowedbook){
            System.out.println("Title: " + book.gettitle());
            System.out.println("ISBN: " + book.getisbn());
            System.out.println("Author: " + book.getauthor().getname());
            System.out.println("Biography: " + book.getauthor().getdesc());
            System.out.println("------------------------");
        }
    }
}


class Library{
	List<Book> books;
	public Library() {
		books  = new ArrayList<>();
	}
	
	public void addBook(Book book) {
		books.add(book);
		System.out.println("Book added to library: " + book.gettitle());
	}
	
	public void borrowBook(Borrower borrower, Book book) {
		if(books.contains(book)) {
			books.remove(book);
			borrower.borrowBook(book);
			System.out.println(borrower.getName() + " borrowed: " + book.gettitle());
        } else {
            System.out.println("Sorry, " + book.gettitle() + " is not available.");
        }
	}
	
	public void returnBook(Borrower borrower, Book book) {
		if (borrower.hasBorrowed(book)) { 
			borrower.returnBook(book);
			books.add(book);
			System.out.println(borrower.getName() + " returned " + book.gettitle());
		} else {
			System.out.println("This book is not borrowed by " + borrower.getName());
		}
	}

	public void displayLibraryBooks(){
        System.out.println("Books in library:");
        for(Book book : books){
            System.out.println("Title: " + book.gettitle());
            System.out.println("ISBN: " + book.getisbn());
            System.out.println("Author: " + book.getauthor().getname());
            System.out.println("Biography: " + book.getauthor().getdesc());
            System.out.println("------------------------");
        }
    }

}


public class Mainlibrary {

		public Mainlibrary()
		{
		Author author1 = new Author("James Gosling", "Creator of the Java programming language.");
        Author author2 = new Author("Robert C. Martin", "Known for his works on software craftsmanship.");

        Book book1 = new Book("Java Programming", "123456789", author1);
        Book book2 = new Book("Clean Code", "987654321", author2);

		Library library = new Library();

        library.addBook(book1);
        library.addBook(book2);

        Borrower borrower = new Borrower("Alice");

        library.borrowBook(borrower, book1);
        library.borrowBook(borrower, book2);

        borrower.displayBorrowedBooks();

        library.returnBook(borrower, book1);

        borrower.displayBorrowedBooks();
        
        library.displayLibraryBooks();
		}
		
    public static void main(String[] args) {
			new Mainlibrary();
    }
}