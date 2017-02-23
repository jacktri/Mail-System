package project.entity;

import project.common.BaseEntityVisitor;
import project.common.vo.visitor.Visitable;

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
