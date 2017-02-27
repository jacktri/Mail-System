package project.common.vo.visitor;

import project.common.BaseVoVisitor;
import project.common.vo.utils.EntityBuilder;
import project.vo.BaseVo;

public abstract class BaseVoEntityVisitor<V extends BaseVo, B extends EntityBuilder<B>> implements BaseVoVisitor<V>
{
    protected B builder;

    public BaseVoEntityVisitor(final B builder){
        this.builder = builder;
    }

    @Override
    public void visit(final V visitor){

    }

    public B getBuilder(){
        return builder;
    }

}
