package project.vo.visitor;

import project.common.vo.visitor.BaseVoEntityVisitor;
import project.entity.UserEntity;
import project.vo.MessageVo;
import project.vo.UserVo;

public class UserVoEntityVisitor extends BaseVoEntityVisitor<UserVo, UserEntity.Builder>
        implements UserVo.UserVoVisitor
{
    public UserVoEntityVisitor(UserEntity.Builder builder)
    {
        super(builder);
    }

    @Override
    public void visit(final UserVo userVo)
    {
        super.visit(userVo);
        builder.username(userVo
                        .getLogin())
                .password(userVo.getPassword());
    }

}
