package br.com.viniciussouza.spring_boot_rest_api.mapper;


import com.github.dozermapper.core.DozerBeanMapperBuilder;
import com.github.dozermapper.core.Mapper;

import java.util.List;
import java.util.stream.Collectors;

public class ObjectMapper {

    private static final Mapper mapper = DozerBeanMapperBuilder.buildDefault();


    public static <O, D> D map(final O origin, final Class<D> destinationClass) {
        return mapper.map(origin, destinationClass);
    }

    public static <O, D> List<D> mapList(final List<O> origin, final Class<D> destinationClass) {
        return origin.stream()
                .map(item -> mapper.map(item, destinationClass))
                .collect(Collectors.toList());
    }
}
