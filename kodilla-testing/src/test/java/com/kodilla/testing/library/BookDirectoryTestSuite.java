package com.kodilla.testing.library;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class BookDirectoryTestSuite {
    @Mock
    private LibraryDatabase libraryDatabaseMock;

    @Test
    void testListBooksWithConditionsReturnList() {

        // Given
        BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);                  // [3]
        List<Book> resultListOfBooks = new ArrayList<>();                                // [4]
        Book book1 = new Book("Secrets of Alamo", "John Smith", 2008);                   // [5]
        Book book2 = new Book("Secretaries and Directors", "Dilbert Michigan", 2012);    // [6]
        Book book3 = new Book("Secret life of programmers", "Steve Wolkowitz", 2016);    // [7]
        Book book4 = new Book("Secrets of Java", "Ian Tenewitch", 2010);                 // [8]
        resultListOfBooks.add(book1);                                                    // [9]
        resultListOfBooks.add(book2);                                                    // [10]
        resultListOfBooks.add(book3);                                                    // [11]
        resultListOfBooks.add(book4);                                                    // [12]
        when(libraryDatabaseMock.listBooksWithCondition("Secret")).thenReturn(resultListOfBooks);// [13]

        // When
        List<Book> theListOfBooks = bookLibrary.listBooksWithCondition("Secret");        // [14]

        // Then
        assertEquals(4, theListOfBooks.size());

    }
    private List<Book> generateListOfNBooks(int booksQuantity) {
        List<Book> resultList = new ArrayList<>();
        for (int n = 1; n <= booksQuantity; n++) {
            Book theBook = new Book("Title " + n, "Author " + n, 1970 + n);
            resultList.add(theBook);
        }
        return resultList;
    }

    @Test
    void testListBookWithConditionMoreThan20() {

// Given
        BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);                  // [1]
        List<Book> resultListOf0Books = new ArrayList<Book>();                           // [2]
        List<Book> resultListOf15Books = generateListOfNBooks(15);                       // [3]
        List<Book> resultListOf40Books = generateListOfNBooks(40);                       // [4]
        when(libraryDatabaseMock.listBooksWithCondition(anyString()))                    // [5]
                .thenReturn(resultListOf15Books);                                             // [6]
        when(libraryDatabaseMock.listBooksWithCondition("ZeroBooks"))                    // [7]
                .thenReturn(resultListOf0Books);                                              // [8]
        when(libraryDatabaseMock.listBooksWithCondition("FortyBooks"))                   // [9]
                .thenReturn(resultListOf40Books);                                             // [10]

        // When
        List<Book> theListOfBooks0 = bookLibrary.listBooksWithCondition("ZeroBooks");    // [11]
        List<Book> theListOfBooks15 = bookLibrary.listBooksWithCondition("Any title");   // [12]
        List<Book> theListOfBooks40 = bookLibrary.listBooksWithCondition("FortyBooks");  // [13]
        // Then

        assertEquals(0, theListOfBooks0.size());                                         // [14]
        assertEquals(15, theListOfBooks15.size());                                       // [15]
        assertEquals(0, theListOfBooks40.size());                                        // [16]
    }

   @Test
    void testListBookWithConditionFragmentShorterThan3() {
       // Given
       LibraryDatabase libraryDatabaseMock = mock(LibraryDatabase.class);            // [2]
       BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);               // [3]

       // When
       List<Book> theListOfBooks10 = bookLibrary.listBooksWithCondition("An");       // [4]

       // Then
       assertEquals(0, theListOfBooks10.size());                                     // [5]
       verify(libraryDatabaseMock, times(0)).listBooksWithCondition(anyString());    // [6]
   }
    @Test
    void testWhenUserDoesNotHaveABorrowedBook() {
        //Given
        BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
        List<Book> emptyListOfBooks = new ArrayList<Book>();
        LibraryUser libraryUser = new LibraryUser("Adam","Kowalski","86010714320");

        when(libraryDatabaseMock.listBooksInHandsOf(libraryUser))
                .thenReturn(emptyListOfBooks);
        //When
        List<Book> resultListOfBook = bookLibrary.listBooksInHandsOf(libraryUser);
       //Then
        assertEquals(0, resultListOfBook.size());
    }
    @Test
    void testWhenUserHaveBorrowedOneBook() {
        //Given
        BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
        List<Book> oneBookList = new ArrayList<Book>();
        Book book = new Book("Secret","Ethan Hawk",2013);
        oneBookList.add(book);
        LibraryUser libraryUser = new LibraryUser("Adam","Kowalski","86010714320");

        when(libraryDatabaseMock.listBooksInHandsOf(libraryUser))
                .thenReturn(oneBookList);
        //When
        List<Book> resultListOfBook = bookLibrary.listBooksInHandsOf(libraryUser);
        //Then
        assertEquals(1, resultListOfBook.size());
    }

    @Test
    void testWhenUserHaveBorrowedFiveBook() {
        //Given
        BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
        List<Book> fiveBookList = new ArrayList<Book>();
        LibraryUser libraryUser = new LibraryUser("Adam","Kowalski","86010714320");
        Book book = new Book("Secret","Ethan Hawk",2013);
        fiveBookList.add(book);
        fiveBookList.add(book);
        fiveBookList.add(book);
        fiveBookList.add(book);
        fiveBookList.add(book);
        when(libraryDatabaseMock.listBooksInHandsOf(libraryUser))
                .thenReturn(fiveBookList);
        //When
        List<Book> resultListOfBook = bookLibrary.listBooksInHandsOf(libraryUser);
        //Then
        assertEquals(5, resultListOfBook.size());
    }
   }


