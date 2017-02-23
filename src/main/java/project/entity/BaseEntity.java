package project.entity;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class BaseEntity
{
    public abstract Long getId();

    public abstract void setId(Long id);
}
