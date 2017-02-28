package project.controller.dto;

public class UserDto
{

    private String username;
    private String password;

    public UserDto(){
    }

    public UserDto(String username, String password){
        this.username = username;
        this.password = password;
    }

    public UserDto(Builder builder){
        this.username = builder.username;
        this.password = builder.password;
    }

    public String getUsername()
    {
        return username;
    }

    public String getPassword()
    {
        return password;
    }

    public static final class Builder{
        private String username;
        private String password;

        public Builder username(String username){
            this.username = username;
            return this;
        }
        public Builder password(String password){
            this.password = password;
            return this;
        }
        public UserDto build(){
            return new UserDto(this);
        }
    }
}
