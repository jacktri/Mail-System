package project.common;

import project.entity.BaseEntity;
import project.common.vo.visitor.Visitor;

@FunctionalInterface
public interface BaseEntityVisitor<E extends BaseEntity> extends Visitor
{
    void visit(E entity);
}
