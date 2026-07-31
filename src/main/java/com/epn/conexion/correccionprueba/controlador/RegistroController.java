package com.epn.conexion.correccionprueba.controlador;

import com.epn.conexion.correccionprueba.modelo.Usuario;
import com.epn.conexion.correccionprueba.vista.HelloApplication;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.mindrot.jbcrypt.BCrypt;

import java.io.IOException;

public class RegistroController {
    @FXML private TextField txt_username;
    @FXML private PasswordField txt_password;
    @FXML private TextField txt_correo;
    @FXML private TextField txt_direccion;
    @FXML private ComboBox<String> rol;

    private final EntityManager em = Persistence.createEntityManagerFactory("correccionLogin").createEntityManager();
    private final DAOUsuarios daoUsuarios = new DAOUsuarios(em);

    @FXML
    private void initialize(){
        rol.setItems(FXCollections.observableArrayList("ADMIN","Usuario"));
    }
    @FXML
    private void registrarse(){
        String username =txt_username.getText();
        String password = txt_password.getText();
        String correo = txt_correo.getText();
        String direccion = txt_direccion.getText();
        String rolSeleccionado = rol.getValue();

        if (username.isBlank() || password.isBlank() || rolSeleccionado==null){
            mostrarAlerta(Alert.AlertType.WARNING, "El username y la password son necesarias");
            return;
        }

        if (daoUsuarios.buscarPorUsuario(username)!=null){
            mostrarAlerta(Alert.AlertType.WARNING, "Ese nombre de usuarios ya esta registrado");
            return;
        }
        String hash = BCrypt.hashpw(password, BCrypt.gensalt());
        Usuario usuario = new Usuario(username, hash, correo,direccion,rolSeleccionado);
        daoUsuarios.registrar(usuario);
        mostrarAlerta(Alert.AlertType.INFORMATION, "Usuario Registrado Correctamente. ");
        volverAlLogin();
    }

    private void volverAlLogin(){
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/com/epn/conexion/correccionprueba/login-view.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 483, 375);
            Stage stage = (Stage) txt_username.getScene().getWindow();
            stage.setTitle("Login");
            stage.setScene(scene);
        } catch (IOException e){
            mostrarAlerta(Alert.AlertType.ERROR, "No se pudo volver al login");
        }
    }

    @FXML
    private void borrar(){
        txt_username.clear();
        txt_password.clear();
        txt_correo.clear();
        txt_direccion.clear();
        rol.getSelectionModel().clearSelection();
    }

    private void mostrarAlerta(Alert.AlertType tipo, String mensaje){
        new Alert(tipo, mensaje).showAndWait();
    }
}
