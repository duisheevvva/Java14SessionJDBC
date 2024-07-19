package peaksoft.dao.daoImpl;

import peaksoft.config.JdbcConfig;
import peaksoft.dao.AuthorDao;
import peaksoft.model.Author;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AuthorDaoImpl implements AuthorDao {
    private final Connection connection = JdbcConfig.getConnection();

    @Override
    public void createTableAuthor() {
        String sql = """
                create table if not exists authors(
                id serial primary key,
                first_name varchar,
                last_name  varchar,
                email varchar,
                country varchar,
                date_of_birth date);
                """;
        try (Statement statement = connection.createStatement()) {
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    @Override
    public String saveAuthor(Author author) {
        String sql = """
                insert into authors (first_name,last_name,email,country,date_of_birth)
                values (?,?,?,?,?)
                """;
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, author.getFirstName());
            preparedStatement.setString(2, author.getLastName());
            preparedStatement.setString(3, author.getEmail());
            preparedStatement.setString(4, author.getCountry());
            preparedStatement.setDate(5, Date.valueOf(author.getDateOfBirth()));
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return "Success";
    }

    @Override
    public List<Author> getAllAuthor() {
        List<Author> authors = new ArrayList<>();
        String sql = "select * from authors";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                authors.add(new Author(resultSet.getLong("id"),
                        resultSet.getString("first_name"),
                        resultSet.getString("last_name"),
                        resultSet.getString("email"),
                        resultSet.getString("country"),
                        resultSet.getDate("date_of_birth").toLocalDate()
                ));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return authors;
    }

    @Override
    public Author getById(Long authorId) {
        return null;
    }

    @Override
    public String updateAuthor(Long authorId, Author newAuthor) {
        String sql = """
                update authors set first_name = ?,
                last_name = ?,
                email = ?,
                country = ?,
                date_of_birth = ?
                where id = ?
                """;
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, newAuthor.getFirstName());
            preparedStatement.setString(2, newAuthor.getLastName());
            preparedStatement.setString(3, newAuthor.getEmail());
            preparedStatement.setString(4, newAuthor.getCountry());
            preparedStatement.setDate(5, Date.valueOf(newAuthor.getDateOfBirth()));
            preparedStatement.setLong(6,authorId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return "Success";
    }

    @Override
    public void deleteAuthor(Long authorId) {
        String sql = " delete from authors where id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setLong(1,authorId);
           int rows= preparedStatement.executeUpdate();
           if (rows>0){
               System.out.println("Success ");
           }else System.out.println("not found");
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void dropTableAuthor() {

    }

    @Override
    public void cleanTableAuthor() {

    }

    @Override
    public List<Author> sortByDateOfBirth() {
        List<Author> authors = new ArrayList<>();
        String sql = "select * from authors order by date_of_birth desc";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                authors.add(new Author(resultSet.getLong("id"),
                        resultSet.getString("first_name"),
                        resultSet.getString("last_name"),
                        resultSet.getString("email"),
                        resultSet.getString("country"),
                        resultSet.getDate("date_of_birth").toLocalDate()
                ));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return authors;
    }
}
