package pl.pglogowska.bookstore.test.acceptance;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.squareup.okhttp.*;
import org.junit.Test;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

public class AddBookToStoreTest {

    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();
    public static final OkHttpClient OK_HTTP_CLIENT = new OkHttpClient();

    @Test
    public void addBookToStore() throws IOException {
        // given
        String isbn = "123-45-6789-5477";
        String title = "Misery";
        int authorID = 1;
        String price = "15.99";
        int genreID = 1;

        ObjectNode objectNode = OBJECT_MAPPER.createObjectNode();
        objectNode.put("isbn", isbn);
        objectNode.put("title", title);
        objectNode.put("price", price);
        objectNode.putArray("authors").add(authorID);
        objectNode.putArray("genre").add(genreID);
        String jsonValue = objectNode.toString();

        // when
        Response response = OK_HTTP_CLIENT.newCall(new Request.Builder()
                .url("http://localhost:8080/book/")
                .put(RequestBody.create(MediaType.parse("appllication/json"), jsonValue))
                .build()).execute();
        // then
        assertThat(response.code()).isEqualTo(200);
        JsonNode responseTree = OBJECT_MAPPER.readTree(response.body().bytes());
        assertThat(responseTree.get("id")).size().isGreaterThan(0);
    }
}
