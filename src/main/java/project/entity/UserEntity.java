package project.entity;

import project.common.BaseEntityVisitor;
import project.common.vo.utils.EntityBuilder;
import project.common.vo.visitor.ValueObject;
import project.common.vo.visitor.Visitable;
import project.vo.MessageVo;

import javax.persistence.*;

@Entity
@Table(name = "userentity")
public class UserEntity extends BaseEntity implements Visitable<UserEntity.UserEntityVisitor>
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String username;

    @Column
    private String password;

    public UserEntity(String username, String password)
    {
        this.username = username;
        this.password = password;
    }

    public UserEntity(Builder builder){
        this.username = builder.username;
        this.password = builder.password;
    }

    public UserEntity()
    {
    }

    public String getUsername()
    {
        return username;
    }

    public String getPassword()
    {
        return password;
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
        private String username;
        private String password;

        @Override
        public Builder id(Long id)
        {
            this.id = id;
            return this;
        }

        public Builder username(String username){
            this.username = username;
            return this;
        }

        public Builder password(String password){
            this.password = password;
            return this;
        }

        public UserEntity build(){
            return new UserEntity(this);
        }
    }

    @Override
    public <T extends UserEntityVisitor> T accept(T visitor)
    {
        visitor.visit(this);
        return visitor;
    }

    public interface UserEntityVisitor extends BaseEntityVisitor<UserEntity>
    {
        @Override
        void visit(UserEntity entity);
    }
}
