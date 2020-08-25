package com.btp.PersonnelBTP.contollers;

import com.btp.PersonnelBTP.models.Mission;
import com.btp.PersonnelBTP.services.MissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/v1/missions")
public class MissionController {

    @Autowired
    MissionService missionService;

    @GetMapping
    public ResponseEntity<Object> list(){
        return new ResponseEntity<>(missionService.getAllMissions(), HttpStatus.OK);
    }

    @GetMapping
    @RequestMapping("{id}")
    public ResponseEntity<Object> get(@PathVariable Long id){
        return new ResponseEntity<>(missionService.getMission(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Object> create(@RequestBody final Mission mission){
        missionService.createMission(mission);
        return new ResponseEntity<>("La mission est crée ", HttpStatus.CREATED);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> delete(@PathVariable Long id){
        missionService.deleteMission(id);
        return new ResponseEntity<>("Mission est supprimée ", HttpStatus.OK);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    public ResponseEntity<Object> update(@PathVariable Long id, @RequestBody Mission mission) {
        missionService.updateMission(id, mission);
        return new ResponseEntity<>("la mission est mise à jour ", HttpStatus.OK);
    }

}
