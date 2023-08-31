package org.openapitools.api.db;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;

import org.bson.Document;
import org.openapitools.api.logging.LogClient;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;

public abstract class DBClient {

    private static MongoClient DBClient;
    private static MongoDatabase DB;
    private static LogClient logClient;

    public static MongoDatabase getDatabase() {
        if (DBClient == null) {
            logClient = new LogClient(DBClient.class);
            String connectionString = System.getProperty("DBCONNECTIONSTRING");
            String DBName = System.getProperty("DBNAME");
            try {
                MongoClientSettings settings = MongoClientSettings.builder()
                        .applyConnectionString(new ConnectionString(connectionString)).build();
                DBClient = MongoClients.create(settings);
                DB = DBClient.getDatabase(DBName);
                DB.runCommand(new Document("ping", 1));
                logClient.info("successfully connect to the database!");
            } catch (Exception e) {
                logClient.error("cannot connect to db: " + e.getMessage().toString());
                System.exit(1);
            }
        }
        return DB;
    }

    public static void cleanup() {
        if (DBClient != null) {
            logClient.warn("destroying the database client!");
            DBClient.close();
        }
    }
}
