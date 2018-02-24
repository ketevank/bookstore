package pl.pglogowska.bookstore.domain;

import java.math.BigDecimal;
import java.util.List;

public class Book {
    private String isbn;
    private String title;
    private List<Integer> authorIDs;
    private BigDecimal price;
    private List<Integer> genreIDs;

    public Book(String isbn, String title, List<Integer> authorIDs, BigDecimal price, List<Integer> genreIDs) {

        this.isbn = isbn;
        this.title = title;
        this.authorIDs = authorIDs;
        this.price = price;
        this.genreIDs = genreIDs;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getTitle() {
        return title;
    }

    public List<Integer> getAuthorIDs() {
        return authorIDs;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public List<Integer> getGenreIDs() {
        return genreIDs;
    }
}
