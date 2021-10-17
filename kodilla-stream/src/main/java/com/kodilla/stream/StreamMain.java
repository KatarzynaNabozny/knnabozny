package com.kodilla.stream;


import com.kodilla.stream.beautifier.PoemBeautifier;
import com.kodilla.stream.book.BookDirectory;


public class StreamMain {

    public static void main(String[] args) {
        PoemBeautifier poemBeautifier = new PoemBeautifier();
        poemBeautifier.beautify("Some text 1", text -> text);
        poemBeautifier.beautify("Some text 2", text -> text.toUpperCase());
        poemBeautifier.beautify("Some text 3", text -> text.toLowerCase());
        poemBeautifier.beautify("Some text 4", text -> text + "*");

        // BookDirectory theBookDirectory = new BookDirectory();
        // theBookDirectory.getList().stream()
        //  .filter(book -> book.getYearOfPublication() >2005)
        //  .forEach(System.out::println);

    }
}