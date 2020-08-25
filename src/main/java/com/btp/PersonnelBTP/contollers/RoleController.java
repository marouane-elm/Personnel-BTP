package com.btp.PersonnelBTP.contollers;

import com.btp.PersonnelBTP.models.Role;
import com.btp.PersonnelBTP.services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
@RequestMapping("/api/v1/roles")
public class RoleController {

    @Autowired
    RoleService roleService;

    @GetMapping
    public ResponseEntity<Object> list(){
        return new ResponseEntity<>(roleService.getAllRoles(), HttpStatus.OK);
    }

    @GetMapping
    @RequestMapping("{id}")
    public ResponseEntity<Object> get(@PathVariable Long id){
        return new ResponseEntity<>(roleService.getRole(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Object> create(@Valid @RequestBody final Role role){
        roleService.createRole(role);
        return new ResponseEntity<>("Role est crée ", HttpStatus.CREATED);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> delete(@PathVariable Long id){
        roleService.deleteRole(id);
        return new ResponseEntity<>("Role est supprimé ", HttpStatus.OK);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    public ResponseEntity<Object>  update(@PathVariable Long id, @RequestBody Role role) {
        roleService.updateRole(id, role);
        return new ResponseEntity<>("le role est mis à jour ", HttpStatus.OK);

    }
}
