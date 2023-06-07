package com.example.dartsapi.repositories;

import com.example.dartsapi.database.MongoConnection;
import com.example.dartsapi.entities.UserEntity;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.FindOneAndUpdateOptions;
import com.mongodb.client.model.ReturnDocument;
import com.mongodb.client.model.Updates;
import com.mongodb.client.result.InsertOneResult;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static com.example.dartsapi.mappers.DocumentToEntityMapper.mapDocumentToEntity;
import static com.example.dartsapi.mappers.users.UserEntityToDocumentMapper.userEntityToDocument;
import static com.mongodb.client.model.Aggregates.match;
import static com.mongodb.client.model.Filters.elemMatch;
import static com.mongodb.client.model.Filters.eq;
import static java.util.Arrays.asList;


public class UserRepository {

    private final MongoCollection<Document> userRepository = MongoConnection.getInstance().database.getCollection("user");

    public List<UserEntity> findAll() {
        List<UserEntity> userEntityList = new ArrayList<>();
        FindIterable<Document> result = userRepository.find();
        for (Document document : result) {
            userEntityList.add(mapDocumentToEntity(document, UserEntity.class));
        }
        return userEntityList;
    }

    public UserEntity findOneById(String Id) {
        return mapDocumentToEntity(Objects.requireNonNull(userRepository.find(eq("_id", new ObjectId(Id))).first()), UserEntity.class);
    }

    public UserEntity addOne(UserEntity toAdd) {
        InsertOneResult result = userRepository.insertOne(userEntityToDocument(toAdd));
        toAdd.setId(Objects.requireNonNull(result.getInsertedId()).asObjectId().getValue());
        return toAdd;
    }

    public boolean addOnePlayerToUser(String userId, String playerId) {
        Bson filter = Filters.eq("_id", new ObjectId(userId));
        Bson update = Updates.push("players", playerId);
        Document result = userRepository.findOneAndUpdate(filter, update);
        return true;
    }

    public boolean checkIfUserExists(String username, String password) {
        Bson matchUsernameStage = match(eq("username", username));
        Bson matchPasswordStage = match(eq("password", password));
        Document result = userRepository.aggregate(asList(matchUsernameStage, matchPasswordStage)).first();
        return result != null;
    }



}
