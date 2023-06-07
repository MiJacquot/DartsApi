package com.example.dartsapi.repositories;

import com.example.dartsapi.database.MongoConnection;
import com.example.dartsapi.entities.PlayerEntity;
import com.example.dartsapi.entities.UserEntity;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import org.bson.Document;
import org.bson.types.ObjectId;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static com.example.dartsapi.mappers.DocumentToEntityMapper.mapDocumentToEntity;
import static com.example.dartsapi.mappers.players.PlayerEntityToDocumentMapper.playerEntityToDocument;
import static com.mongodb.client.model.Filters.eq;

public class PlayerRepository {

    private final MongoCollection<Document> playerRepository = MongoConnection.getInstance().database.getCollection("player");

    public List<PlayerEntity> findAll() {
        List<PlayerEntity> playerEntityList = new ArrayList<>();
        FindIterable<Document> result = playerRepository.find();
        for (Document document : result) {
            playerEntityList.add(mapDocumentToEntity(document, PlayerEntity.class));
        }
        return playerEntityList;
    }

    public PlayerEntity findOneById(String Id) {
        return mapDocumentToEntity(Objects.requireNonNull(playerRepository.find(eq("_id", new ObjectId(Id))).first()), PlayerEntity.class);
    }

    public PlayerEntity addOne(PlayerEntity toAdd) {
        playerRepository.insertOne(playerEntityToDocument(toAdd));
        return toAdd;
    }
}
