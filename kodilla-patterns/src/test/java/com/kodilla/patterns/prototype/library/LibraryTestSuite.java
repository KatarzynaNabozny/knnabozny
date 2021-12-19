package com.kodilla.patterns.prototype.library;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class LibraryTestSuite {

    @Test
    void testGetBooks() {
        //given
        Library library = new Library("Library");

        List<Book> listBook = new ArrayList<Book>();
        Book book1 = new Book("Hr", "Br", LocalDate.now());
        listBook.add(book1);
        listBook.add(new Book("Cr", "Cr", LocalDate.now()));
        listBook.add(new Book("Dr", "Dr", LocalDate.now()));
        library.getBooks().addAll(listBook);
        Library clonedLibrary = null;
        try {
            clonedLibrary = library.shallowCopy();
            clonedLibrary.getName();
        } catch (CloneNotSupportedException e) {
            System.out.println(e);
        }
        Library deepClonedLibrary = null;
        try {
            deepClonedLibrary = library.deepCopy();
            deepClonedLibrary.getName();
        } catch (CloneNotSupportedException e) {
            System.out.println(e);
        }
        //when
        library.getBooks().remove(book1);

        //then

        Assertions.assertEquals(2, clonedLibrary.getBooks().size());
        Assertions.assertEquals(3, deepClonedLibrary.getBooks().size());
        Assertions.assertEquals(2, library.getBooks().size());

    }
}
