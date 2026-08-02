package com.epn.conexion.correccionprueba.modelo;

import java.util.List;

public interface Crud {
    public List<Inventores> listarTodo();

    public Inventores buscar(Integer id);

    void insertar(Inventores inventores);
    void actualizar(Inventores inventores);
    void eliminar(Integer id);
}
