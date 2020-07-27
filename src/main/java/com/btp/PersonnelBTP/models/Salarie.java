package com.btp.PersonnelBTP.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.sql.Date;

@Entity(name="salaries")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Salarie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long salarie_id;

    @Column(unique = true, nullable = false)
    private String salarie_CIN;

    private String salarie_prenom;
    private String salarie_nom;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "MM-dd-yyyy")
    private Date salarie_dateNaissance;

    private String salarie_adresse;

    @Column(unique = true, nullable = false)
    private String salarie_tel;

    @Column(unique = true, nullable = false)
    private String salarie_email;

    @ManyToOne()
    @JoinColumn(name="equipe_id", nullable = false)
    @JsonIgnore
    private Equipe salarie_equipe;

    @ManyToOne()
    @JoinColumn(name="role_id", nullable = false)
    private Role salarie_role;


    public Long getSalarie_id() {
        return salarie_id;
    }

    public void setSalarie_id(Long salarie_id) {
        this.salarie_id = salarie_id;
    }

    public String getSalarie_CIN() {
        return salarie_CIN;
    }

    public void setSalarie_CIN(String salarie_CIN) {
        this.salarie_CIN = salarie_CIN;
    }

    public String getSalarie_prenom() {
        return salarie_prenom;
    }

    public void setSalarie_prenom(String salarie_prenom) {
        this.salarie_prenom = salarie_prenom;
    }

    public String getSalarie_nom() {
        return salarie_nom;
    }

    public void setSalarie_nom(String salarie_nom) {
        this.salarie_nom = salarie_nom;
    }

    public Date getSalarie_dateNaissance() {
        return salarie_dateNaissance;
    }

    public void setSalarie_dateNaissance(Date salarie_dateNaissance) {
        this.salarie_dateNaissance = salarie_dateNaissance;
    }

    public String getSalarie_adresse() {
        return salarie_adresse;
    }

    public void setSalarie_adresse(String salarie_adresse) {
        this.salarie_adresse = salarie_adresse;
    }

    public String getSalarie_tel() {
        return salarie_tel;
    }

    public void setSalarie_tel(String salarie_tel) {
        this.salarie_tel = salarie_tel;
    }

    public String getSalarie_email() {
        return salarie_email;
    }

    public void setSalarie_email(String salarie_email) {
        this.salarie_email = salarie_email;
    }

    public Equipe getSalarie_equipe() {
        return salarie_equipe;
    }

    public void setSalarie_equipe(Equipe salarie_equipe) {
        this.salarie_equipe = salarie_equipe;
    }

    public Role getSalarie_role() {
        return salarie_role;
    }

    public void setSalarie_role(Role salarie_role) {
        this.salarie_role = salarie_role;
    }

}
