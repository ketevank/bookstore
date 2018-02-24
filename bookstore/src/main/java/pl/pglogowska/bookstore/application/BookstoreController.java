package pl.pglogowska.bookstore.application;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.pglogowska.bookstore.domain.BookResult;

@Controller
@RequestMapping("/book")
public class BookstoreController {
    @RequestMapping(method = RequestMethod.PUT, value = "/{isbn}")
    public BookResult add(@PathVariable String isbn) {
        return null;
    }
}
