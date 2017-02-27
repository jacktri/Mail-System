package project.vo.visitor.entity;

import project.common.vo.visitor.entity.BaseEntityVoVisitor;
import project.entity.MessageEntity;
import project.entity.UserEntity;
import project.vo.MessageVo;
import project.vo.UserVo;

public class MessageEntityVoVisitor extends BaseEntityVoVisitor<MessageEntity, MessageVo.Builder>
        implements MessageEntity.MessageEntityVisitor
{
    public MessageEntityVoVisitor(MessageVo.Builder builder)
    {
        super(builder);
    }

    @Override
    public void visit(final MessageEntity messageEntity)
    {
        super.visit(messageEntity);
        builder.content(messageEntity
                .getContent())
                .sender(convertUserEntityToVo(messageEntity.getSender()))
                .receiever(convertUserEntityToVo(messageEntity.getOwner()))
                .sendDateTime(messageEntity.getSendDateTime())
                .id(messageEntity.getId());

    }
    private UserVo convertUserEntityToVo(final UserEntity entity)
    {
        return entity.accept(new UserEntityVoVisitor(
                new UserVo.Builder()))
                .getBuilder()
                .build();
    }
}
