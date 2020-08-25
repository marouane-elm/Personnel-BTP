package com.btp.PersonnelBTP.ControllerIntegrationTest;

import com.btp.PersonnelBTP.models.Equipe;
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
public class EquipeControllerTest {

    // bind the above RANDOM_PORT
    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    String jsonExemple = "{\"equipeId\":1,\"libelle\":\"real madrid\",\"membres\":[{\"salarieId\"" +
            ":1,\"cin\":\"CC20202020\",\"prenom\":\"aaa\"," +
            "\"nom\":\"bbbb\",\"dateNaissance\":\"12-15-1989\"," +
            "\"adresse\":\"adresse 1\",\"numTel\":\"0610111122\",\"email\"" +
            ":\"marzar@gmail.com\",\"role\":{\"roleId\":1,\"libelle\":" +
            "\"Responsable achats\",\"salaire\":10000.0}}],\"missions\":[]}";

    HttpHeaders headers = new HttpHeaders();

    @Test
    public void geEquipeById() throws Exception {

        ResponseEntity<String> response = restTemplate.getForEntity(
                new URL("http://localhost:" + port + "/api/v1/equipes/1").toString(), String.class);

        assertEquals(jsonExemple, response.getBody());

    }

    @Test
    public void addEquipe() throws MalformedURLException {

        final Equipe equipe = new Equipe();
        equipe.setLibelle("FC bayern");

        HttpEntity<Equipe> entity = new HttpEntity<Equipe>(equipe, headers);

        ResponseEntity<String> response = restTemplate.exchange(
                new URL("http://localhost:" + port + "/api/v1/equipes").toString(),
                HttpMethod.POST, entity, String.class);

        String actual = response.getBody();

        assertEquals(actual, "L'équipe est crée ");

    }

    @Test
    public void deleteEquipeById() throws Exception {

        HttpEntity<Role> entity = new HttpEntity<Role>(null, headers);

        ResponseEntity<String> response = restTemplate.exchange(
                new URL("http://localhost:" + port + "/api/v1/equipes/4").toString(),
                HttpMethod.DELETE, entity, String.class);

        String actual = response.getBody();

        assertEquals(actual, "l'équipe est supprimée ");

    }
}