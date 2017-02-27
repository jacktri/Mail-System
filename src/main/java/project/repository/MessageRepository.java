package project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import project.entity.MessageEntity;

import java.util.List;

public interface MessageRepository extends JpaRepository<MessageEntity, Long>
{

    @Query("SELECT m FROM MessageEntity m WHERE m.owner.username = :username")
    List<MessageEntity> getMessagesForUser(@Param("username") String username);

    @Query("SELECT m FROM MessageEntity m")
    List<MessageEntity> getMessages();


}
