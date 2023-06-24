package com.example.dartsapi.mappers.scores;

import com.example.dartsapi.entities.ScoreEntity;
import com.example.dartsapi.model.Score;
import org.bson.types.ObjectId;

public class ScoreEntityToModelMapper {

    public static Score scoreEntityToModel(ScoreEntity entity) {
        Score score = new Score();
        score.setScore(entity.getScore());
        score.setNumPlayer(entity.getNumPlayer());
        score.setPlayerName(entity.getPlayerName());
        return score;
    }
}
