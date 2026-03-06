package com.esocial.esocialsystems.models;

import jakarta.persistence.*;

@Entity
@Table(name = "employeurs")
public class Employeur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Correspond à AUTO_INCREMENT
    private int id;

    @Column(name = "raison_sociale", nullable = false)
    private String raisonSociale;

    @Column(name = "secteur_activite", nullable = false)
    private String secteurActivite;

    public Employeur() {}

    public Employeur(String raisonSociale, String secteurActivite) {
        this.raisonSociale = raisonSociale;
        this.secteurActivite = secteurActivite;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getRaisonSociale() { return raisonSociale; }
    public void setRaisonSociale(String raisonSociale) { this.raisonSociale = raisonSociale; }

    public String getSecteurActivite() { return secteurActivite; }
    public void setSecteurActivite(String secteurActivite) { this.secteurActivite = secteurActivite; }
}