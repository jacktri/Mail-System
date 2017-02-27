package project.service;

import project.vo.MessageVo;
import project.vo.UserVo;

import java.util.List;

public interface MessageService
{
    void sendMessage(MessageVo message);
    List<MessageVo> getMessagesForUser(UserVo userVo);
}
