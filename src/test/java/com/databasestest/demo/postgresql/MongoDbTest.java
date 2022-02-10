package com.databasestest.demo.postgresql;

import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

@SpringBootTest
@Transactional
//@EnableMongoRepositories
//@TestPropertySource("classpath:mongodb-application.properties")
public class MongoDbTest {

    private final MongoClient mongoClient = new MongoClient(new
            MongoClientURI("mongodb://127.0.0.1:27017"));
    private final MongoDatabase database = mongoClient.getDatabase("human_resource");
    private final MongoCollection<Document> collection = database.getCollection("users");

    public MongoDbTest() {
    }

    @BeforeEach
    void init() {
        Document user = new Document()
                .append("contactInfo", "Basketball, Beer")
                .append("login", "Ihor")
                .append("password", "THIS_IS_A_PASSWORD")
                .append("city", new BasicDBObject()
                        .append("name", "Kyiv"))
                .append("education", new ArrayList<>()
                        .add(new BasicDBObject()
                                .append("name", "NaUKMA")
                                .append("degree", "bachelor")));
        this.collection.insertOne(user);
    }

    @Test
    void testGetUsers() {
        //TODO tbd
    }

}
