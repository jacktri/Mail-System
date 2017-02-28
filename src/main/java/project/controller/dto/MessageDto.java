package project.controller.dto;

import project.vo.UserVo;

import java.sql.Timestamp;

public class MessageDto
{
    private String receiver;
    private String sender;
    private String content;
    private String sendDateTime;

    public MessageDto(Builder builder){
        this.receiver = builder.receiver;
        this.sender = builder.sender;
        this.content = builder.content;
        this.sendDateTime = builder.sendDateTime;
    }

    public MessageDto()
    {
    }

    public MessageDto(String receiver, String sender, String content, String sendDateTime)
    {
        this.receiver = receiver;
        this.sender = sender;
        this.content = content;
        this.sendDateTime = sendDateTime;
    }

    public String getReceiver()
    {
        return receiver;
    }

    public void setReceiver(String receiver)
    {
        this.receiver = receiver;
    }

    public String getSender()
    {
        return sender;
    }

    public void setSender(String sender)
    {
        this.sender = sender;
    }

    public String getContent()
    {
        return content;
    }

    public void setContent(String content)
    {
        this.content = content;
    }

    public String getSendDateTime()
    {
        return sendDateTime;
    }

    public void setSendDateTime(String sendDateTime)
    {
        this.sendDateTime = sendDateTime;
    }

    public static final class Builder{
        private String receiver;
        private String sender;
        private String content;
        private String sendDateTime;

        public Builder receiever(String receiver){
            this.receiver = receiver;
            return this;
        }
        public Builder sender(String sender){
            this.sender = sender;
            return this;
        }
        public Builder content(String content){
            this.content = content;
            return this;
        }
        public Builder sendDateTime(String sendDateTime){
            this.sendDateTime = sendDateTime;
            return this;
        }
        public MessageDto build(){
            return new MessageDto(this);
        }

    }
}
