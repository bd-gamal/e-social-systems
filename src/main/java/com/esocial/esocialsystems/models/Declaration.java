package com.esocial.esocialsystems.models;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "declarations", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"employeur_id", "mois", "annee"}) // Correspond à uc_declaration_unique
})
public class Declaration {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "employeur_id", nullable = false)
    private Employeur employeur;

    @Column(nullable = false)
    private int mois;

    @Column(nullable = false)
    private int annee;

    @Column(name = "date_declaration", nullable = false)
    private LocalDate dateDeclaration;

    public Declaration() {}

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public Employeur getEmployeur() { return employeur; }
    public void setEmployeur(Employeur employeur) { this.employeur = employeur; }

    public int getMois() { return mois; }
    public void setMois(int mois) { this.mois = mois; }

    public int getAnnee() { return annee; }
    public void setAnnee(int annee) { this.annee = annee; }

    public LocalDate getDateDeclaration() { return dateDeclaration; }
    public void setDateDeclaration(LocalDate dateDeclaration) { this.dateDeclaration = dateDeclaration; }
}