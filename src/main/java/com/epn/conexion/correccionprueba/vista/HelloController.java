package com.epn.conexion.correccionprueba.vista;

import com.epn.conexion.correccionprueba.modelo.Usuario;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class HelloController {
    @FXML
    private Label welcomeText;

    private Usuario usuarioActual;

    public void setUsuario(Usuario usuario){
        this.usuarioActual = usuario;
        welcomeText.setText("Bienvenido, "+usuario.getUsername()+"( "+usuario.getRol()+")");
    }

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
}
