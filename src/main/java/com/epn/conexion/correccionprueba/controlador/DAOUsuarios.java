package com.epn.conexion.correccionprueba.controlador;

import com.epn.conexion.correccionprueba.modelo.Usuario;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;

public class DAOUsuarios {
    private EntityManager em;
    public DAOUsuarios(EntityManager em){this.em=em;}
    public Usuario buscarPorUsuario(String user){
        try {
            TypedQuery<Usuario> query = em.createQuery(
                    "SELECT u FROM Usuario u WHERE u.username=:username",Usuario.class
            );
            query.setParameter("username",user);
            return query.getSingleResult();
        }catch (NoResultException e){
            return null;
        }
    }
    public void registrar(Usuario usuario){
        try {
            em.getTransaction().begin();
            em.persist(usuario);
            em.getTransaction().commit();
        }catch (RuntimeException e){
            if (em.getTransaction().isActive()) em.getTransaction().rollback();
            throw e;
        }
    }
}
