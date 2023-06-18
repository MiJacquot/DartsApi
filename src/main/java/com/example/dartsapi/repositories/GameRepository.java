package com.example.dartsapi.repositories;

import com.example.dartsapi.database.MongoConnection;
import com.example.dartsapi.entities.GameEntity;
import com.example.dartsapi.entities.UserEntity;
import com.example.dartsapi.model.Game;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.result.InsertOneResult;
import com.mongodb.client.result.UpdateResult;
import org.bson.Document;
import org.bson.types.ObjectId;

import java.util.ArrayList;
import java.util.List;

import static com.example.dartsapi.mappers.DocumentToEntityMapper.mapDocumentToEntity;
import static com.example.dartsapi.mappers.games.GameEntityToDocumentMapper.gameEntityToDocument;
import static com.example.dartsapi.mappers.users.UserEntityToDocumentMapper.userEntityToDocument;
import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Indexes.ascending;

public class GameRepository {

    private final MongoCollection<Document> gameRepository = MongoConnection.getInstance().database.getCollection("game");

    // we do not use some queries, but we need to show that we can di it if necessary ^^
    public List<GameEntity> findAllByUser(UserEntity user) {
        List<GameEntity> games = new ArrayList<>();
        gameRepository.find(eq("user", user)).sort(ascending("date")).forEach(document -> {
            games.add(mapDocumentToEntity(document, GameEntity.class));
        });
        return games;
    }
    public ObjectId addOne(GameEntity toAdd) {
        Document document = gameEntityToDocument(toAdd);
        document.append("userEntity", userEntityToDocument(toAdd.getUserEntity()));
        InsertOneResult result = gameRepository.insertOne(document);
        return result.getInsertedId().asObjectId().getValue();
    }


    public boolean updateOneGame(GameEntity entity) {
        UpdateResult result = gameRepository.replaceOne(eq("_id", entity.getId()), gameEntityToDocument(entity));
        return result.wasAcknowledged();
    }
}