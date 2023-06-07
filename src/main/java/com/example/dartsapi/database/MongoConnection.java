package com.example.dartsapi.database;


import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.ServerApi;
import com.mongodb.ServerApiVersion;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;

public final class MongoConnection {
        private final String connectionString = "mongodb+srv://mijacquot:3DrHMPvIdwdCqcxo@dartsappcluster.jfckbhc.mongodb.net/?retryWrites=true&w=majority";
        private static MongoConnection instance;
        public MongoDatabase database;
        private MongoConnection() {
            ServerApi serverApi = ServerApi.builder()
                    .version(ServerApiVersion.V1)
                    .build();
            MongoClientSettings settings = MongoClientSettings.builder()
                    .applyConnectionString(new ConnectionString(connectionString))
                    .serverApi(serverApi)
                    .build();
            // Create a new client and connect to the server
            MongoClient mongoClient = MongoClients.create(settings);
                try {
                    database = mongoClient.getDatabase("DartsAppCluster");
                } catch (Exception e) {
                    mongoClient.close();
                    throw new RuntimeException(e);

                }
            }

        public static synchronized MongoConnection getInstance() {
            if (instance == null) {
                instance = new MongoConnection();
            }
            return instance;
        }



}
