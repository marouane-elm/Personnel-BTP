package com.btp.PersonnelBTP.JpaIntegrationTest;

import com.btp.PersonnelBTP.models.Equipe;
import com.btp.PersonnelBTP.models.Role;
import com.btp.PersonnelBTP.models.Salarie;
import com.btp.PersonnelBTP.repositories.SalarieRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class SalarieRepositoryIntegrationTest {

    @Autowired
    private SalarieRepository salarieRepository;

    @Autowired
    private TestEntityManager entityManager;

    @Test
    public void whenFindByCin_thenReturnSalarieCin() {
        // given
        Salarie salarie = new Salarie();
        salarie.setCin("AD188177");
        salarie.setAdresse("adresse 1");
        salarie.setDateNaissance(null);
        salarie.setEmail("mar@gmail.com");
        salarie.setNom("elm");
        salarie.setPrenom("mar");
        salarie.setNumTel("0610102828");

        Role role1 = new Role();
        role1.setLibelle("role 2");
        role1.setSalaire((float) 150000.00);

        salarie.setRole(role1);
        entityManager.persist(role1);
        entityManager.flush();

        Equipe equipe = new Equipe();
        equipe.setLibelle("equipe1");

        entityManager.persist(equipe);
        entityManager.flush();

        entityManager.persist(salarie);
        entityManager.flush();
        // when
        Salarie found = salarieRepository.findByCin("AD188177");

        // then
        assertThat(found.getCin())
                .isEqualTo(salarie.getCin());
    }
}

