package org.example.javafxbb;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import java.awt.print.Book;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class HelloController {
    public TextField tfSearch;
    public TextArea taBookList;

    @FXML
    public void onSearchButtonClick(ActionEvent actionEvent) {
        try {
        HttpClient client = HttpClient.newBuilder().build();
        URI urlToCall = URI.create("http://localhost:8080/books?search=" + URLEncoder.encode(tfSearch.getText(), StandardCharsets.UTF_8));
        HttpRequest getAllBooksRequest = HttpRequest.newBuilder()
                .uri(urlToCall)
                .GET()
                .build();

            HttpResponse<String> response;
            response = client.send(getAllBooksRequest, HttpResponse.BodyHandlers.ofString());
            ObjectMapper om = new ObjectMapper();
            List<Book> foundBooks = om.readValue(response.body(), new TypeReference<>() {});
            taBookList.setText(response.body());
        } catch  (Exception e){
            System.err.println("Something went wrong: " + e.getMessage());
        }

    }


}