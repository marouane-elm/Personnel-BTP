package com.btp.PersonnelBTP.services;

import com.btp.PersonnelBTP.exceptions.ResourceNotFoundException;
import com.btp.PersonnelBTP.models.Equipe;
import com.btp.PersonnelBTP.repositories.EquipeRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EquipeServiceImpl implements EquipeService {

    @Autowired
    EquipeRepository equipeRepository;

    @Override
    public Equipe createEquipe(Equipe equipe) {
        return equipeRepository.save(equipe);
    }

    @Override
    public Equipe updateEquipe(Long id, Equipe equipe) {
        Equipe existingEquipe = equipeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("L'equipe  avec l'id "+ id + " est introuvable !"));
        BeanUtils.copyProperties(equipe, existingEquipe,"id","membres","missions");
        return equipeRepository.saveAndFlush(existingEquipe);
    }

    @Override
    public void deleteEquipe(Long id) {
        equipeRepository.deleteById(id);
    }

    @Override
    public Equipe getEquipe(Long id) {
        return equipeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("L'equipe  avec l'id "+ id + " est introuvable !"));
    }

    @Override
    public List<Equipe> getAllEquipes() {
        return equipeRepository.findAll();
    }
}
