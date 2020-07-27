package com.btp.PersonnelBTP.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name="equipes")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Equipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long equipe_id;

    @Column(unique = true, nullable = false)
    private String equipe_libelle;

    @OneToMany(mappedBy="salarie_equipe",cascade=CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Salarie> membres;

    public Long getEquipe_id() {
        return equipe_id;
    }

    public void setEquipe_id(Long equipe_id) {
        this.equipe_id = equipe_id;
    }

    public String getEquipe_libelle() {
        return equipe_libelle;
    }

    public void setEquipe_libelle(String equipe_libelle) {
        this.equipe_libelle = equipe_libelle;
    }

    public List<Salarie> getMembres() {
        return membres;
    }

    public void setMembres(List<Salarie> membres) {
        this.membres = membres;
    }
}
