package com.btp.PersonnelBTP.contollers;

import com.btp.PersonnelBTP.models.Salarie;
import com.btp.PersonnelBTP.services.SalarieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/salaries")
public class SalarieController {

    @Autowired
    SalarieService salarieService;

    @GetMapping
    public ResponseEntity<Object> list(){
        return new ResponseEntity<>(salarieService.getAllSalaries(), HttpStatus.OK);
    }

    @GetMapping
    @RequestMapping("{id}")
    public ResponseEntity<Object> get(@PathVariable Long id){
        return new ResponseEntity<>(salarieService.getSalarie(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Object> create(@RequestBody final Salarie salarie){
        salarieService.createSalarie(salarie);
        return new ResponseEntity<>("salarié est ajouté ", HttpStatus.CREATED);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> delete(@PathVariable Long id){
        salarieService.deleteSalarie(id);
        return new ResponseEntity<>("salarié est supprimé ", HttpStatus.OK);
            }

    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    public ResponseEntity<Object> update(@PathVariable Long id, @RequestBody Salarie salarie){
        salarieService.updateSalarie(id, salarie);
        return new ResponseEntity<>("salarié est mis à jour ", HttpStatus.OK);
    }
}
