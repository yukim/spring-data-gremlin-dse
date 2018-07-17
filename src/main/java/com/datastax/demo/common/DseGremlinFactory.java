package com.datastax.demo.common;

import com.microsoft.spring.data.gremlin.common.GremlinFactory;
import org.apache.tinkerpop.gremlin.driver.Client;

/**
 * DSE requires to use aliased client.
 *
 * This class extends spring-data-gremlin's GremlinFactory to
 * provide aliased client.
 *
 * Also, spring-data-gremlin connects with SSL(hardoded as of 2.0.0).
 * If you want to customise {@link org.apache.tinkerpop.gremlin.driver.Cluster} also,
 * overrode {@link #createGremlinCluster()} as well.
 */
public class DseGremlinFactory extends GremlinFactory {

    private final String graphName;

    public DseGremlinFactory(String endpoint, String port, String username, String password, String graphName) {
        super(endpoint, port, username, password);
        this.graphName = graphName;
    }

    /**
     * Here, you need to create tinkerpop client with alias.
     *
     * @return aliased client
     */
    @Override
    public Client getGremlinClient() {
        Client client =  super.getGremlinClient();
        return client.alias(graphName + ".g");
    }
}
