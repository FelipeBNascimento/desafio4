package com.javanauta.desafio4.business.converter;

import com.javanauta.desafio4.business.dto.request.ProdutosRequest;
import com.javanauta.desafio4.infrasctruture.entity.ProdutosEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface MapperUpdate {

    ProdutosEntity atualizarProdutoEntity(ProdutosRequest request, @MappingTarget ProdutosEntity entity);

}
