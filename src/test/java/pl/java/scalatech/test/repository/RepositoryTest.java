package pl.java.scalatech.test.repository;

import java.math.BigDecimal;

import org.fest.assertions.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import static pl.java.scalatech.specification.UserSpecitications.*;
import pl.java.scalatech.config.DsConfig;
import pl.java.scalatech.domain.User;
import pl.java.scalatech.repository.UserRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = { DsConfig.class })
@ActiveProfiles(profiles = "dev")
@Transactional
public class RepositoryTest {
    @Autowired
    private UserRepository userRepository;

    @Before
    public void init() {
        userRepository.save(User.builder().login("przodownik").name("borowiec").salary(new BigDecimal(120)).build());
        userRepository.save(User.builder().login("bak").name("borowiec").salary(new BigDecimal(230)).build());
        userRepository.save(User.builder().login("aga").name("borowiec").salary(new BigDecimal(450)).build());
        userRepository.save(User.builder().login("mike").name("tyson").salary(new BigDecimal(670)).build());
    }

    @Test
    public void shouldSaveAndRetrieveRecords() {
        Assertions.assertThat(userRepository.count()).isEqualTo(4);
    }

    @Test
    public void shouldSpecificationsPredicateWork() {
        Assertions.assertThat(userRepository.findAll(findByLogin("przodownik"))).hasSize(1)
                .containsOnly(User.builder().login("przodownik").name("borowiec").salary(new BigDecimal(120)).build());
        Assertions.assertThat(userRepository.findAll(getUsersWhoEarMoreThan(new BigDecimal(300)))).hasSize(2);
    }
}
