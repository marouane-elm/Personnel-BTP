package com.btp.PersonnelBTP.services;

import com.btp.PersonnelBTP.models.Mission;

import java.util.List;

public interface MissionService {

    public abstract Mission createMission(Mission mission);
    public abstract Mission updateMission(Long id, Mission mission);
    public abstract void deleteMission(Long id);
    public abstract Mission getMission(Long id);
    public abstract List<Mission> getAllMissions();
}
