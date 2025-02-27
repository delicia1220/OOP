import java.util.*;

public class Library{
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
