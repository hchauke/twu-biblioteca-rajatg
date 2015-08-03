package com.twu.biblioteca.controller;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;


public class BookSectionTest {

    @Test
    public void shouldReturnListOfBooks() {
        BookSection bookSection = new BookSection();

        int totalBooks = bookSection.listAvailableBooks().size();

        assertEquals(true, totalBooks > 0);
    }

    @Test
    public void shouldReturnListOfCheckedOutBooks() {
        BookSection bookSection = new BookSection();

        bookSection.performCheckOut("Great Rajat");
        int totalCheckedOutBooks = bookSection.listCheckedOutBooks().size();

        assertEquals(true, totalCheckedOutBooks > 0);
    }

    @Test
    public void shouldNotBedAbleToCheckOutBookIfBookIsNotPresent() {
        BookSection bookSection = new BookSection();
        String nameOfBook="my book";

        assertEquals(false, bookSection.performCheckOut(nameOfBook));
    }

    @Test
    public void shouldBeAbleToTakeReturnedBook() {
        BookSection bookSection = new BookSection();

        bookSection.performCheckOut("Great Rajat");

        assertEquals(true, bookSection.performReturn("Great Rajat"));
    }
}
