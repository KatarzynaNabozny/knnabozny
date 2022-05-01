package com.kodilla.patterns2.adapter.bookclassifier;

import com.kodilla.patterns2.adapter.bookclassifier.libraryb.Book;
import com.kodilla.patterns2.adapter.bookclassifier.libraryb.BookSignature;
import com.kodilla.patterns2.adapter.bookclassifier.libraryb.BookStatistics;
import com.kodilla.patterns2.adapter.bookclassifier.libraryb.Statistics;

import java.util.Map;


public class MedianAdaptee implements BookStatistics {

    @Override
    public int averagePublicationYear(Map<BookSignature, Book> books) {
        Statistics theStatistics = new Statistics();
        return theStatistics.averagePublicationYear(books);

    }

    @Override
   public int medianPublicationYear(Map<BookSignature, Book> books) {
        Statistics theStatistics = new Statistics();
        return theStatistics.medianPublicationYear(books);

    }
}
