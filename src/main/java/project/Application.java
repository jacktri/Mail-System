package project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import project.entity.UserEntity;
import project.repository.UserRepository;

@SpringBootApplication
public class Application implements CommandLineRunner{

public static void main(String[] args){
    SpringApplication.run(Application.class, args);
}

    @Autowired
    protected UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception
    {
        System.out.println("here");
        userRepository.save(new UserEntity("user","password"));
    }
}
