package com.btp.PersonnelBTP.ServiceIntegrationTest;

import com.btp.PersonnelBTP.models.Mission;
import com.btp.PersonnelBTP.repositories.MissionRepository;
import com.btp.PersonnelBTP.services.MissionServiceImpl;
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
public class MissionServiceTest {

    @MockBean
    private MissionRepository missionRepository;

    @InjectMocks
    private MissionServiceImpl missionService;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void should_save_Mission(){

        final Mission mission = new Mission();
        mission.setLibelle("Mission test");
        mission.setDuree("test");

        Mockito.when(missionRepository.save(mission)).thenReturn(mission);
        assertThat(missionService.createMission(mission)).isEqualTo(mission);

    }

    @Test
    public void get_Mission_by_id(){

        final Mission mission = new Mission();
        mission.setMissionId((long) 1);
        mission.setLibelle("Mission test");
        mission.setDuree("test");

        Mockito.when(missionRepository.findById(any(Long.class))).thenReturn(java.util.Optional.of(mission));

        Mission found = missionService.getMission((long) 1);
        assertEquals("Mission test", found.getLibelle());
    }

    @Test
    public void updateMission(){

        final Long missionId = 1L;
        final Mission mission = new Mission();
        mission.setMissionId(missionId);
        mission.setLibelle("Mission test");
        mission.setDuree("test");

        given(missionRepository.findById(any(Long.class))).willReturn(java.util.Optional.of(mission));
        given(missionRepository.saveAndFlush(any(Mission.class))).willReturn(mission);

        final Mission expected = missionService.updateMission(missionId, mission);
        assertThat(expected).isNotNull();

        verify(missionRepository).saveAndFlush(any(Mission.class));
    }

    @Test
    public void should_be_deleted(){
        final Long missionId = 1L;

        missionService.deleteMission(missionId);
        verify(missionRepository, times(1)).deleteById(missionId);
    }
}
