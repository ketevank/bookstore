package pl.pglogowska.bookstore.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.pglogowska.bookstore.domain.Book;
import pl.pglogowska.bookstore.domain.BookRepository;
import pl.pglogowska.bookstore.domain.BookResult;

import java.math.BigDecimal;
import java.util.List;

@Controller
@RequestMapping("/book")
public class BookstoreController {
    @Autowired
    private BookRepository bookRepository;

    @RequestMapping(method = RequestMethod.PUT, value = "/{isbn}")
    public ResponseEntity<BookResult> add(@PathVariable String isbn, @RequestBody BookRequest bookRequest) {
        Book book = map(bookRequest);
        bookRepository.save(book);
        BookResult bookResult = new BookResult(isbn);
        return new ResponseEntity<>(bookResult, HttpStatus.OK);
    }

    private Book map(@RequestBody BookRequest bookRequest) {
        String id = bookRequest.getIsbn();
        String title = bookRequest.getTitle();
        List<Integer> authors = bookRequest.getAuthors();
        List<Integer> genres = bookRequest.getGenres();
        BigDecimal price = new BigDecimal(bookRequest.getPrice());
        return new Book(id, title, authors, price, genres);
    }

    public static class BookRequest {
        private String isbn;
        private String title;
        private List<Integer> authors;
        private String price;
        private List<Integer> genres;

        public String getIsbn() {
            return isbn;
        }

        public void setIsbn(String isbn) {
            this.isbn = isbn;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public List<Integer> getAuthors() {
            return authors;
        }

        public void setAuthors(List<Integer> authors) {
            this.authors = authors;
        }

        public String getPrice() {
            return price;
        }

        public void setPrice(String price) {
            this.price = price;
        }

        public List<Integer> getGenres() {
            return genres;
        }

        public void setGenres(List<Integer> genres) {
            this.genres = genres;
        }
    }
}
