package com.esocial.esocialsystems.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.time.LocalDate;

@Entity
public class Declaration {
    @Id
    private int id;
    private int mois;
    private int annee;
    private LocalDate dateDeclaration;

    public Declaration(int id, int mois, int annee, LocalDate dateDeclaration) {
        this.id = id;
        this.mois = mois;
        this.annee = annee;
        this.dateDeclaration = dateDeclaration;
    }

    public Declaration() {}

    public Declaration(Employeur employeur, int mois, int annee, LocalDate now) {
    }

    public int getId() {
        return id;
    }

    public int getMois() {
        return mois;
    }

    public int getAnnee() {
        return annee;
    }

    public LocalDate getDateDeclaration() {
        return dateDeclaration;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setMois(int mois) {
        this.mois = mois;
    }

    public void setAnnee(int annee) {
        this.annee = annee;
    }

    public void setDateDeclaration(LocalDate dateDeclaration) {
        this.dateDeclaration = dateDeclaration;
    }

    public void setEmployeur(Employeur employeur) {
    }

    public Employeur getEmployeur() {
        return null;
    }
}
