package com.labb2;

import io.micronaut.core.annotation.NonNull;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Post;
import org.reactivestreams.Publisher;
import reactor.core.publisher.Mono;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import static io.micronaut.http.HttpStatus.CONFLICT;
import static io.micronaut.http.HttpStatus.CREATED;

@Controller("/castles")
public class CastleController {

    private final CastleRepository castleService;


    public CastleController(CastleRepository castleService) {
        this.castleService = castleService;
    }

    @Get
    Publisher<Castle> castleList() {
        return castleService.list();
    }

    @Post
    Mono<HttpStatus> save(@NonNull @NotNull @Valid Castle castle) {
        return castleService.save(castle).map(added -> Boolean.TRUE.equals(added) ? CREATED : CONFLICT);
    }
}