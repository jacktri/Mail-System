package project.vo.visitor.entity;

import project.common.vo.visitor.entity.BaseEntityVoVisitor;
import project.entity.UserEntity;
import project.vo.UserVo;

public class UserEntityVoVisitor extends BaseEntityVoVisitor<UserEntity, UserVo.Builder>
        implements UserEntity.UserEntityVisitor
{
    public UserEntityVoVisitor(final UserVo.Builder builder)
    {
        super(builder);
    }

    public void visit(final UserEntity userEntity)
    {
        super.visit(userEntity);
        builder.login(userEntity.getUsername());
        builder.password(userEntity.getPassword());
    }
}
