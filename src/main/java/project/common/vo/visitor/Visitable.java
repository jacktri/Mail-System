package project.common.vo.visitor;

@FunctionalInterface
public interface Visitable<V extends Visitor> {
    <T extends V> T accept(T visitor);
}
