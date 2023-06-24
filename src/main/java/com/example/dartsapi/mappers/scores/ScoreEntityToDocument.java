package com.example.dartsapi.mappers.scores;

import com.example.dartsapi.entities.GameEntity;
import com.example.dartsapi.entities.ScoreEntity;
import org.bson.Document;

public class ScoreEntityToDocument {

    public static Document scoreEntityToDocument(ScoreEntity entity) {
        Document document = new Document();
        document.put("playerName", entity.getPlayerName());
        document.put("score", entity.getScore());
        document.append("numPlayer", entity.getNumPlayer());
        return document;
    }
}
