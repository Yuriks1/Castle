package com.labb2;

import com.mongodb.reactivestreams.client.MongoClient;
import com.mongodb.reactivestreams.client.MongoCollection;
import io.micronaut.core.annotation.NonNull;
import jakarta.inject.Singleton;
import org.reactivestreams.Publisher;
import reactor.core.publisher.Mono;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Singleton
public class MongoDbCastleRepository implements CastleRepository {

    private final MongoDbConfiguration mongoConfig;
    private final MongoClient mongoClient;

    public MongoDbCastleRepository(MongoDbConfiguration mongoConfig,
                                    MongoClient mongoClient) {
        this.mongoConfig = mongoConfig;
        this.mongoClient = mongoClient;
    }

    @Override
    @NonNull
    public Publisher<Castle> list() {
        return getCollection().find();
    }

    @Override
    public Mono<Boolean> save(@NonNull @NotNull @Valid Castle castle) {
        return Mono.from(getCollection().insertOne(castle))
                .map(insertOneResult -> true)
                .onErrorReturn(false);
    }

    @NonNull
    private MongoCollection<Castle> getCollection() {
        return mongoClient.getDatabase(mongoConfig.getName())
                .getCollection(mongoConfig.getCollection(), Castle.class);
    }
}