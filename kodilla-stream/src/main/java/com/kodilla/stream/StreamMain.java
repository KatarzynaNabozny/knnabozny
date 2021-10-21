package com.kodilla.stream;


//import com.kodilla.stream.beautifier.PoemBeautifier;
//import com.kodilla.stream.book.Book;
//import com.kodilla.stream.book.BookDirectory;
import com.kodilla.stream.forumuser.Forum;
import com.kodilla.stream.forumuser.ForumUser;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
//import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


public class StreamMain {

    public static void main(String[] args) {
        ForumUser Edd18 = new ForumUser(1,"Edd18",'M', LocalDate.of(2007,12,7),0);
        ForumUser Edd19 = new ForumUser(2,"Edd19",'M', LocalDate.of(2010,12,7),12);
        ForumUser Edd20 = new ForumUser(3,"Edd20",'M', LocalDate.of(1998,12,7),2);
        ForumUser Edd21 = new ForumUser(4,"Edd21",'M', LocalDate.of(1997,12,7),5);
        ForumUser Edd22 = new ForumUser(5,"Edith22",'F', LocalDate.of(2001,12,7),15);

        Forum forum = new Forum();
        forum.addForumUser(Edd18);
        forum.addForumUser(Edd19);
        forum.addForumUser(Edd20);
        forum.addForumUser(Edd21);
        forum.addForumUser(Edd22);

        Map<Integer, ForumUser> collect = forum.getUserList().stream()
                .filter(forumUser -> forumUser.getSex() == 'M')
                .filter(forumUser -> (ChronoUnit.YEARS.between(forumUser.getDateOfBirth(), LocalDate.now())) > 20)
                .filter(forumUser -> forumUser.getNumberOfPosts() > 1)
                .collect(Collectors.toMap(ForumUser::getUniqueUserID, forumUser -> forumUser));

        collect.entrySet().stream().forEach(System.out::println);

        //PoemBeautifier poemBeautifier = new PoemBeautifier();
        //poemBeautifier.beautify("Some text 1", text -> text);
        //poemBeautifier.beautify("Some text 2", text -> text.toUpperCase());
        //poemBeautifier.beautify("Some text 3", text -> text.toLowerCase());
        //poemBeautifier.beautify("Some text 4", text -> text + "*");
        /*
        BookDirectory theBookDirectory = new BookDirectory();
        //List<Book> theResultListOfBooks =
        Map<String,Book>theResultMapOfBooks =
                theBookDirectory.getList().stream()
                        .filter(book -> book.getYearOfPublication() >2005)
                        //.collect(Collectors.toList());
                                .collect(Collectors.toMap(Book::getSignature, book -> book));
        System.out.println("#elements: " + theResultMapOfBooks.size());
       // theResultListOfBooks.stream()
        theResultMapOfBooks.entrySet().stream()
                .map(entry -> entry.getKey() + ": " + entry.getValue())
                .forEach(System.out::println);
        */
    }
}