package com.btp.PersonnelBTP.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.sql.Date;

@Entity(name="salaries")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Salarie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long salarieId;

    @Column(unique = true, nullable = false)
    private String cin;

    private String prenom;
    private String nom;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "MM-dd-yyyy")
    private Date dateNaissance;

    private String adresse;

    @Column(unique = true, nullable = false)
    private String numTel;

    @Column(unique = true, nullable = false)
    private String email;

    @ManyToOne()
    @JoinColumn(name="equipeId", nullable = true)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Equipe equipe;

    @ManyToOne()
    @JoinColumn(name="roleId", nullable = true)
    private Role role;

    public Long getSalarieId() {
        return salarieId;
    }

    public void setSalarieId(Long salarieId) {
        this.salarieId = salarieId;
    }

    public String getCin() {
        return cin;
    }

    public void setCin(String cin) {
        this.cin = cin;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Date getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getNumTel() {
        return numTel;
    }

    public void setNumTel(String numTel) {
        this.numTel = numTel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Equipe getEquipe() {
        return equipe;
    }

    public void setEquipe(Equipe equipe) {
        this.equipe = equipe;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
