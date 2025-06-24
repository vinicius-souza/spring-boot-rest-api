package br.com.viniciussouza.spring_boot_rest_api.serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

public class GenderSerializer extends JsonSerializer<String> {

    @Override
    public void serialize(String value, JsonGenerator gen, SerializerProvider serializers) {
        try {
            if (value != null) {
               gen.writeString(value.equals("Male") ? "M" : "F");
            } else {
                gen.writeNull();
            }
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }
}
