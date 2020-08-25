package com.btp.PersonnelBTP.services;

import com.btp.PersonnelBTP.models.Salarie;

import java.util.List;

public interface SalarieService {

    public abstract Salarie createSalarie(Salarie salarie);
    public abstract Salarie updateSalarie(Long id, Salarie salarie);
    public abstract void deleteSalarie(Long id);
    public abstract Salarie getSalarie(Long id);
    public abstract List<Salarie> getAllSalaries();

}
