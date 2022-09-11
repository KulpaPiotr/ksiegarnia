package pl.sda.library.hibernate;

import lombok.extern.slf4j.Slf4j;
import pl.sda.library.common.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

@Slf4j
class LibraryMain {

    private static EntityManagerFactory entityManagerFactory;
    private static EntityManager entityManager;
    private static BooksRepository booksRepository;

    public static void main(String[] args) throws SQLException {
        entityManagerFactory = Persistence.createEntityManagerFactory("mysql-library");
        entityManager = entityManagerFactory.createEntityManager();
        booksRepository = new BooksJpaRepository(entityManager);


        entityManager.close();
        entityManagerFactory.close();
    }

    private static void testCreateBook() throws SQLException {
        var simpleCategory = new Category();
        simpleCategory.setId(100);
        simpleCategory.setName("Simple category");

        var simpleAuthor = new Author();
        simpleAuthor.setId(100);
        simpleAuthor.setFirstName("My first name");
        simpleAuthor.setLastName("My last name");

        var bookDetails = new BookDetails();
        bookDetails.setId(100);
        bookDetails.setTitle("Simple title");
        bookDetails.setPublisher("Simple publisher");
        bookDetails.setCategory(simpleCategory);
        bookDetails.setAuthor(simpleAuthor);
        bookDetails.setReleaseDate(Date.valueOf(LocalDate.of(2020, 7, 31)));
        booksRepository.createBook(bookDetails);
    }

    private static void testGetBooksCount() throws SQLException {
        long booksCount = booksRepository.getBooksCount();
        log.info("Books count: {}", booksCount);
    }

    private static void testDeleteBookById() throws SQLException {
        booksRepository.deleteBookById(50);
    }

    private static void testGetBookDetailsInfoById() throws SQLException {
        var bookBasicInfoOpt = booksRepository.getBookBasicInfoById(50);
        bookBasicInfoOpt.ifPresent(bookBasicInfo -> log.info("Found: {}", bookBasicInfo));
    }

    private static void testGetAllBooks() throws SQLException {
        List<BookBasicInfo> allBooks = booksRepository.getAllBooks();
        for (BookBasicInfo bookBasicInfo : allBooks) {
            log.info("{}", bookBasicInfo);
        }
    }
}
