package com.btp.PersonnelBTP.models;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name="roles")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long role_id;

    @Column(unique = true, nullable = false)
    private String role_libelle;

    @Column(unique = true, nullable = false)
    private Float role_salaire;

    @OneToMany(mappedBy="salarie_role",cascade=CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Salarie> salaries;

    public Long getRole_id() {
        return role_id;
    }

    public void setRole_id(Long role_id) {
        this.role_id = role_id;
    }

    public String getRole_libelle() {
        return role_libelle;
    }

    public void setRole_libelle(String role_libelle) {
        this.role_libelle = role_libelle;
    }

    public Float getRole_salaire() {
        return role_salaire;
    }

    public void setRole_salaire(Float role_salaire) {
        this.role_salaire = role_salaire;
    }

    public List<Salarie> getSalaries() {
        return salaries;
    }

    public void setSalaries(List<Salarie> salaries) {
        this.salaries = salaries;
    }
}
