package project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import project.entity.UserEntity;
import project.repository.UserRepository;

@SpringBootApplication
public class Application implements CommandLineRunner{

    @Autowired
    protected UserRepository userRepository;

public static void main(String[] args){
    SpringApplication.run(Application.class, args);
}

    @Override
    public void run(String... args) throws Exception
    {
        userRepository.save(new UserEntity("user",new BCryptPasswordEncoder().encode("password")));
    }
}
