package project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import project.common.rest.Field;
import project.controller.dto.MessageDto;
import project.rest.field.MessageFieldPopulator;
import project.service.MessageService;
import project.vo.MessageVo;
import project.vo.UserVo;
import java.security.Principal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;


@RestController
public class MessageController
{

    @Autowired
    protected MessageFieldPopulator populator;

    @Autowired
    private MessageService messageService;

    @RequestMapping(value = "getMessages", method = RequestMethod.GET)
    public List<MessageDto> getMessages(Principal principal)
    {
        List<MessageVo> messages = messageService.getMessagesForUser(new UserVo.Builder().login(principal.getName()).build());
        return convertMessagesList(populator.getAllChildFields(), messages);
    }

    @RequestMapping(value = "sendMessage", method = RequestMethod.POST)
    public void sendMessage(@RequestBody final MessageDto messageDto, Principal principal){
        messageService.sendMessage(convertToVo(messageDto, principal));
    }

    private List<MessageDto> convertMessagesList(Field[] fields, List<MessageVo> messageVos){
        List<MessageDto> messageDtos = new ArrayList<>();
        for(MessageVo messageVo : messageVos){
            messageDtos.add(convertMessage(fields,messageVo));
        }
        return messageDtos;
    }

    private MessageDto convertMessage(Field[] fields, MessageVo messageVo){
        return populator.populate(new MessageDto.Builder(),messageVo,fields).build();
    }
    private MessageVo convertToVo(MessageDto messageDto, Principal principal){
        return new MessageVo.Builder()
                .sender(new UserVo.Builder().login(principal.getName()).build())
                .receiever(new UserVo.Builder().login(messageDto.getReceiver()).build())
                .content(messageDto.getContent())
                .sendDateTime(new Timestamp(System.currentTimeMillis()))
                .build();
    }
}
