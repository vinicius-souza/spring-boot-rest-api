package br.com.viniciussouza.spring_boot_rest_api.serializer.converter;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.AbstractJackson2HttpMessageConverter;

public final class YamlJackson2HttpMessageConverter extends AbstractJackson2HttpMessageConverter {
    YamlJackson2HttpMessageConverter() {
        super(new YAMLMapper()
                .setSerializationInclusion(JsonInclude.Include.NON_NULL), MediaType.parseMediaType("application/yaml"));
    }
}
