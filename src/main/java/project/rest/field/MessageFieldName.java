package project.rest.field;

import project.common.rest.IFieldName;

public enum MessageFieldName implements IFieldName
{
    SENDER("sender"),
    RECEIVER("receiver"),
    CONTENT("content"),
    SENDDATETIME("sendDateTime")
    ;

    private final String fieldName;

    private IFieldName[] childFieldNames;

    MessageFieldName(String fieldName){
        this(fieldName, null);
    }

    MessageFieldName(String fieldName, IFieldName[] childFieldNames){
        this.fieldName = fieldName;
        this.childFieldNames = childFieldNames;
    }
    @Override
    public String getFieldName()
    {
        return fieldName;
    }

    @Override
    public IFieldName[] getChildFieldNames()
    {
        return childFieldNames;
    }
}
