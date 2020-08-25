package com.btp.PersonnelBTP.repositories;

import com.btp.PersonnelBTP.models.Equipe;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EquipeRepository extends JpaRepository<Equipe, Long> {
    public Equipe findByLibelle(String libelle);
}
