package project.common.vo;

import project.common.vo.visitor.Visitor;

public interface Visitable<V extends Visitor> {
    <T extends V> T accept(T visitor);
}
