package it.unicam.cs.pa.pacal;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class JavaFXPaCal extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/PACal.fxml"));

        stage.setTitle("PaCal...");
        stage.setScene(new Scene(root, 400, 500));
        stage.show();

    }
}
