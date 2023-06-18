package com.example.dartsapi.mappers.games;

import com.example.dartsapi.entities.GameEntity;
import org.bson.Document;

public class GameEntityToDocumentMapper {

    public static Document gameEntityToDocument(GameEntity entity) {
        Document document = new Document();
        document.put("date", entity.getDate());
        document.put("userEntity", entity.getUserEntity());
        document.put("scores", entity.getScores());
        document.put("status", entity.getStatus());
        document.put("numPlayerRound", entity.getNumPlayerRound());
        return document;
    }

}