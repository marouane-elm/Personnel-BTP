package com.btp.PersonnelBTP.JpaIntegrationTest;


import com.btp.PersonnelBTP.models.Mission;
import com.btp.PersonnelBTP.repositories.MissionRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class MissionRepositoryIntegrationTest {

    @Autowired
    private MissionRepository missionRepository;

    @Autowired
    private TestEntityManager entityManager;

    @Test
    public void whenFindByLibelle_thenReturnMissionLibelle() {

        Mission mission = new Mission();
        mission.setLibelle("Mission 1");
        mission.setDuree("3 mois");

        entityManager.persist(mission);
        entityManager.flush();

        Mission found = missionRepository.findByLibelle("Mission 1");

        assertThat(mission.getLibelle()).isEqualTo(found.getLibelle());

    }
}
