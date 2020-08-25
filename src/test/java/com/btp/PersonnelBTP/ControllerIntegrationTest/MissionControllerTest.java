package com.btp.PersonnelBTP.ControllerIntegrationTest;

import com.btp.PersonnelBTP.models.Mission;
import com.btp.PersonnelBTP.models.Role;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.net.MalformedURLException;
import java.net.URL;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT)
public class MissionControllerTest {

    // bind the above RANDOM_PORT
    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    HttpHeaders headers = new HttpHeaders();

    String jsonExemple = "{\"missionId\":1,\"libelle\":\"Mission 1\",\"duree\":\"13 mois\"}";

    @Test
    public void getMissionById() throws Exception {

        ResponseEntity<String> response = restTemplate.getForEntity(
                new URL("http://localhost:" + port + "/api/v1/missions/1").toString(), String.class);

        assertEquals(jsonExemple, response.getBody());

    }

    @Test
    public void addMission() throws MalformedURLException {

        final Mission mission = new Mission();
        mission.setLibelle("Mission test");
        mission.setDuree("test");

        HttpEntity<Mission> entity = new HttpEntity<Mission>(mission, headers);

        ResponseEntity<String> response = restTemplate.exchange(
                new URL("http://localhost:" + port + "/api/v1/missions").toString(),
                HttpMethod.POST, entity, String.class);

        String actual = response.getBody();

        assertEquals(actual, "La mission est crée ");

    }

    @Test
    public void deleteSalarieById() throws Exception {

        HttpEntity<Role> entity = new HttpEntity<Role>(null, headers);

        ResponseEntity<String> response = restTemplate.exchange(
                new URL("http://localhost:" + port + "/api/v1/missions/4").toString(),
                HttpMethod.DELETE, entity, String.class);

        String actual = response.getBody();

        assertEquals(actual, "salarié est supprimé ");

    }

}