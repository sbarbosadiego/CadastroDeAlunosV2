package com.localhost.cadastrodealunosv2.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * @author Diego Barbosa da Silva
 */
public class Conexao {

    private static EntityManagerFactory factory;
    protected static EntityManager entityManager;

    static {
        try {
            factory = Persistence.createEntityManagerFactory("conexao-Mysql");
            entityManager = factory.createEntityManager();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Conexao conectar() {
        entityManager.getTransaction().begin();
        return this;
    }

    public Conexao desconectar() {
        entityManager.getTransaction().commit();
        return this;
    }

    public void fecharConexao() {
        entityManager.close();
    }

}
