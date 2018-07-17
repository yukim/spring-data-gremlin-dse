package com.datastax.demo;

import com.datastax.demo.repository.AirportRepository;
import com.datastax.demo.repository.RouteRepository;
import com.microsoft.spring.data.gremlin.common.GremlinFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application implements CommandLineRunner {

    @Autowired
    private AirportRepository airportRepository;

    @Autowired
    private RouteRepository routeRepository;

    @Autowired
    private GremlinFactory gremlinFactory;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        try {
            /* Vertex queries */

            // Look up by vertex ID g.V(...)
            // In DSE, vertex ID consists of label and primary key properties
            // So you need to specify all of them as below.
            airportRepository.findById("{~label=airport,code=\"AUS\"}").ifPresent(System.out::println);

            // Custom query example.
            // This will generate gremlin query
            // g.V().has('label', 'airport').where(has('code', 'AUS').and().where(has('runways', 3))
            // (which does not work because of has('label') part. Should be hasLabel instead.
            airportRepository.findByCodeAndRunways("AUS", 3).forEach(System.out::println);

            // The following custom query fails because spring-data-gremlin does not support limitation yet
            try {
                airportRepository.findFirstByCode("NRT");
            } catch (UnsupportedOperationException e) {
                e.printStackTrace();
            }

            // Asynchronous call
            airportRepository.findByCode("HND").thenAccept(System.out::println).get();

        } finally {
            // Make sure to close gremlin server connection, otherwise app won't terminate.
            gremlinFactory.getGremlinCluster().close();
        }
    }
}
