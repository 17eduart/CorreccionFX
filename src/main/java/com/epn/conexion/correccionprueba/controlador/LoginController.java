package com.epn.conexion.correccionprueba.controlador;

import com.epn.conexion.correccionprueba.modelo.Usuario;
import com.epn.conexion.correccionprueba.vista.HelloApplication;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import org.mindrot.jbcrypt.BCrypt;


import java.io.IOException;

public class LoginController {
    @FXML private TextField txt_user;
    @FXML private PasswordField txt_password;
    @FXML private ComboBox<String> rol;

    private final EntityManager em = Persistence.createEntityManagerFactory("correccionLogin").createEntityManager();
    private final DAOUsuarios daoUsuarios = new DAOUsuarios(em);

    @FXML
    private void initialize(){
        rol.setItems(FXCollections.observableArrayList("ADMIN","Usuario"));
    }

    @FXML
    private void iniciarSesion(){
        String username =txt_user.getText();
        String password = txt_password.getText();
        String rolSeleccionado = rol.getValue();

        Usuario usuario = daoUsuarios.buscarPorUsuario(username);
        if (usuario == null || !BCrypt.checkpw(password, usuario.getPassword())){
            mostrarAlerta(Alert.AlertType.ERROR, "Usuario o contraseña incorrecta");
            return;
        }
        if (rolSeleccionado == null || !rolSeleccionado.equals(usuario.getRol())){
            mostrarAlerta(Alert.AlertType.ERROR, "El rol seleccionado no coincide con el del usuario");
            return;
        }
        abrirOtraPantalla();
    }

    @FXML
    private void registrarse(){
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/com/epn/conexion/correccionprueba/registro-view.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 740, 740);
            Stage stage = (Stage) txt_user.getScene().getWindow();
            stage.setScene(scene);
        }catch (IOException e){
            mostrarAlerta(Alert.AlertType.ERROR, "No se pudo habrir la ventana");
        }
    }

    private void abrirOtraPantalla(){
        try {
            FXMLLoader fxmlLoader =new FXMLLoader(HelloApplication.class.getResource("/com/epn/conexion/correccionprueba/hello-view.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 600, 600);
            Stage stage = (Stage)  txt_user.getScene().getWindow();
            stage.setTitle("Correccion Prueba");
            stage.setScene(scene);
        } catch (IOException e){
            mostrarAlerta(Alert.AlertType.ERROR, "No se pudo abrir la ventana de peliculas ");
        }
    }

    private void mostrarAlerta(Alert.AlertType tipo, String mensaje){
        Alert alerta = new Alert(tipo, mensaje);
        alerta.showAndWait();
    }

}
