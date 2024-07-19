package peaksoft.service;

import peaksoft.model.Author;

import java.util.List;

public interface AuthorService {
    void createTableAuthor();
    String saveAuthor(Author author);
    List<Author> getAllAuthor();
    Author getById(Long authorId);
    String updateAuthor (Long authorId,Author newAuthor);
    void deleteAuthor(Long authorId);
    void dropTableAuthor();
    void cleanTableAuthor();
    List<Author> sortByDateOfBirth();
}
