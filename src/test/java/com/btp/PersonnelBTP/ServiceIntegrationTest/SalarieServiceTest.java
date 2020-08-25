package com.btp.PersonnelBTP.ServiceIntegrationTest;

import com.btp.PersonnelBTP.models.Equipe;
import com.btp.PersonnelBTP.models.Role;
import com.btp.PersonnelBTP.models.Salarie;
import com.btp.PersonnelBTP.repositories.SalarieRepository;
import com.btp.PersonnelBTP.services.SalarieServiceImpl;
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
public class SalarieServiceTest {

    @MockBean
    private SalarieRepository salarieRepository;

    @InjectMocks
    private SalarieServiceImpl salarieService;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void should_save_salarie(){
        final Salarie salarie = new Salarie();

        final Role role = new Role();
        role.setLibelle("chef d'equipe");
        role.setSalaire((float) 12000.00);

        final Equipe equipe = new Equipe();
        equipe.setLibelle("FC bayern");

        salarie.setCin("CC20202020");
        salarie.setNumTel("0610111122");
        salarie.setPrenom("prenom");
        salarie.setNom("Nom");
        salarie.setEmail("marzar@gmail.com");
        salarie.setAdresse("Adresse 1");
        salarie.setRole(role);
        salarie.setEquipe(equipe);
        salarie.setDateNaissance(null);


        Mockito.when(salarieRepository.save(salarie)).thenReturn(salarie);
        assertThat(salarieService.createSalarie(salarie)).isEqualTo(salarie);

    }

    @Test
    public void get_Salarie_by_id(){

        final Long salarieId = 1L;
        final Salarie salarie = new Salarie();

        final Role role = new Role();
        role.setLibelle("chef d'equipe");
        role.setSalaire((float) 12000.00);

        final Equipe equipe = new Equipe();
        equipe.setLibelle("FC bayern");

        salarie.setSalarieId(salarieId);
        salarie.setCin("CC20202020");
        salarie.setNumTel("0610111122");
        salarie.setPrenom("prenom");
        salarie.setNom("Nom");
        salarie.setEmail("marzar@gmail.com");
        salarie.setAdresse("Adresse 1");
        salarie.setRole(role);
        salarie.setEquipe(equipe);
        salarie.setDateNaissance(null);

        Mockito.when(salarieRepository.findById(any(Long.class))).thenReturn(java.util.Optional.of(salarie));

        Salarie found = salarieService.getSalarie((long) 1);
        assertEquals("CC20202020", found.getCin());
    }

    @Test
    public void should_update_salarie(){

        final Long salarieId = 1L;
        final Salarie salarie = new Salarie();

        final Role role = new Role();
        role.setLibelle("chef d'equipe");
        role.setSalaire((float) 12000.00);

        final Equipe equipe = new Equipe();
        equipe.setLibelle("FC bayern");

        salarie.setSalarieId(salarieId);
        salarie.setCin("CC20202020");
        salarie.setNumTel("0610111122");
        salarie.setPrenom("prenom");
        salarie.setNom("Nom");
        salarie.setEmail("marzar@gmail.com");
        salarie.setAdresse("Adresse 1");
        salarie.setRole(role);
        salarie.setEquipe(equipe);
        salarie.setDateNaissance(null);

        given(salarieRepository.findById(any(Long.class))).willReturn(java.util.Optional.of(salarie));
        given(salarieRepository.saveAndFlush(any(Salarie.class))).willReturn(salarie);

        final Salarie expected = salarieService.updateSalarie(salarieId, salarie);
        assertThat(expected).isNotNull();

        verify(salarieRepository).saveAndFlush(any(Salarie.class));

    }

    @Test
    public void should_delete_salarie(){
        final Long salarieId = 1L;

        salarieService.deleteSalarie(salarieId);
        verify(salarieRepository, times(1)).deleteById(salarieId);
    }
}
