package com.thoughtworks.library;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormatter;
import org.junit.Test;
import org.junit.Before;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Matchers.contains;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class LibraryTest {


    /*

        List books tests. Implement the first three tests for the Verify exercise

     */

    private List<String> books;
    private PrintStream printStream;


    @Before
    public void setUp() {
        books = new ArrayList<>();
        printStream = mock(PrintStream.class);
    }

    @Test
    public void shouldPrintBookTitleWhenThereIsOneBook() {

        String title = "Book Title";
        books.add(title);
        Library library = new Library(books, printStream, null);

        library.listBooks();

        verify(printStream).println(title);
    }

    @Test
    public void shouldPrintNothingWhenThereAreNoBooks() {
        Library library = new Library(books, printStream, null);
        library.listBooks();
        verify(printStream, Mockito.never()).println("never happened");
    }

    @Test
    public void shouldPrintBothBookTitlesWhenThereAreTwoBooks() {
        String title1 = "Compost: Do You Love Your Worms?";
        String title2 = "Frogs: It's a Party in the Pond";
        books.add(title1);
        books.add(title2);

        Library library = new Library(books, printStream, null);

        library.listBooks();

        InOrder inOrder = Mockito.inOrder(printStream, printStream);
        inOrder.verify(printStream).println(title1);
        inOrder.verify(printStream).println(title2);
    }

    /*

        Welcome message tests. Implement these tests for the when/thenReturn exercise

     */

    
    // This one is done for you
    @Test
    public void shouldWelcomeUser() {
        List<String> books = new ArrayList<>();
        PrintStream printStream = mock(PrintStream.class);
        DateTimeFormatter dateTimeFormatter = mock(DateTimeFormatter.class);
        Library library = new Library(books, printStream, dateTimeFormatter);

        // We don't need to mock DateTime because it is a value object
        // We can't mock it because it is a final class
        DateTime time = new DateTime();
        
        library.welcome(time);
        
        verify(printStream).println(contains("Welcome"));
    }
    
    @Test
    public void shouldDisplayFormattedTime() {
        List<String> books = new ArrayList<>();
        PrintStream printStream = mock(PrintStream.class);
        DateTime time = new DateTime();
        DateTimeFormatter dateTimeFormatter = mock(DateTimeFormatter.class);

        when(dateTimeFormatter.print(time)).thenReturn("FormattedTimeString");

        Library library = new Library(books, printStream, dateTimeFormatter);

        library.welcome(time);

        // add a verify here
    }

    @Test
    public void shouldDisplayFormattedTimeWhenItIsAnEmptyString() {

        // implement me
    }
}