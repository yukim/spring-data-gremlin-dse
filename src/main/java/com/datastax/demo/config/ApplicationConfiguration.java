package com.datastax.demo.config;

import com.datastax.demo.common.DseGremlinFactory;
import com.microsoft.spring.data.gremlin.common.GremlinConfiguration;
import com.microsoft.spring.data.gremlin.common.GremlinFactory;
import com.microsoft.spring.data.gremlin.config.AbstractGremlinConfiguration;
import com.microsoft.spring.data.gremlin.repository.config.EnableGremlinRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@EnableGremlinRepositories(basePackages = "com.datastax.demo.repository")
@EnableConfigurationProperties(GremlinConfiguration.class)
@PropertySource("classpath:application.yml")
public class ApplicationConfiguration extends AbstractGremlinConfiguration {

    @Autowired
    private GremlinConfiguration config;

    /** graph name to connect */
    @Value("${app.graph}")
    private String name;

    @Override
    public GremlinFactory gremlinFactory() {
        final GremlinConfiguration config = getGremlinConfiguration();

        return new DseGremlinFactory(config.getEndpoint(), config.getPort(), config.getUsername(), config.getPassword(), name);
    }

    @Override
    public GremlinConfiguration getGremlinConfiguration() {
        return this.config;
    }

}
