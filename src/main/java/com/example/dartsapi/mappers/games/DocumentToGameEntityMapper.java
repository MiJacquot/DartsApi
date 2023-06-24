package com.example.dartsapi.mappers.games;

import com.example.dartsapi.entities.GameEntity;
import com.example.dartsapi.entities.ScoreEntity;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;

public class DocumentToGameEntityMapper {

    public static GameEntity documentToGameEntity(Document document) {
        GameEntity entity = new GameEntity();
        entity.setId(document.getObjectId("_id"));
        entity.setDate(document.getDate("date"));
        entity.setUserId(document.getObjectId("userId"));
        entity.setStatus(document.getString("status"));
        entity.setNumberOfPlayers(document.getInteger("numberOfPlayers"));
        entity.setNumPlayerRound(document.getInteger("numPlayerRound"));

        List<ScoreEntity> scores = new ArrayList<>();
        List<Document> scoreDocuments = document.getList("scores", Document.class);
        for (Document scoreDocument : scoreDocuments) {
            ScoreEntity scoreEntity = new ScoreEntity();
            scoreEntity.setId(scoreDocument.getObjectId("_id"));
            scoreEntity.setPlayerName(scoreDocument.getString("playerName"));
            scoreEntity.setScore(scoreDocument.getInteger("score"));
            scoreEntity.setNumPlayer(scoreDocument.getInteger("numPlayer"));
            scores.add(scoreEntity);
        }
        entity.setScores(scores);

        return entity;
    }
}