package com.esocial.esocialsystems.test;

import com.esocial.esocialsystems.dao.JPAUtil;
import jakarta.persistence.EntityManager;

public class TestConnexion {
    public static void main(String[] args) {
        System.out.println("Trying to connect to database...");

        try {
            EntityManager em = JPAUtil.getEntityManager();

            if (em != null) {
                System.out.println("Success : The connection JDBC/JPA working perfectly !");
                System.out.println("Hibernate was able to communicate with 'esocial_db'.");
                em.close();
            }
        } catch (Exception e) {
            System.err.println("Failed : Connection to JDBC/JPA could not be established.");
            System.err.println("Error details : " + e.getMessage());
            e.printStackTrace();
        } finally {
            JPAUtil.close();
        }
    }
}