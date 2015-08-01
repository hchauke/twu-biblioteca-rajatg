package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;


public class Library {
    private List<Book> availableBooks;
    private List<Book> checkedOutBooks;
    private List<Movie> availableMovies;

    public Library() {
        this.availableBooks = new ArrayList<Book>();
        this.checkedOutBooks = new ArrayList<Book>();
        this.availableMovies = new ArrayList<Movie>();
    }

    public void addBookToLibrary() {
        availableBooks.add(new Book("Great Rajat", "Gatsby", "2015"));
        availableBooks.add(new Book("Incredible Rajat", "Tyrion Lannister", "2010"));
        availableBooks.add(new Book("Have Fun", "Rajat", "2012"));
        availableBooks.add(new Book("I know nothing", "Jon Snow", "2011"));
        availableBooks.add(new Book("valar morghulis", "Khalisi", "2010"));
    }

    public void addMovieToLibrary() {
        availableMovies.add(new Movie("XXX", "2010", "John Doe", "7.2"));
        availableMovies.add(new Movie("XXX 2", "2010", "John Doe", "4.2"));
        availableMovies.add(new Movie("X-Men", "2012", "John Doe", "8.2"));
        availableMovies.add(new Movie("Shawshank Redemption", "1994", "John Doe", "9.2"));
        availableMovies.add(new Movie("Hulk", "2007", "John Doe", "7.0"));
    }

    public boolean performCheckOutBook(String nameOfBook) {
        Book requiredBook = this.searchBookByName(nameOfBook, availableBooks);
        if (requiredBook == null || (checkedOutBooks.contains(requiredBook))) {
            return false;
        }
        return checkOut(requiredBook);
    }

    public boolean performReturnBook(String nameOfBook) {
        Book requiredBook = this.searchBookByName(nameOfBook, checkedOutBooks);
        if (requiredBook == null || (availableBooks.contains(requiredBook))) {
            return false;
        }
        return checkIn(requiredBook);
    }

    private boolean checkOut(Book book) {
        return (checkedOutBooks.add(book) && availableBooks.remove(book));
    }

    private boolean checkIn(Book book) {
        return (checkedOutBooks.remove(book) && availableBooks.add(book));
    }

    private Book searchBookByName(String nameOfBook, List<Book> booksList) {
        Book searchedBook = null;
        for(Book book : booksList) {
            if (book.hasTitle(nameOfBook)) {
                searchedBook = book;
                break;
            }
        }
        return searchedBook;
    }

    public List<Book> listAllBooks() {
        List<Book> books = new ArrayList<Book>();
        for (Book book : availableBooks) {
            books.add(book);
        }
        return books;
    }

    public List<Movie> listAllMovies() {
        List<Movie> movies = new ArrayList<Movie>();
        for (Movie movie : availableMovies) {
            movies.add(movie);
        }
        return movies;
    }
}
