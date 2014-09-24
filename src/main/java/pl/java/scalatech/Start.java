package pl.java.scalatech;

import java.math.BigDecimal;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Configuration;

import pl.java.scalatech.domain.User;
import pl.java.scalatech.repository.UserRepository;

/**
 * @author Sławomir Borowiec
 *         Module name : bootSetting
 *         Creating time : 17 wrz 2014 09:49:25
 */
@Configuration
@EnableAutoConfiguration
@Slf4j
public class Start  implements CommandLineRunner {
    private static final String DEV = "dev";
    
   @Autowired
   private UserRepository userRepository;
    
    public static void main(String[] args) {
        System.setProperty("spring.profiles.default", addDefaultProfile());
        SpringApplication.run(Start.class, args);

    }

 
  

    private static String addDefaultProfile() {
        String profile = System.getProperty("spring.profiles.default");
        if (profile != null) {
            log.info("+++                                     Running with Spring profile(s) : {}", profile);
            return profile;
        }
        log.warn("+++                                    No Spring profile configured, running with default configuration");
        return DEV;
    }

   @Override
    public void run(String... args) throws Exception {
        log.info("Launch-------------------------------------------------------------->");
        
        
        log.info(" {}", userRepository.save(User.builder().login("borowiec").name("przodownik").salary(new BigDecimal(100)).build()));
        log.info(" {}", userRepository.save(User.builder().login("borowiec").name("aga").salary(new BigDecimal(10)).build()));
        log.info(" {}", userRepository.save(User.builder().login("borowiec").name("kalina").salary(new BigDecimal(30)).build()));
        log.info(" {}", userRepository.save(User.builder().login("tyson").name("iron mike").salary(new BigDecimal(3234)).build()));
        log.info(" {}", userRepository.save(User.builder().login("rossi").name("the doctor").salary(new BigDecimal(2000)).build()));
        
        log.info(" {}", userRepository.save(new User("kazimierczak", "juz", new BigDecimal(100))));
        log.info(" {}", userRepository.save(new User("aleksandrowicz", "dawid", new BigDecimal(10))));
        log.info(" {}", userRepository.save(new User("barszcz", "mariusz", new BigDecimal(30))));
        log.info(" {}", userRepository.save(new User("bogadanski", "pawel", new BigDecimal(3000))));
        log.info(" {}", userRepository.save(new User("chudzikowska", "sylwia", new BigDecimal(2000))));
        
        
        log.info(" {}", userRepository.save(new User("swietojanski", "przemyslaw", new BigDecimal(100))));
        log.info(" {}", userRepository.save(new User("zurek", "marcin", new BigDecimal(10))));
        log.info(" {}", userRepository.save(new User("grabowski", "michal", new BigDecimal(30))));
        log.info(" {}", userRepository.save(new User("gilewski", "piotr", new BigDecimal(3000))));
        log.info(" {}", userRepository.save(new User("ostroski", "krzych", new BigDecimal(2000))));
        
        //System.exit(0);
    }

}