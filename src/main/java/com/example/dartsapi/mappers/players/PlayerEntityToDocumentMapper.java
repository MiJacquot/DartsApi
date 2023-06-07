package com.example.dartsapi.mappers.players;

import com.example.dartsapi.entities.PlayerEntity;
import org.bson.Document;

public class PlayerEntityToDocumentMapper {

    public static Document playerEntityToDocument(PlayerEntity entity) {
        Document document = new Document();
        document.put("name", entity.getName());
        return document;
    }
}
