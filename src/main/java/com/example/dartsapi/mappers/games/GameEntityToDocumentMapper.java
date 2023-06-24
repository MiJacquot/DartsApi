package com.example.dartsapi.mappers.games;

import com.example.dartsapi.entities.GameEntity;
import org.bson.Document;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class GameEntityToDocumentMapper {

    public static Document gameEntityToDocument(GameEntity entity) {
        Document document = new Document();
        document.put("userId", entity.getUserId());
        document.put("scores", entity.getScores());
        document.put("status", entity.getStatus());
        document.put("numberOfPlayers", entity.getNumberOfPlayers());
        document.put("numPlayerRound", entity.getNumPlayerRound());
        return document;
    }

}
