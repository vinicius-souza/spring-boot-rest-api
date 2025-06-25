package br.com.viniciussouza.spring_boot_rest_api.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.http.MediaType.APPLICATION_XML;
import static org.springframework.http.MediaType.APPLICATION_YAML;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
        /** CONTENT NEGOTIATION WITH QUERY PARAMETER

         configurer.favorParameter(true)
         .parameterName("mediaType")
         .ignoreAcceptHeader(true)
         .useRegisteredExtensionsOnly(false)
         .defaultContentType(APPLICATION_JSON)
         .mediaType("json", APPLICATION_JSON)
         .mediaType("xml", APPLICATION_XML);
         */

        // CONTENT NEGOTIATION WITH HEADER ACCEPT

        configurer.favorParameter(false)
                .ignoreAcceptHeader(false)
                .useRegisteredExtensionsOnly(false)
                .defaultContentType(APPLICATION_JSON)
                .mediaType("json", APPLICATION_JSON)
                .mediaType("xml", APPLICATION_XML)
                .mediaType("yaml", APPLICATION_YAML); // Note: YAML is not a standard media type, but can be used for custom implementations
    }
}
