/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package config;

import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import javax.ws.rs.ext.ContextResolver;
import javax.ws.rs.ext.Provider;

/**
 *
 * @author hernan
 */
@Provider
public class JacksonObjectMapperConfigProvider implements ContextResolver<ObjectMapper> {

    private static ObjectMapper objectMapper
            = new ObjectMapper()
                    .disable(MapperFeature.AUTO_DETECT_CREATORS)
                    .disable(MapperFeature.CAN_OVERRIDE_ACCESS_MODIFIERS)
                    .findAndRegisterModules()
                    .configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);

    public JacksonObjectMapperConfigProvider() {
    }

    @Override
    public ObjectMapper getContext(Class<?> type) {
        return objectMapper;
    }

}
