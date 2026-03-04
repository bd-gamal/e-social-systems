package com.esocial.esocialsystems.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Employeur {
    @Id
    private int idEntity;
    private int id;
    private String raisonSociale;
    private String secteurActivite;

    public Employeur(int id, String raisonSociale, String secteurActivite) {
        this.id = id;
        this.raisonSociale = raisonSociale;
        this.secteurActivite = secteurActivite;
    }

    public Employeur() {}

    public int getId1() {
        return idEntity;
    }

    public void setId1(int id1) {
        this.idEntity = id1;
    }

    public int getId() {
        return id;
    }

    public String getRaisonSociale() {
        return raisonSociale;
    }

    public String getSecteurActivite() {
        return secteurActivite;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setSecteurActivite(String secteurActivite) {
        this.secteurActivite = secteurActivite;
    }

    public void setRaisonSociale(String raisonSociale) {
        this.raisonSociale = raisonSociale;
    }
}
