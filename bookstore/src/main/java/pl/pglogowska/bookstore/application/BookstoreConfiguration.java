package pl.pglogowska.bookstore.application;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import pl.pglogowska.bookstore.domain.Book;
import pl.pglogowska.bookstore.domain.BookRepository;

@Controller
public class BookstoreConfiguration {

    @Bean
    public BookRepository bookRepository(){
        return new BookRepository() {
            @Override
            public void save(Book book) {

            }
        };
    }
}
