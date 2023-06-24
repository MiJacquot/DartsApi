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
        // Conversion de Date vers LocalDateTime
        LocalDateTime localDateTime = entity.getDate().toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDateTime();

        // Utilisation de DateTimeFormatter pour formater la date
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        String formattedDate = localDateTime.format(formatter);

        document.put("date", formattedDate);
        document.put("userId", entity.getUserId());
        document.put("scores", entity.getScores());
        document.put("status", entity.getStatus());
        document.put("numberOfPlayers", entity.getNumberOfPlayers());
        document.put("numPlayerRound", entity.getNumPlayerRound());
        return document;
    }

}
