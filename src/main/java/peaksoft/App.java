package peaksoft;

import peaksoft.model.Author;
import peaksoft.service.AuthorService;
import peaksoft.service.serviceImpl.AuthorServiceImpl;

import java.time.LocalDate;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        AuthorService authorService = new AuthorServiceImpl();
//        System.out.println("Create table");
//        authorService.createTableAuthor();
//        System.out.println("Save author");
//        System.out.println(authorService.saveAuthor(new Author("Joomart", "ishenbaev", "a@gmail.com", "KG", LocalDate.of(1999, 03, 03))));
        System.out.println("Get all authors");
        System.out.println(authorService.getAllAuthor());

//        System.out.println("Update");
//        System.out.println(authorService.updateAuthor(2L, new Author("Baktulan", "Nazirbek uulu", "a@gmail.com", "KG", LocalDate.of(1999, 03, 03))));
//        System.out.println(authorService.getAllAuthor());

         authorService.deleteAuthor(1L);
        System.out.println(authorService.getAllAuthor());

    }
}
