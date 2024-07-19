package peaksoft.dao;

import peaksoft.model.Book;

import java.util.List;

public interface BookDao {
    void  createTableBook();
    //    CRUD
    String saveBook(Book book);

    //   DOP methods
    List<Book> getAllBookByAuthorID(Long authorId);
    List<Book> sortedBookByPrice();
    void deleteBooksFromAuthor(Long authorId);


}
