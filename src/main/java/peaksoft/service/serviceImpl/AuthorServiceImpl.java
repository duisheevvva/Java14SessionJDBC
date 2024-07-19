package peaksoft.service.serviceImpl;

import peaksoft.dao.AuthorDao;
import peaksoft.dao.daoImpl.AuthorDaoImpl;
import peaksoft.model.Author;
import peaksoft.service.AuthorService;

import java.util.List;

public class AuthorServiceImpl implements AuthorService {
    private final AuthorDao authorDao = new AuthorDaoImpl();
    @Override
    public void createTableAuthor() {
        authorDao.createTableAuthor();
    }

    @Override
    public String saveAuthor(Author author) {
        return authorDao.saveAuthor(author);
    }

    @Override
    public List<Author> getAllAuthor() {
        return authorDao.getAllAuthor();
    }

    @Override
    public Author getById(Long authorId) {
        return null;
    }

    @Override
    public String updateAuthor(Long authorId, Author newAuthor) {
        return authorDao.updateAuthor(authorId,newAuthor);
    }

    @Override
    public void deleteAuthor(Long authorId) {
        authorDao.deleteAuthor(authorId);
    }

    @Override
    public void dropTableAuthor() {

    }

    @Override
    public void cleanTableAuthor() {

    }

    @Override
    public List<Author> sortByDateOfBirth() {
        return null;
    }
}
