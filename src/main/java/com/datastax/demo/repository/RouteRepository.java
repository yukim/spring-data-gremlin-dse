package com.datastax.demo.repository;

import com.datastax.demo.domain.Route;
import com.microsoft.spring.data.gremlin.repository.GremlinRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RouteRepository extends GremlinRepository<Route, String> {
}
