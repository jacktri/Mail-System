package project.common.vo.utils;

@FunctionalInterface
public interface ValueObjectBuilder<B extends ValueObjectBuilder>
{
    B id(Long id);
}
