package com.example.dartsapi.mappers.games;

import com.example.dartsapi.entities.GameEntity;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;

import static com.example.dartsapi.mappers.scores.ScoreEntityToDocument.scoreEntityToDocument;

public class GameEntityToDocumentMapper {

    public static Document gameEntityToDocument(GameEntity entity) {
        Document document = new Document();
        document.put("date", entity.getDate());
        document.put("userId", entity.getUserId());
        List<Document> scoreArray = new ArrayList<>();
        entity.getScores().forEach(scoreEntity -> {
            scoreArray.add(scoreEntityToDocument(scoreEntity));
        });
        document.put("scores", scoreArray);
        document.put("status", entity.getStatus());
        document.put("numberOfPlayers", entity.getNumberOfPlayers());
        document.put("numPlayerRound", entity.getNumPlayerRound());
        return document;
    }

}
