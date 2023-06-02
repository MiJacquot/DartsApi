package com.example.dartsapi.database;


import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;

public final class MongoConnection {
        private final String connectionString = "mongodb+srv://mijacquot:3DrHMPvIdwdCqcxo@dartsappcluster.jfckbhc.mongodb.net/?retryWrites=true&w=majority";
        private static MongoConnection instance;
        public MongoDatabase database;
        private MongoConnection() {
            try (MongoClient mongoClient = MongoClients.create(connectionString)) {
                database = mongoClient.getDatabase("DartsAppCluster");
            }
        }

        public static com.example.dartsapi.database.MongoConnection getInstance() {
            if (instance == null) {
                instance = new MongoConnection();
            }
            return instance;
        }



}
