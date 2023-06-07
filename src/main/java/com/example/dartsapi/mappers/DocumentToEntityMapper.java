package com.example.dartsapi.mappers;

import org.bson.Document;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DocumentToEntityMapper {

    // Generic method to convert any document to the desired entity
    public static <T> T mapDocumentToEntity(Document document, Class<T> entityClass) {
        try {
            T entity = entityClass.newInstance();
            Map<String, Field> fieldsMap = getFieldMap(entityClass);

            for (String attributeName : document.keySet()) {
                Object attributeValue = null;
                Field field = null;
                // handle the case of the id field which is named _id in mongo
                if (attributeName.equals("_id")) {
                    attributeValue = document.get(attributeName);
                    field = fieldsMap.get("id");
                } else {
                    attributeValue = document.get(attributeName);
                    field = fieldsMap.get(attributeName);
                }


                if (field != null) {
                    field.setAccessible(true);
                    if (field.getType().isArray() && attributeValue instanceof List) {
                        List<?> attributeList = (List<?>) attributeValue;
                        Class<?> componentType = field.getType().getComponentType();
                        Object[] array = (Object[]) Array.newInstance(componentType, attributeList.size());
                        for (int i = 0; i < attributeList.size(); i++) {
                            Object item = attributeList.get(i);
                            if (item instanceof Document) {
                                item = mapDocumentToEntity((Document) item, componentType);
                            }
                            array[i] = item;
                        }
                        field.set(entity, array);
                    } else {
                        field.set(entity, attributeValue);
                    }
                }
            }

            return entity;
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
            return null;
        }
    }

    // we return all fields (attributes) of a specific entity
    public static Map<String, Field> getFieldMap(Class<?> entityClass) {
        Map<String, Field> fieldMap = new HashMap<>();

        for (Field field : entityClass.getDeclaredFields()) {
            fieldMap.put(field.getName(), field);
        }

        return fieldMap;
    }
}
