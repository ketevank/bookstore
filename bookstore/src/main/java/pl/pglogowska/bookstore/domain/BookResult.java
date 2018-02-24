package pl.pglogowska.bookstore.domain;

public class BookResult {
    private String id;

    public BookResult(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
