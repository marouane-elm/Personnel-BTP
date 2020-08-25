package com.btp.PersonnelBTP.JpaIntegrationTest;

import com.btp.PersonnelBTP.models.Equipe;
import com.btp.PersonnelBTP.repositories.EquipeRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class EquipeRepositoryIntegrationTest {

    @Autowired
    private EquipeRepository equipeRepository;

    @Autowired
    private TestEntityManager entityManager;

    @Test
    public void whenFindByLibelle_thenReturnEquipeLibelle() {

        Equipe equipe = new Equipe();
        equipe.setLibelle("equipe1");

        entityManager.persist(equipe);
        entityManager.flush();

        // when
        Equipe found = equipeRepository.findByLibelle("equipe1");

        //then
        assertThat(found.getLibelle())
                .isEqualTo(equipe.getLibelle());
    }

    @Test
    public void deleteEquipeById() {

        Equipe equipe = new Equipe();
        equipe.setLibelle("equipe1");


        final Long id = entityManager.persistAndGetId(equipe, Long.class);

        equipeRepository.deleteById(id);

        entityManager.flush();
        Equipe after = entityManager.find(Equipe.class, id);

        assertThat(after).isNull();
    }

}
