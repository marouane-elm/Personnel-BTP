package com.btp.PersonnelBTP.repositories;

import com.btp.PersonnelBTP.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
    public Role findByLibelle(String libelle);
}
