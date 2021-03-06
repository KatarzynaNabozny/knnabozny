package com.kodilla.testing.library;

import java.util.ArrayList;
import java.util.List;

public class BookLibrary {
    private LibraryDatabase libraryDatabase;

    public BookLibrary(LibraryDatabase libraryDatabase) {
        this.libraryDatabase = libraryDatabase;
    }

    public List<Book> listBooksWithCondition(String titleFragment) {
        List<Book> bookList = new ArrayList<>();
        if (titleFragment.length() < 3) {
            return bookList;
        }
        List<Book> resultList = libraryDatabase.listBooksWithCondition(titleFragment);
        if (resultList.size() > 20) {
            return bookList;
        }
        bookList = resultList;
        // Book book = new Book("The book title", "The book author", 2000);
        // bookList.add(book);

        // temporary returning list of one book
        return bookList;
    }
    public List<Book> listBooksInHandsOf(LibraryUser libraryUser) {
List<Book>listBook = new ArrayList<>();
        if (libraryUser == null) {
            return listBook;
        }
        listBook = libraryDatabase.listBooksInHandsOf(libraryUser);
        return listBook;
    }
}
