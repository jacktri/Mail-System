package project.common.rest;

import org.thymeleaf.util.ArrayUtils;
import project.common.vo.visitor.ValueObject;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public abstract class FieldPopulator<B, V extends ValueObject>
{

    public FieldPopulator()
    {
        for (Field field : expandFieldNames(getAllFieldNames()))
            {
            allFields.put(field.getFieldPath(), field);
            }
    }

    protected Map<String, Field> allFields = new LinkedHashMap<>();

    public B populate(B dtoBuilder, V vo, Field[] fields)
    {
        for (Field field : fields)
            {
            populateField(dtoBuilder, vo, field);
            }
        return dtoBuilder;
    }


    private Field[] expandFieldNames(IFieldName... fieldNames)
    {
        List<Field> exposedFields = new ArrayList<>();
        for (IFieldName fieldName : fieldNames)
            {
            if (!isExcluded(fieldName))
                {
                exposedFields.add(new Field(fieldName,
                        fieldName.getFieldName()));
                getExposedFieldNames(fieldName.getFieldName() + ".",
                        fieldName,
                        exposedFields);
                }
            }
        return exposedFields.toArray(new Field[exposedFields.size()]);
    }

    private void getExposedFieldNames(String path, IFieldName fieldName, List<Field> exposedFields)
    {
        if (fieldName.getChildFieldNames() != null)
            {
            for (IFieldName childFieldName : fieldName.getChildFieldNames())
                {
                if (!isExcluded(childFieldName))
                    {
                    exposedFields.add(new Field(childFieldName, path
                            + childFieldName.getFieldName()));
                    getExposedFieldNames(path + childFieldName.getFieldName()
                            + ".", childFieldName, exposedFields);
                    }
                }
            }
    }

    public IFieldName[] getExcludedChildFieldNames()
    {
        return new IFieldName[0];
    }

    private boolean isExcluded(IFieldName fieldName)
    {
        return ArrayUtils.contains(getExcludedChildFieldNames(), fieldName);
    }

    public abstract B populateField(B dtoBuilder, V vo, Field field);

    public abstract IFieldName[] getAllFieldNames();
}
