package com.epn.conexion.correccionprueba.vista;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/com/epn/conexion/correccionprueba/login-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 620, 640);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }
}
