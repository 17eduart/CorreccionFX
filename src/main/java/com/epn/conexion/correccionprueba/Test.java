package com.epn.conexion.correccionprueba;

import com.epn.conexion.correccionprueba.modelo.Crud;
import com.epn.conexion.correccionprueba.modelo.ImlCrud;
import com.epn.conexion.correccionprueba.modelo.Inventores;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;

public class Test {
    public static void main(String[] args) {
        EntityManager em = Persistence.createEntityManagerFactory("correccionLogin").createEntityManager();
        Crud crud = new ImlCrud(em);
        for (Inventores i: crud.listarTodo()){
            System.out.println(i);
        }
    }
}
