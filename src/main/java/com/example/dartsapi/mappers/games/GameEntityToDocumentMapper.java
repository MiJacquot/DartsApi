package com.example.dartsapi.mappers.games;

import com.example.dartsapi.entities.GameEntity;
import com.example.dartsapi.entities.ScoreEntity;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;

import static com.example.dartsapi.mappers.scores.ScoreEntityToDocument.scoreEntityToDocument;

public class GameEntityToDocumentMapper {

    public static Document gameEntityToDocument(GameEntity entity) {
        Document document = new Document();
        document.put("date", entity.getDate());
        document.put("userId", entity.getUserId());
        document.put("status", entity.getStatus());
        document.put("numberOfPlayers", entity.getNumberOfPlayers());
        document.put("numPlayerRound", entity.getNumPlayerRound());

        List<Document> scoreDocuments = new ArrayList<>();
        for (ScoreEntity scoreEntity : entity.getScores()) {
            Document scoreDocument = new Document();
            scoreDocument.put("playerName", scoreEntity.getPlayerName());
            scoreDocument.put("score", scoreEntity.getScore());
            scoreDocument.put("numPlayer", scoreEntity.getNumPlayer());
            scoreDocuments.add(scoreDocument);
        }
        document.put("scores", scoreDocuments);

        return document;
    }

}
