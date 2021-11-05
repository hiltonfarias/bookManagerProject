package com.github.hiltonfarias.bookManager.converter;

import java.util.ArrayList;
import java.util.List;

public abstract class ConverterBase<E, D> {

    public abstract D converterEntityToDTO(E entity);

    public abstract E converterDTOToEntity(D dto);

    public List<D> converterEntitiesToDTOs(List<E> entities) {

        List<D> dtos = new ArrayList<>();
        entities.stream().forEach(entity -> dtos.add(converterEntityToDTO(entity)));
        return dtos;
    }

    public List<E> converterDTOsToEntities(List<D> dtos) {

        List<E> listEntities = new ArrayList<>();
        dtos.stream().forEach(dto -> listEntities.add(converterDTOToEntity(dto)));
        return listEntities;
    }
}
