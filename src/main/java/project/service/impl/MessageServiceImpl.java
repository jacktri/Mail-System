package project.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.entity.MessageEntity;
import project.entity.UserEntity;
import project.repository.MessageRepository;
import project.service.MessageService;
import project.vo.MessageVo;
import project.vo.UserVo;
import project.vo.visitor.MessageVoEntityVisitor;
import project.vo.visitor.UserVoEntityVisitor;
import project.vo.visitor.entity.MessageEntityVoVisitor;

import java.util.ArrayList;
import java.util.List;

@Service
public class MessageServiceImpl implements MessageService
{

    @Autowired
    protected MessageRepository messageRepository;

    @Override
    public void sendMessage(MessageVo message)
    {

    }

    @Override
    public List<MessageVo> getMessagesForUser(UserVo userVo)
    {
//        List<MessageEntity> messageEntities = messageRepository.getMessages();

        List<MessageEntity> messageEntities = messageRepository.getMessagesForUser(userVo.getLogin());
        return convertMessageEntitiesToVo(messageEntities);

    }

    private List<MessageVo> convertMessageEntitiesToVo(List<MessageEntity> messageEntities){
        final List<MessageVo> messageVos = new ArrayList<>(messageEntities.size());
        messageEntities.forEach(entity -> messageVos.add(convertMessageEntityToVo(entity)));
        return messageVos;
    }

    private MessageVo convertMessageEntityToVo(final MessageEntity entity)
    {
        return entity.accept(new MessageEntityVoVisitor(
                new MessageVo.Builder()))
                .getBuilder()
                .build();
    }

    private MessageEntity convertMessageVoToEntity(final MessageVo messageVo){
        return messageVo.accept(new MessageVoEntityVisitor(
                new MessageEntity.Builder()))
                .getBuilder()
                .build();
    }

    private UserEntity convertUserVoToEntity(final UserVo userVo)
    {
        return userVo.accept(new UserVoEntityVisitor(
                new UserEntity.Builder()))
                .getBuilder()
                .build();
    }
}
