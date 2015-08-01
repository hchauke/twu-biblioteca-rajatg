package com.twu.biblioteca;

import java.util.List;
import java.util.Scanner;


public class View {
    private Menu menu;
    private Library library;

    public View() {
        this.menu = new Menu();
        this.library = new Library();
        library.addBookToLibrary();
        library.addMovieToLibrary();
    }

    private String getString() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public int chooseOption() {
        System.out.print("Choose Option: ");
        try {
            return Integer.parseInt(getString());
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    public void displayWelcomeMessage() {
        System.out.println(menu.returnWelcomeMessage());
    }

    public void displayAvailableOptionsToUser() {
        System.out.println(menu.returnTheOptionAvailableToUser());
    }

    public void displayErrorMessage() {
        System.out.println("Select a valid option!");
    }

    public void displayListOfBooks() {
        String header = String.format("%-20s %-20s %-6s", "BOOK", "AUTHOR", "YEAR");
        System.out.println("\n"+header);
        System.out.println("==================================================");
        List<String> books;
        books = library.listAllBooks();
        for (String book : books) {
            System.out.println(book);
        }
    }

    public void showStatusOfCheckOut() {
        System.out.print("Enter Name of Book: ");
        String nameOfBook = getString();
        if (library.performCheckOutBook(nameOfBook)) {
            System.out.println("Thank you! Enjoy the book.");
        }
        else {
            System.out.println("That book is not available.");
        }
    }

    public void showReturnBookStatus() {
        System.out.print("Enter Name of Book: ");
        String nameOfBook = getString();
        if (library.performReturnBook(nameOfBook)) {
            System.out.println("Thank you for returning the book.");
        }
        else {
            System.out.println("That is not a valid book to return.");
        }
    }

    public void displayListOfMovies() {
        String header = String.format("%-20s %-6s %-20s %-5s", "MOVIE", "YEAR", "DIRECTOR", "RATING");
        System.out.println("\n"+header);
        System.out.println("==========================================================");
        List<String> movies;
        movies = library.listAllMovies();
        for (String movie : movies) {
            System.out.println(movie);
        }
    }
}
