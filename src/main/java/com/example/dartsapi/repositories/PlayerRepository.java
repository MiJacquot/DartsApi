package com.example.dartsapi.repositories;

import com.example.dartsapi.database.MongoConnection;
import com.example.dartsapi.entities.PlayerEntity;
import com.example.dartsapi.entities.UserEntity;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.InsertOneResult;
import org.bson.Document;
import org.bson.conversions.Bson;
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

    public List<PlayerEntity> findAllByIds(List<String> ids) {
        List<ObjectId> objectIds = new ArrayList<>();
        ids.forEach((id) -> {
            objectIds.add(new ObjectId(id));
        });
        List<PlayerEntity> players = new ArrayList<>();
        Document query = new Document("_id", new Document("$in", objectIds));

        MongoCursor<Document> cursor = playerRepository.find(query).iterator();
        while (cursor.hasNext()) {
            Document document = cursor.next();
            players.add(mapDocumentToEntity(document,PlayerEntity.class));
        }
        cursor.close();;
        return players;
    }
    public PlayerEntity findOneById(String id) {
        return mapDocumentToEntity(Objects.requireNonNull(playerRepository.find(eq("_id", new ObjectId(id))).first()), PlayerEntity.class);
    }

    public ObjectId addOne(PlayerEntity toAdd) {
        InsertOneResult result = playerRepository.insertOne(playerEntityToDocument(toAdd));
        return result.getInsertedId().asObjectId().getValue();
    }

    public boolean deleteOne(String id) {
        DeleteResult result = playerRepository.deleteOne(eq("_id", new ObjectId(id)));
        return result.getDeletedCount() != 0;
    }
}
