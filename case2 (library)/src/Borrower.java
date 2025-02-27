import java.util.*;

public class Borrower{
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
