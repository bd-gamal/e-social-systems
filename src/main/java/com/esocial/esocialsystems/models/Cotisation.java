package com.esocial.esocialsystems.models;

import jakarta.persistence.*;

@Entity
@Table(name = "cotisations")
public class Cotisation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "assure_id", nullable = false)
    private Assure assure;

    @ManyToOne
    @JoinColumn(name = "declaration_id", nullable = false)
    private Declaration declaration;

    @Column(name = "base_calcul", nullable = false)
    private double baseCalcul;

    @Column(name = "montant_salarial", nullable = false)
    private double montantSalarial;

    @Column(name = "montant_patronal", nullable = false)
    private double montantPatronal;

    public Cotisation() {}

    // Getters et Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public Assure getAssure() { return assure; }
    public void setAssure(Assure assure) { this.assure = assure; }

    public Declaration getDeclaration() { return declaration; }
    public void setDeclaration(Declaration declaration) { this.declaration = declaration; }

    public double getBaseCalcul() { return baseCalcul; }
    public void setBaseCalcul(double baseCalcul) { this.baseCalcul = baseCalcul; }

    public double getMontantSalarial() { return montantSalarial; }
    public void setMontantSalarial(double montantSalarial) { this.montantSalarial = montantSalarial; }

    public double getMontantPatronal() { return montantPatronal; }
    public void setMontantPatronal(double montantPatronal) { this.montantPatronal = montantPatronal; }
}