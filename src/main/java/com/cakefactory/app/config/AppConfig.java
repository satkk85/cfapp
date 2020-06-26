package com.cakefactory.app.config;

import com.samskivert.mustache.Mustache;
import org.springframework.boot.autoconfigure.mustache.MustacheEnvironmentCollector;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

@Configuration
public class AppConfig {

    /**
     *  Add a default value to placeholder if missing
     */
    @Bean
    public Mustache.Compiler mustacheCompiler(Mustache.TemplateLoader templateLoader,
                                              Environment environment) {
        MustacheEnvironmentCollector collector
                = new MustacheEnvironmentCollector();
        collector.setEnvironment(environment);

        return Mustache.compiler()
                .defaultValue("((TODO: PlaceHolder Value required))")
                .withLoader(templateLoader)
                .withCollector(collector);
    }
}
