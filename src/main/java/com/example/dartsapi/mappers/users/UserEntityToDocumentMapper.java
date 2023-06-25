package com.example.dartsapi.mappers.users;

import com.example.dartsapi.entities.UserEntity;
import org.bson.Document;

public class UserEntityToDocumentMapper {

    public static Document userEntityToDocument(UserEntity entity) {
        Document document = new Document();
        if (entity.getId() != null) {
            document.put("_id", entity.getId());
        }
        document.put("email", entity.getEmail());
        document.put("password", entity.getPassword());
        if (entity.getPlayerIds() != null) {
            document.put("playerIds", entity.getPlayerIds());
        }

        return document;
    }
}
