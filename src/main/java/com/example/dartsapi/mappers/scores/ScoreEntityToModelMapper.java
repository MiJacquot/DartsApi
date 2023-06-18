package com.example.dartsapi.mappers.scores;

import com.example.dartsapi.entities.ScoreEntity;
import com.example.dartsapi.model.Score;
import org.bson.types.ObjectId;

public class ScoreEntityToModelMapper {

    public static Score scoreModelToEntity(ScoreEntity entity) {
        Score score = new Score();
        score.setId(entity.getId().toHexString());
        score.setScore(entity.getScore());
        score.setNumPLayer(entity.getNumPLayer());
        score.setPlayerName(entity.getPlayerName());
        return score;
    }
}
