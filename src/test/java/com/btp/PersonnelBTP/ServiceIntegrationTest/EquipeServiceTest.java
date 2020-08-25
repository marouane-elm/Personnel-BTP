package com.btp.PersonnelBTP.ServiceIntegrationTest;

import com.btp.PersonnelBTP.models.Equipe;
import com.btp.PersonnelBTP.repositories.EquipeRepository;
import com.btp.PersonnelBTP.services.EquipeServiceImpl;
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
public class EquipeServiceTest {

    @MockBean
    private EquipeRepository equipeRepository;

    @InjectMocks
    private EquipeServiceImpl equipeService;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void should_save_equipe(){
        final Equipe equipe = new Equipe();
        equipe.setLibelle("FC bayern");

        Mockito.when(equipeRepository.save(equipe)).thenReturn(equipe);
        assertThat(equipeService.createEquipe(equipe)).isEqualTo(equipe);
    }

    @Test
    public void get_equipe_by_id(){

        final Equipe equipe = new Equipe();
        equipe.setLibelle("FC bayern");
        equipe.setEquipeId((long) 1);

        Mockito.when(equipeRepository.findById(any(Long.class))).thenReturn(java.util.Optional.of(equipe));

        Equipe found = equipeService.getEquipe((long) 1);
        assertEquals("FC bayern", found.getLibelle());
    }

    @Test
    public void updateEquipe(){

        final Long userId = 1L;
        final Equipe equipe = new Equipe();
        equipe.setEquipeId(userId);
        equipe.setLibelle("chelsea ");

        given(equipeRepository.findById(any(Long.class))).willReturn(java.util.Optional.of(equipe));
        given(equipeRepository.saveAndFlush(any(Equipe.class))).willReturn(equipe);

        final Equipe expected = equipeService.updateEquipe(userId, equipe);
        assertThat(expected).isNotNull();

        verify(equipeRepository).saveAndFlush(any(Equipe.class));
    }

    @Test
    public void should_be_deleted(){
        final Long userId = 1L;

        equipeService.deleteEquipe(userId);
        verify(equipeRepository, times(1)).deleteById(userId);
    }

}
