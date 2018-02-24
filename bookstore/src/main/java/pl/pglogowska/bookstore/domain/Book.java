package pl.pglogowska.bookstore.domain;

import java.math.BigDecimal;
import java.util.List;

public class Book {
    private String isbn;
    private String title;
    private List<Integer> authorIDs;
    private BigDecimal price;
    private List<Integer> genreIDs;
}
