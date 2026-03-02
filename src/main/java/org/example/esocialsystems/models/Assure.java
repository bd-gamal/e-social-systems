package org.example.esocialsystems.models;

public class Assure {
    private int id;
    private String nom;
    private double salaireMensuel;

    public Assure(int id, double salaireMensuel, String nom) {
        this.id = id;
        this.salaireMensuel = salaireMensuel;
        this.nom = nom;
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
}
