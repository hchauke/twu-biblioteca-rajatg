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
    }

    public void displayListOfBooks() {
        System.out.println("+-----------+--------+----------------+");
        System.out.println("| Book Name" + " | " + "Author" + " | " + "Year Published |");
        System.out.println("+-----------+--------+----------------+");
        List<String> books;
        books = library.listAllBooks();
        for(String book : books) {
            System.out.println(book);
        }
    }

    public void displayWelcomeMessage() {
        System.out.println(menu.returnWelcomeMessage());
    }

    public void displayAvailableOptionsToUser() {
        System.out.println(menu.returnTheOptionAvailableToUser());
    }

    public int chooseOption() {
        Scanner scanner = new Scanner(System.in);
        return Integer.parseInt(scanner.nextLine());
    }

    public void displayErrorMessage() {
        System.out.println("Invalid Option!");
    }

    public void showStatusOfCheckOut() {
        Scanner scanner = new Scanner(System.in);
        String nameOfBook = scanner.nextLine();
        boolean result = library.performCheckOut(nameOfBook);
        if (result) {
            System.out.println("Book is successfully checked out..!!");
        }
    }
}
