package com.example.dartsapi.mappers.users;

import com.example.dartsapi.entities.UserEntity;
import org.bson.Document;

public class UserEntityToDocumentMapper {

    public static Document userEntityToDocument(UserEntity entity) {
        Document document = new Document();
        document.put("username", entity.getUsername());
        document.put("password", entity.getPassword());
        document.put("playerIds", entity.getPlayerIds());
        return document;
    }
}
