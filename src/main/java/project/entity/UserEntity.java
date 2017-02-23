package project.entity;

import project.common.vo.Visitable;
import project.common.BaseEntityVisitor;

import javax.persistence.*;

@Entity
@Table(name = "userentity")
public class UserEntity extends BaseEntity implements Visitable<UserEntity.UserEntityVisitor>
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column
    private String username;

    @Column
    private String password;

    public UserEntity()
    {
    }

    public UserEntity(String username, String password)
    {
        this.username = username;
        this.password = password;
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
