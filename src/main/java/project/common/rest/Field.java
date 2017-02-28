package project.common.rest;

public class Field
{
    private final IFieldName fieldName;
    private final String fieldPath;

    public Field(IFieldName fieldName, String fieldPath){
        this.fieldName = fieldName;
        this.fieldPath = fieldPath;
    }

    public IFieldName getFieldName()
    {
        return fieldName;
    }

    public String getFieldPath()
    {
        return fieldPath;
    }
}
