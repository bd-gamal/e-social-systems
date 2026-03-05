package com.esocial.esocialsystems.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Assure {
    @Id
    private int id;
    private String nom;
    private double salaireMensuel;

    public Assure(int id, double salaireMensuel, String nom) {
        this.id = id;
        this.salaireMensuel = salaireMensuel;
        this.nom = nom;
    }

    public Assure() {}

    public Assure(String nom, Double salaire, Employeur employeur) {
    }

    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public double getSalaireMensuel() {
        return salaireMensuel;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setSalaireMensuel(double salaireMensuel) {
        this.salaireMensuel = salaireMensuel;
    }

    public void setEmployeur(Employeur employeur) {
    }
}
