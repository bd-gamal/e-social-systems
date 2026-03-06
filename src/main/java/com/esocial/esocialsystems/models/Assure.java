package com.esocial.esocialsystems.models;

import jakarta.persistence.*;

@Entity
@Table(name = "assures")
public class Assure {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String nom;

    @Column(name = "salaire_mensuel", nullable = false)
    private double salaireMensuel;

    @ManyToOne
    @JoinColumn(name = "employeur_id", nullable = false)
    private Employeur employeur;

    public Assure() {}

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }

    public double getSalaireMensuel() { return salaireMensuel; }
    public void setSalaireMensuel(double salaireMensuel) { this.salaireMensuel = salaireMensuel; }

    public Employeur getEmployeur() { return employeur; }
    public void setEmployeur(Employeur employeur) { this.employeur = employeur; }
}