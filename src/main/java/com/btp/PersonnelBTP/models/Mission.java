package com.btp.PersonnelBTP.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity(name="missions")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Mission {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long mission_id;

    @Column(unique = true, nullable = false)
    private String mission_libelle;

    @Column(unique = true, nullable = false)
    private String mission_duree;

    @OneToOne
    @JoinColumn(name = "equipe_id")
    private Equipe mission_equipe;

}
