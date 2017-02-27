package project.common.vo.utils;

@FunctionalInterface
public interface EntityBuilder<B extends EntityBuilder>
{
    B id(Long id);
}
