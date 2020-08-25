package com.btp.PersonnelBTP.JpaIntegrationTest;

import com.btp.PersonnelBTP.models.Role;
import com.btp.PersonnelBTP.repositories.RoleRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class RoleRepositoryIntegrationTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private RoleRepository roleRepository;

    @Test
    public void whenFindByLibelle_thenReturnRoleLibelle() {
        // given
        Role role1 = new Role();
        role1.setLibelle("responsable equipe");
        role1.setSalaire((float) 150000.00);
        entityManager.persist(role1);
        entityManager.flush();
        // when
        Role found = roleRepository.findByLibelle("responsable equipe");

        // then
        assertThat(found.getLibelle())
                .isEqualTo(role1.getLibelle());
    }

    @Test
    public void deleteRoleById() {
        // given
        Role role1 = new Role();
        role1.setLibelle("role 2");
        role1.setSalaire((float) 150000.00);

        final Long id = entityManager.persistAndGetId(role1, Long.class);

        roleRepository.deleteById(id);

        entityManager.flush();
        Role after = entityManager.find(Role.class, id);

        assertThat(after).isNull();
    }

}
