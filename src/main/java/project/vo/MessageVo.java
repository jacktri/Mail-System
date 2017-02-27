package project.vo;

import project.common.BaseVoVisitor;
import project.common.vo.utils.ValueObjectBuilder;
import project.common.vo.visitor.Visitable;
import java.sql.Timestamp;

public class MessageVo extends BaseVo implements Visitable<MessageVo.MessageVoVisitor>
{
    private Long id;
    private UserVo reciever;
    private UserVo sender;
    private String content;
    private Timestamp sendDateTime;

    public MessageVo(Builder builder){
        this.id = builder.id;
        this.reciever = builder.reciever;
        this.sender = builder.sender;
        this.content = builder.content;
        this.sendDateTime = builder.sendDateTime;
    }

    @Override
    public <T extends MessageVoVisitor> T accept(T visitor)
    {
        visitor.visit(this);
        return visitor;
    }

    public Long getId()
    {
        return id;
    }

    public UserVo getReciever()
    {
        return reciever;
    }

    public UserVo getSender()
    {
        return sender;
    }

    public String getContent()
    {
        return content;
    }

    public Timestamp getSendDateTime()
    {
        return sendDateTime;
    }

    public static final class Builder implements ValueObjectBuilder<Builder>
    {
        private Long id;
        private UserVo reciever;
        private UserVo sender;
        private String content;
        private Timestamp sendDateTime;


        public Builder receiever(UserVo reciever){
            this.reciever = reciever;
            return this;
        }
        public Builder sender(UserVo sender){
            this.sender = sender;
            return this;
        }
        public Builder content(String content){
            this.content = content;
            return this;
        }
        public Builder sendDateTime(Timestamp timestamp){
            this.sendDateTime = timestamp;
            return this;
        }
        public MessageVo build(){
            return new MessageVo(this);
        }

        @Override
        public Builder id(Long id)
        {
            this.id = id;
            return this;
        }
    }
    public interface MessageVoVisitor extends BaseVoVisitor<MessageVo>
    {
        void visit(MessageVo message);
    }

    @Override
    public String toString()
    {
        return "MessageVo{" +
                "id=" + id +
                ", reciever=" + reciever +
                ", sender=" + sender +
                ", content='" + content + '\'' +
                ", sendDateTime=" + sendDateTime +
                '}';
    }
}
