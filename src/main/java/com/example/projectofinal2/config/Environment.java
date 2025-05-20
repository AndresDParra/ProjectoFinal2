package com.example.projectofinal2.config;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCluster;
import com.mongodb.client.MongoDatabase;
import io.github.cdimascio.dotenv.Dotenv;

public enum Environment {

    INSTANCE;

    public MongoDatabase env_value() {
       Dotenv dotenv =Dotenv.load();
        String mongoString = dotenv.get("MONGO_STRING");
        if (mongoString == null) {
            throw new RuntimeException("MONGO_STRING is not set in .env or environment variables");
        }
        MongoClient mongoClients;
        try {
            mongoClients = MongoClients.create(mongoString);
        } catch (Exception e) {
            throw new RuntimeException("Error connecting to MongoDB: " + e.getMessage());
        }
        return mongoClients.getDatabase("CuentasDeBanco");
    }
}


