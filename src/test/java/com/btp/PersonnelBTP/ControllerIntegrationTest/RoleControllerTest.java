package com.btp.PersonnelBTP.ControllerIntegrationTest;

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

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT)
public class RoleControllerTest {

    // bind the above RANDOM_PORT
    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    HttpHeaders headers = new HttpHeaders();

    String jsonExemple = "{\"roleId\":1,\"libelle\":\"Responsable achats\",\"salaire\":10000.0}";

    @Test
    public void getRoleById() throws Exception {

        ResponseEntity<String> response = restTemplate.getForEntity(
                new URL("http://localhost:" + port + "/api/v1/roles/1").toString(), String.class);

        assertEquals(jsonExemple, response.getBody());

    }

    @Test
    public void addRole() throws MalformedURLException {

        Role role = new Role();
        role.setRoleId((long) 10);
        role.setLibelle("ingenieur multimedia");
        role.setSalaire((float) 12000.00);

        HttpEntity<Role> entity = new HttpEntity<Role>(role, headers);

        ResponseEntity<String> response = restTemplate.exchange(
                new URL("http://localhost:" + port + "/api/v1/roles").toString(),
                HttpMethod.POST, entity, String.class);

        String actual = response.getBody();

        assertEquals(actual, "Role est crée ");

    }

    @Test
    public void deleteRoleById() throws Exception {

        HttpEntity<Role> entity = new HttpEntity<Role>(null, headers);

        ResponseEntity<String> response = restTemplate.exchange(
                new URL("http://localhost:" + port + "/api/v1/roles/13").toString(),
                HttpMethod.DELETE, entity, String.class);

        String actual = response.getBody();

        assertEquals(actual, "Role est supprimé ");

    }

}