package com.btp.PersonnelBTP.repositories;

import com.btp.PersonnelBTP.models.Salarie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SalarieRepository extends JpaRepository<Salarie, Long> {

    public Salarie findByCin(String cin);
}
