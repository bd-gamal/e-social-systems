package org.example.esocialsystems.models;

public class Employeur {
    private int id;
    private String raisonSociale;
    private String secteurActivite;

    public Employeur(int id, String raisonSociale, String secteurActivite) {
        this.id = id;
        this.raisonSociale = raisonSociale;
        this.secteurActivite = secteurActivite;
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
