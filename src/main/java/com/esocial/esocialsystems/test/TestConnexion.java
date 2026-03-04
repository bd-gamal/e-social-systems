package com.esocial.esocialsystems.test;

import com.esocial.esocialsystems.dao.JPAUtil;
import jakarta.persistence.EntityManager;

public class TestConnexion {
    public static void main(String[] args) {
        System.out.println("⏳ Tentative de connexion à la base de données...");

        try {
            // L'appel à getEntityManager() va forcer Hibernate à lire le persistence.xml
            // et à tenter de se connecter à MySQL via le driver JDBC.
            EntityManager em = JPAUtil.getEntityManager();

            if (em != null) {
                System.out.println("✅ SUCCÈS : La connexion JDBC/JPA fonctionne parfaitement !");
                System.out.println("✅ Hibernate a pu communiquer avec 'esocial_db'.");
                em.close();
            }
        } catch (Exception e) {
            System.err.println("❌ ÉCHEC : Impossible de se connecter à la base de données.");
            System.err.println("Détails de l'erreur : " + e.getMessage());
            e.printStackTrace();
        } finally {
            JPAUtil.close();
        }
    }
}