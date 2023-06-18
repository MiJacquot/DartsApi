package com.example.dartsapi.mappers.scores;

import com.example.dartsapi.entities.ScoreEntity;
import com.example.dartsapi.model.Score;
import org.bson.types.ObjectId;

public class ScoreModelToEntityMapper {

    public static ScoreEntity scoreModelToEntity(Score score) {
        ScoreEntity entity = new ScoreEntity();
        if (score.getId() != null) {
            entity.setId(new ObjectId(score.getId()));
        }
        entity.setScore(score.getScore());
        entity.setNumPlayer(score.getNumPlayer());
        entity.setPlayerName(score.getPlayerName());
        return entity;
    }
}
