package com.mongo.demo.repository;

import com.mongodb.client.model.Filters;
import com.mongodb.client.model.ReplaceOptions;
import com.mongodb.reactivestreams.client.MongoDatabase;
import com.mongo.demo.model.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class PlayerRepository {

    private final MongoDatabase mongoDatabase;

    @Autowired
    public PlayerRepository(MongoDatabase mongoDatabase) {
        this.mongoDatabase = mongoDatabase;
    }

    public void savePlayers(Player player) {
        mongoDatabase.getCollection("players", Player.class).replaceOne(
            Filters.eq("email", player.getEmail()),
            player,
            new ReplaceOptions().upsert(true)
        ).subscribe(
            value -> System.out.println("Updating data"),
            throwable -> System.out.println("Error while updating data"),
            () -> System.out.println("Data has been updated")
        );
    }
}
