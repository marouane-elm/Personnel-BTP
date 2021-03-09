package com.btp.PersonnelBTP.ControllerIntegrationTest;


import com.btp.PersonnelBTP.models.Equipe;
import com.btp.PersonnelBTP.models.Role;
import com.btp.PersonnelBTP.models.Salarie;
import com.btp.PersonnelBTP.services.EquipeService;
import com.btp.PersonnelBTP.services.RoleService;
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
public class SalarieControllerTest {

    // bind the above RANDOM_PORT
    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private RoleService roleService;

    @Autowired
    private EquipeService equipeService;

    String jsonExemple = "{\"salarieId\":1,\"cin\":\"CC20202020\",\"prenom\":\"aaa\"" +
                         ",\"nom\":\"bbbb\",\"dateNaissance\":\"" +
                         "12-15-1989\",\"adresse\":\"adresse 1\",\"numTel\":\"0610111122\",\"email" +
                         "\":\"marzar@gmail.com\",\"role\":{\"roleId\":1,\"libelle\":\"Responsable achats\"" +
                         ",\"salaire\":10000.0}}";

    HttpHeaders headers = new HttpHeaders();

    @Test
    public void getSalarieById() throws Exception {

        ResponseEntity<String> response = restTemplate.getForEntity(
                new URL("http://localhost:" + port + "/api/v1/salaries/1").toString(), String.class);

        assertEquals(jsonExemple, response.getBody());

    }

/*
    @Test
    public void addSalarie() throws MalformedURLException {

        final Salarie salarie = new Salarie();

        final Role role = new Role();
        role.setRoleId((long) 1);

        final Equipe equipe = new Equipe();
        equipe.setEquipeId((long) 2);

        salarie.setCin("AD1811149");
        salarie.setNumTel("0611203040");
        salarie.setPrenom("ansu");
        salarie.setNom("fati");
        salarie.setEmail("anti@gmail.com");
        salarie.setAdresse("Adresse 1");
        salarie.setRole(role);
        salarie.setEquipe(equipe);
        salarie.setDateNaissance(null);


        HttpEntity<Salarie> entity = new HttpEntity<Salarie>(salarie, headers);

        ResponseEntity<String> response = restTemplate.exchange(
                new URL("http://localhost:" + port + "/api/v1/salaries").toString(),
                HttpMethod.POST, entity, String.class);

        String actual = response.getBody();

        assertEquals(actual, "salarié est ajouté ");

    }

    @Test
    public void deleteById() throws Exception {

        HttpEntity<Role> entity = new HttpEntity<Role>(null, headers);

        ResponseEntity<String> response = restTemplate.exchange(
                new URL("http://localhost:" + port + "/api/v1/salaries/11").toString(),
                HttpMethod.DELETE, entity, String.class);

        String actual = response.getBody();

        assertEquals(actual, "salarié est supprimé ");

    }

 */

}

