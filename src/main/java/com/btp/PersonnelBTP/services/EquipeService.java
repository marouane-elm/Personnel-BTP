package com.btp.PersonnelBTP.services;

import com.btp.PersonnelBTP.models.Equipe;

import java.util.List;

public interface EquipeService {

    public abstract Equipe createEquipe(Equipe equipe);
    public abstract Equipe updateEquipe(Long id, Equipe equipe);
    public abstract void deleteEquipe(Long id);
    public abstract Equipe getEquipe(Long id);
    public abstract List<Equipe> getAllEquipes();

}
