package com.datastax.demo.repository;

import com.datastax.demo.domain.Airport;
import com.microsoft.spring.data.gremlin.repository.GremlinRepository;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Repository;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@Repository
public interface AirportRepository extends GremlinRepository<Airport, String> {

    /**
     * Find airport by its code.
     * This throws {@link UnsupportedOperationException} since spring-data-gremlin 2.0.0
     * does not support limitation yet.
     *
     * @param code code to find
     * @return Airport found
     */
    Airport findFirstByCode(@NotNull String code);

    /**
     * Find airport by code and runways
     */
    List<Airport> findByCodeAndRunways(@NotNull String code, int runways);

    /**
     * Asynchronous version of find by code.
     */
    @Async
    CompletableFuture<List<Airport>> findByCode(@NotNull String code);
}
