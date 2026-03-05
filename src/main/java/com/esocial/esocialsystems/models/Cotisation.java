package com.esocial.esocialsystems.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Cotisation {
    @Id
    private int id;
    private double montantSalarial;
    private double montantPatronal;
    private double totalCotisation;

    public Cotisation(int id, double montantSalarial, double totalCotisation, double montantPatronal) {
        this.id = id;
        this.montantSalarial = montantSalarial;
        this.totalCotisation = totalCotisation;
        this.montantPatronal = montantPatronal;
    }

    public Cotisation() {}

    public Cotisation(Assure assure, Declaration declaration, double baseCalcul, double montantSalarial, double montantPatronal) {
    }

    public int getId() {
        return id;
    }

    public double getMontantSalarial() {
        return montantSalarial;
    }

    public double getMontantPatronal() {
        return montantPatronal;
    }

    public double getTotalCotisation() {
        return totalCotisation;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setMontantSalarial(double montantSalarial) {
        this.montantSalarial = montantSalarial;
    }

    public void setMontantPatronal(double montantPatronal) {
        this.montantPatronal = montantPatronal;
    }

    public void setTotalCotisation(double totalCotisation) {
        this.totalCotisation = totalCotisation;
    }

    public void setAssure(Assure assure) {

    }

    public void setDeclaration(Declaration declaration) {
    }

    public void setBaseCalcul(double baseCalcul) {
    }
}
