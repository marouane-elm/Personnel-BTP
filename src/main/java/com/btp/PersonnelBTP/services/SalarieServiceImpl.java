package com.btp.PersonnelBTP.services;


import com.btp.PersonnelBTP.exceptions.ResourceNotFoundException;
import com.btp.PersonnelBTP.models.Salarie;
import com.btp.PersonnelBTP.repositories.SalarieRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SalarieServiceImpl implements SalarieService {

    @Autowired
    SalarieRepository salarieRepository;

    @Override
    public Salarie createSalarie(Salarie salarie) {
        return salarieRepository.save(salarie);
    }

    @Override
    public Salarie updateSalarie(Long id, Salarie salarie) {
        Salarie existingSalarie = salarieRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Le salarie avec l'id "+ id + " est introuvable !"));
        BeanUtils.copyProperties(salarie, existingSalarie,"id", "equipe", "role");
        return salarieRepository.saveAndFlush(existingSalarie);
    }

    @Override
    public void deleteSalarie(Long id) {
        salarieRepository.deleteById(id);
    }

    @Override
    public Salarie getSalarie(Long id) {
        return salarieRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Le salarie avec l'id "+ id + " est introuvable !"));
    }

    @Override
    public List<Salarie> getAllSalaries() {
        return salarieRepository.findAll();
    }
}
