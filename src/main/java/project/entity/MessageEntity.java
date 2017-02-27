package project.entity;

import project.common.BaseEntityVisitor;
import project.common.vo.utils.EntityBuilder;
import project.common.vo.visitor.Visitable;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "messageentity")
public class MessageEntity extends BaseEntity implements Visitable<MessageEntity.MessageEntityVisitor>
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne
    private UserEntity owner;

    @OneToOne
    private UserEntity sender;

    @Column
    private String content;

    @Column
    private Timestamp sendDateTime;

    public MessageEntity()
    {
    }

    public MessageEntity(UserEntity owner, UserEntity sender, String content, Timestamp timestamp)
    {
        this.owner = owner;
        this.sender = sender;
        this.content = content;
        this.sendDateTime = timestamp;
    }

    public MessageEntity(Builder builder){
        this.id = builder.id;
        this.owner = builder.owner;
        this.sender = builder.sender;
        this.content = builder.content;
        this.sendDateTime = builder.sendDateTime;
    }

    public UserEntity getOwner()
    {
        return owner;
    }

    public UserEntity getSender()
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

    @Override
    public Long getId()
    {
        return id;
    }

    @Override
    public void setId(Long id)
    {
        this.id = id;
    }

    public static final class Builder implements EntityBuilder<Builder>
    {
        private Long id;
        private UserEntity owner;
        private UserEntity sender;
        private String content;
        private Timestamp sendDateTime;

        @Override
        public Builder id(Long id)
        {
            this.id = id;
            return this;
        }

        public Builder owner(UserEntity owner){
            this.owner = owner;
            return this;
        }

        public Builder sender(UserEntity sender){
            this.sender = sender;
            return this;
        }

        public Builder content(String content){
            this.content = content;
            return this;
        }
        public Builder sendDateTime(Timestamp sendDateTime){
            this.sendDateTime = sendDateTime;
            return this;
        }

        public MessageEntity build(){
            return new MessageEntity(this);
        }
    }

    @Override
    public <T extends MessageEntity.MessageEntityVisitor> T accept(T visitor)
    {
        visitor.visit(this);
        return visitor;
    }

    public interface MessageEntityVisitor extends BaseEntityVisitor<MessageEntity>
    {
        @Override
        void visit(MessageEntity entity);
    }
}
