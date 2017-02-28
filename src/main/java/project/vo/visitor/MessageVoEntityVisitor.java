package project.vo.visitor;

import project.common.vo.visitor.BaseVoEntityVisitor;
import project.entity.MessageEntity;
import project.entity.UserEntity;
import project.vo.MessageVo;
import project.vo.UserVo;

import java.sql.Timestamp;

public class MessageVoEntityVisitor extends BaseVoEntityVisitor<MessageVo, MessageEntity.Builder>
        implements MessageVo.MessageVoVisitor
{
    public MessageVoEntityVisitor(MessageEntity.Builder builder)
    {
        super(builder);
    }

    @Override
    public void visit(final MessageVo messageVo)
    {
        super.visit(messageVo);
        builder.content(messageVo.getContent())
                .sendDateTime(messageVo.getSendDateTime())
                .sender(messageVo.getSender()
                        .accept(new UserVoEntityVisitor(
                                new UserEntity.Builder()))
                        .getBuilder().build())
                .owner(messageVo.getReciever()
                        .accept(new UserVoEntityVisitor(
                                new UserEntity.Builder()))
                        .getBuilder().build());
    }
}
