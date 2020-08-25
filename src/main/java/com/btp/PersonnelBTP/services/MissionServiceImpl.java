package com.btp.PersonnelBTP.services;

import com.btp.PersonnelBTP.exceptions.ResourceNotFoundException;
import com.btp.PersonnelBTP.models.Mission;
import com.btp.PersonnelBTP.repositories.MissionRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class MissionServiceImpl implements MissionService {

    @Autowired
    MissionRepository missionRepository;

    public Mission createMission(Mission mission) {
        return missionRepository.save(mission);
    }

    public Mission updateMission(Long id, Mission mission) {
        //because this is a PUT, we expect all attributes to be passed in. A PATCH would only need what has changed.
        //TODO: Add validation that all attributes are passed in, otherwise return a 400 bad payload
        Mission existingMission = missionRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("La mission avec l'id "+ id + " est introuvable !"));
        BeanUtils.copyProperties(mission, existingMission,"id","equipe");
        return missionRepository.saveAndFlush(existingMission);
    }

    public void deleteMission(Long id) {
        missionRepository.deleteById(id);
    }

    public Mission getMission(Long id) {

        return missionRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("La mission avec l'id "+ id + " est introuvable !"));
    }

    public List<Mission> getAllMissions() {
        return missionRepository.findAll();
    }
}
