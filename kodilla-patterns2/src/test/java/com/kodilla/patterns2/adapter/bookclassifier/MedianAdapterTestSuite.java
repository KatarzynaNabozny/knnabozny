package com.kodilla.patterns2.adapter.bookclassifier;

import com.kodilla.patterns2.adapter.bookclassifier.librarya.Book;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;


public class MedianAdapterTestSuite {
    @Test
    public void publicationYearMedianTest() {
        // Given
        Set<Book> books = new HashSet<Book>();
        books.add(new Book("john", "rano", 1999, "fsfs"));
        books.add(new Book("john", "ranos", 1998, "fsfsfs"));
        books.add(new Book("john", "ranov", 1997, "fsfssdgs"));

        // When
        MedianAdapter medianAdapter = new MedianAdapter();
        int result =  medianAdapter.publicationYearMedian(books);
        // Then
        Assertions.assertEquals(1998,result);
    }
}

