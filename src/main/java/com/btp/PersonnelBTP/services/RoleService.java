package com.btp.PersonnelBTP.services;

import com.btp.PersonnelBTP.models.Role;

import java.util.List;

public interface RoleService {
    public abstract Role createRole(Role role);
    public abstract Role updateRole(Long id, Role role);
    public abstract void deleteRole(Long id);
    public abstract Role getRole(Long id);
    public abstract List<Role> getAllRoles();

}
