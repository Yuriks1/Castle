package com.labb2;

import io.micronaut.core.annotation.NonNull;
import org.reactivestreams.Publisher;
import reactor.core.publisher.Mono;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

public interface CastleRepository {

    @NonNull
    Publisher<Castle> list();

    Mono<Boolean> save(@NonNull @NotNull @Valid Castle castle);
}