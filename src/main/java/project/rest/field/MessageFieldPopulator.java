package project.rest.field;

import org.springframework.stereotype.Component;
import project.common.rest.Field;
import project.common.rest.FieldPopulator;
import project.common.rest.IFieldName;
import project.controller.dto.MessageDto;
import project.vo.MessageVo;

import java.util.ArrayList;
import java.util.List;

import static project.rest.field.MessageFieldName.*;

@Component
public class MessageFieldPopulator extends FieldPopulator<MessageDto.Builder, MessageVo>
{

    @Override
    public MessageDto.Builder populateField(MessageDto.Builder dtoBuilder, MessageVo vo, Field field)
    {
        if (SENDER.equals(field.getFieldName()))
            {
            dtoBuilder.sender(vo.getSender().getLogin());
            } else if (RECEIVER.equals(field.getFieldName()))
            {
            dtoBuilder.receiever(vo.getReciever().getLogin());
            } else if (CONTENT.equals(field.getFieldName()))
            {
            dtoBuilder.content(vo.getContent());
            } else if (SENDDATETIME.equals(field.getFieldName()))
            {
            dtoBuilder.sendDateTime(vo.getSendDateTime().toString());
            }
        return dtoBuilder;
    }

    @Override
    public IFieldName[] getAllFieldNames()
    {
        return MessageFieldName.values();
    }

    public Field[] getAllChildFields()
    {
        List<Field> allChildFields = new ArrayList<>();

        for (Field field : allFields.values())
            {
            if (field.getFieldName().getChildFieldNames() == null)
                {
                allChildFields.add(field);
                }
            }
        return allChildFields.toArray(new Field[allChildFields.size()]);
    }

}
