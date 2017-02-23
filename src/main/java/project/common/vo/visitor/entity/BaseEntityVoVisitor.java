package project.common.vo.visitor.entity;

import project.entity.BaseEntity;
import project.common.vo.utils.ValueObjectBuilder;
import project.common.BaseEntityVisitor;

public abstract class BaseEntityVoVisitor<E extends BaseEntity, B extends ValueObjectBuilder<B>> implements
        BaseEntityVisitor<E>
{
    protected final B builder;

    public BaseEntityVoVisitor(final B builder){
        this.builder = builder;
    }

    @Override
    public void visit(final E entity){

    }
    public B getBuilder(){
        return builder;
    }
}
