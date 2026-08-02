package com.epn.conexion.correccionprueba.modelo;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class ImlCrud implements Crud{
    private EntityManager em;
    public ImlCrud(EntityManager em){this.em=em;}

    public List<Inventores> listarTodo(){
        TypedQuery<Inventores> query = em.createQuery("SELECT i FROM Inventores i", Inventores.class);
        return query.getResultList();
    }

    public Inventores buscar(Integer id){
        return em.find(Inventores.class, id);
    }

    public void insertar(Inventores inventores){
        em.getTransaction().begin();
        em.persist(inventores);
        em.getTransaction().commit();
    }
    public void actualizar(Inventores inventores){
        em.getTransaction().begin();
        em.merge(inventores);
        em.getTransaction().commit();
    }
    public void eliminar(Integer id){
        em.getTransaction().begin();
        Inventores inventores = em.find(Inventores.class, id);
        if (inventores != null){
            em.remove(inventores);
        }
        em.getTransaction().commit();
    }
}
