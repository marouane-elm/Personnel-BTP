package com.btp.PersonnelBTP.contollers;

import com.btp.PersonnelBTP.models.Equipe;
import com.btp.PersonnelBTP.services.EquipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/equipes")
public class EquipeController {
// llll
    @Autowired
    EquipeService equipeService;

    @GetMapping
    public ResponseEntity<Object> list(){
        return new ResponseEntity<>(equipeService.getAllEquipes(), HttpStatus.OK);
    }

    @GetMapping
    @RequestMapping("{id}")
    public ResponseEntity<Object> get(@PathVariable Long id){
        return new ResponseEntity<>(equipeService.getEquipe(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Object> create(@RequestBody final Equipe equipe){
        equipeService.createEquipe(equipe);
        return new ResponseEntity<>("L'équipe est crée ", HttpStatus.CREATED);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> delete(@PathVariable Long id){
        equipeService.deleteEquipe(id);
        return new ResponseEntity<>("l'équipe est supprimée ", HttpStatus.OK);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    public ResponseEntity<Object> update(@PathVariable Long id, @RequestBody Equipe equipe) {
        equipeService.updateEquipe(id, equipe);
        return new ResponseEntity<>("l'équipe est mise à jour ", HttpStatus.OK);
    }
}
