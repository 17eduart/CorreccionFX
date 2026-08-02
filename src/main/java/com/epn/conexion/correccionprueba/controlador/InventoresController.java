package com.epn.conexion.correccionprueba.controlador;

import com.epn.conexion.correccionprueba.modelo.Crud;
import com.epn.conexion.correccionprueba.modelo.ImlCrud;
import com.epn.conexion.correccionprueba.modelo.Inventores;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class InventoresController {
    @FXML private TextField txt_id;
    @FXML private TextField txt_nombre;
    @FXML private TextField txt_pais;
    @FXML private TextField txt_nacimiento;
    @FXML private TextField txt_fallecimiento;
    @FXML private TextField txt_invento;

    @FXML private TableView<Inventores> tabla_mostrar;
    @FXML private TableColumn<Inventores, Integer> t_id;
    @FXML private TableColumn<Inventores, String> t_nombre;
    @FXML private TableColumn<Inventores, String> t_pais;
    @FXML private TableColumn<Inventores, Integer> t_nacimiento;
    @FXML private TableColumn<Inventores, Integer> t_fallecimiento;
    @FXML private TableColumn<Inventores, String> t_invento;

    private final EntityManager em = Persistence.createEntityManagerFactory("correccionLogin").createEntityManager();
    private final Crud crud = new ImlCrud(em);
    private final ObservableList<Inventores> datos = FXCollections.observableArrayList();

    @FXML
    public void initialize(){
        t_id.setCellValueFactory(new PropertyValueFactory<>("id"));
        t_nombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        t_pais.setCellValueFactory(new PropertyValueFactory<>("pais"));
        t_nacimiento.setCellValueFactory(new PropertyValueFactory<>("nacimiento"));
        t_fallecimiento.setCellValueFactory(new PropertyValueFactory<>("fallecimiento"));
        t_invento.setCellValueFactory(new PropertyValueFactory<>("invento_principal"));
        tabla_mostrar.setItems(datos);

        tabla_mostrar.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) ->{
            if (newValue != null){
                mostrarFormulario(newValue);
            }
        } );
        cargarTabla();
    }

    @FXML
    public void Añadir(){
        Inventores inventores = new Inventores(txt_nombre.getText(),txt_pais.getText(), Integer.parseInt(txt_nacimiento.getText()), Integer.parseInt(txt_fallecimiento.getText()), txt_invento.getText());
        crud.insertar(inventores);
        cargarTabla();
        eliminarDatos();
    }

    @FXML
    public void Actualizar(){
        Inventores inventores = new Inventores(txt_nombre.getText(),txt_pais.getText(), Integer.parseInt(txt_nacimiento.getText()), Integer.parseInt(txt_fallecimiento.getText()), txt_invento.getText());
        crud.actualizar(inventores);
        cargarTabla();
        eliminarDatos();
    }
    @FXML
    public void Buscar(){
        Inventores inventores = crud.buscar(Integer.parseInt(txt_id.getText()));
        if (inventores != null){
            mostrarFormulario(inventores);
        }
    }

    @FXML
    public void Eliminar(){
        crud.eliminar(Integer.parseInt(txt_id.getText()));
        cargarTabla();
    }

    @FXML
    private void eliminarDatos(){
        txt_nombre.clear();
        txt_pais.clear();
        txt_nacimiento.clear();
        txt_fallecimiento.clear();
        txt_invento.clear();
    }

    public void cargarTabla(){
        datos.setAll(crud.listarTodo());
    }

    public void mostrarFormulario(Inventores inventores){
        txt_id.setText(String.valueOf(inventores.getId()));
        txt_nombre.setText(inventores.getNombre());
        txt_pais.setText(inventores.getPais());
        txt_nacimiento.setText(String.valueOf(inventores.getNacimiento()));
        txt_fallecimiento.setText(String.valueOf(inventores.getFallecimiento()));
        txt_invento.setText(inventores.getInvento_principal());
    }

}
