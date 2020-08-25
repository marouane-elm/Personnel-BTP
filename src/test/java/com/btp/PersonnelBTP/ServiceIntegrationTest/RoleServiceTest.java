package com.btp.PersonnelBTP.ServiceIntegrationTest;

import com.btp.PersonnelBTP.models.Role;
import com.btp.PersonnelBTP.repositories.RoleRepository;
import com.btp.PersonnelBTP.services.RoleServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RoleServiceTest {

    @MockBean
    private RoleRepository roleRepository;

    @InjectMocks
    private RoleServiceImpl roleService;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void should_save_role(){
        final Role role = new Role();
        role.setLibelle("chef d'equipe");
        role.setSalaire((float) 12000.00);

        Mockito.when(roleRepository.save(role)).thenReturn(role);
        assertThat(roleService.createRole(role)).isEqualTo(role);

    }

    @Test
    public void get_Role_by_id(){

        final Role role = new Role();
        role.setLibelle("chef d'equipe");
        role.setSalaire((float) 12000.00);

        Mockito.when(roleRepository.findById(any(Long.class))).thenReturn(java.util.Optional.of(role));

        Role found = roleService.getRole((long) 1);
        assertEquals("chef d'equipe", found.getLibelle());
    }

    @Test
    public void should_update_role(){

        final Long roleId = 1L;
        final Role role = new Role();
        role.setRoleId(roleId);
        role.setLibelle("chef d'equipe");
        role.setSalaire((float) 12000.00);

        given(roleRepository.findById(any(Long.class))).willReturn(java.util.Optional.of(role));
        given(roleRepository.saveAndFlush(any(Role.class))).willReturn(role);

        final Role expected = roleService.updateRole(roleId, role);
        assertThat(expected).isNotNull();

        verify(roleRepository).saveAndFlush(any(Role.class));
    }

    @Test
    public void should_delete_role(){
        final Long roleId = 1L;

        roleService.deleteRole(roleId);
        verify(roleRepository, times(1)).deleteById(roleId);
    }
}
