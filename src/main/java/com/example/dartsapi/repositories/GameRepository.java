package com.example.dartsapi.repositories;

import com.example.dartsapi.database.MongoConnection;
import com.example.dartsapi.entities.GameEntity;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.result.InsertOneResult;
import com.mongodb.client.result.UpdateResult;
import org.bson.Document;
import org.bson.types.ObjectId;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static com.example.dartsapi.mappers.DocumentToEntityMapper.mapDocumentToEntity;
import static com.example.dartsapi.mappers.games.DocumentToGameEntityMapper.documentToGameEntity;
import static com.example.dartsapi.mappers.games.GameEntityToDocumentMapper.gameEntityToDocument;
import static com.example.dartsapi.mappers.scores.ScoreEntityToDocument.scoreEntityToDocument;
import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Indexes.ascending;

public class GameRepository {

    private final MongoCollection<Document> gameRepository;

    public GameRepository() {
        gameRepository = MongoConnection.getInstance().database.getCollection("game");
        gameRepository.createIndex(ascending("date"));
    }

    public List<GameEntity> findAllByUserId(ObjectId userId) {
        List<GameEntity> games = new ArrayList<>();
        gameRepository.find(eq("userId", userId)).sort(ascending("date")).forEach(document -> {
            games.add(documentToGameEntity(document));
        });
        return games;
    }
    public ObjectId addOne(GameEntity toAdd) {
        Document document = gameEntityToDocument(toAdd);

        InsertOneResult result = gameRepository.insertOne(document);
        return Objects.requireNonNull(result.getInsertedId()).asObjectId().getValue();
    }


    public boolean updateOneGame(GameEntity entity) {
        UpdateResult result = gameRepository.replaceOne(eq("_id", entity.getId()), gameEntityToDocument(entity));
        return result.wasAcknowledged();
    }
}