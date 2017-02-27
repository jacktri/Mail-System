package project.vo.visitor;

import project.common.vo.visitor.BaseVoEntityVisitor;
import project.entity.MessageEntity;
import project.vo.MessageVo;

public class MessageVoEntityVisitor extends BaseVoEntityVisitor<MessageVo, MessageEntity.Builder>
    implements MessageVo.MessageVoVisitor
{
    public MessageVoEntityVisitor(MessageEntity.Builder builder)
    {
        super(builder);
    }

    @Override
    public void visit(final MessageVo messageVo){
        super.visit(messageVo);
    }
}
