package project.vo;

import project.common.vo.visitor.ValueObject;
import project.common.vo.utils.ValueObjectBuilder;

public class UserVo implements ValueObject
{
    private String login;
    private String email;
    private String firstName;
    private String lastName;
    private String password;

    public UserVo(Builder builder){
        this.login = builder.login;
        this.email = builder.email;
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.password = builder.password;
    }
    public UserVo(String login, String password){
        this.login = login;
        this.password = password;
    }

    public String getLogin()
    {
        return login;
    }

    public String getPassword()
    {
        return password;
    }

    public static final class Builder implements ValueObjectBuilder<Builder>
    {
        private String login;
        private String email;
        private String firstName;
        private String lastName;
        private String password;

        public Builder login(String login){
            this.login = login;
            return this;
        }
        public Builder email(String email){
            this.email = email;
            return this;
        }
        public Builder firstName(String firstName){
            this.firstName = firstName;
            return this;
        }
        public Builder lastName(String lastName){
            this.lastName = lastName;
            return this;
        }
        public Builder password(String password){
            this.password = password;
            return this;
        }
        public UserVo build(){
            return new UserVo(this);
        }
    }
}
