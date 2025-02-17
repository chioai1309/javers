package org.javers.spring.boot.mongo;

import org.javers.spring.auditable.CommitPropertiesProvider;
import org.javers.spring.auditable.CommitPropertiesProviderContext;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * @author pawelszymczyk
 */
@Configuration
@EnableAutoConfiguration
@ComponentScan("org.javers.spring.boot.mongo")
public class TestApplication {

    @Bean
    public CommitPropertiesProvider commitPropertiesProvider() {
        final Map<String, String> rv = new HashMap<>();
        rv.put("key", "ok");
        return new CommitPropertiesProvider() {
            @Override
            public Map<String, String> provide(CommitPropertiesProviderContext context, Object domainObject) {
                return Collections.unmodifiableMap(rv);
            }

            @Override
            public Map<String, String> provideForDeleteById(Class<?> domainObjectClass, Object domainObjectId) {
                return Collections.unmodifiableMap(rv);
            }
        };
    }
}
