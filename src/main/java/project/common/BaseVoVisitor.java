package project.common;

import project.common.vo.visitor.Visitor;
import project.vo.BaseVo;

@FunctionalInterface
public interface BaseVoVisitor<V extends BaseVo> extends Visitor
{
    void visit(V valueObject);
}
