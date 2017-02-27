package project.vo.visitor;

import project.common.vo.visitor.BaseVoEntityVisitor;
import project.entity.UserEntity;
import project.vo.UserVo;

public class UserVoEntityVisitor extends BaseVoEntityVisitor<UserVo, UserEntity.Builder>
        implements UserVo.UserVoVisitor
{
    public UserVoEntityVisitor(UserEntity.Builder builder)
    {
        super(builder);
    }

}
