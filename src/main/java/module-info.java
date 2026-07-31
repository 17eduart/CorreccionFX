module com.epn.conexion.correccionPrueba {
    requires javafx.controls;
    requires javafx.fxml;
    requires mysql.connector.j;
    requires jbcrypt;


    requires jakarta.persistence;
    requires org.hibernate.orm.core;

    exports com.epn.conexion.correccionprueba.vista;
    opens com.epn.conexion.correccionprueba.vista to javafx.fxml;


    opens com.epn.conexion.correccionprueba.controlador to javafx.fxml;
    exports com.epn.conexion.correccionprueba.controlador;

    opens com.epn.conexion.correccionprueba.modelo to org.hibernate.orm.core;

    exports com.epn.conexion.correccionprueba.modelo;
}