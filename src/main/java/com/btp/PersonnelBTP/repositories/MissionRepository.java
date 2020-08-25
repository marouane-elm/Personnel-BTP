package com.btp.PersonnelBTP.repositories;

import com.btp.PersonnelBTP.models.Mission;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MissionRepository extends JpaRepository<Mission, Long> {

    public Mission findByLibelle(String libelle);
}
