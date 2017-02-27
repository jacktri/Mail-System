package project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import project.entity.MessageEntity;
import project.entity.UserEntity;
import project.repository.MessageRepository;
import project.repository.UserRepository;
import project.service.MessageService;
import project.vo.MessageVo;
import project.vo.UserVo;

import java.sql.Timestamp;
import java.util.List;

@SpringBootApplication
public class Application implements CommandLineRunner
{

    @Autowired
    protected UserRepository userRepository;
    @Autowired
    protected MessageRepository messageRepository;
    @Autowired
    protected MessageService messageService;

    public static void main(String[] args)
    {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception
    {
        UserEntity user1 = new UserEntity("user1", new BCryptPasswordEncoder().encode("password"));
        UserEntity user2 = new UserEntity("user2", new BCryptPasswordEncoder().encode("password"));
        userRepository.save(user1);
        userRepository.save(user2);
        messageRepository.save(new MessageEntity(user1,user2,"test mesage", new Timestamp(1)));
        UserVo u = new UserVo.Builder().login("user1").build();
        List<MessageVo> messages = messageService.getMessagesForUser(u);
        messages.forEach(message -> System.out.println(message.toString()));
    }
}
