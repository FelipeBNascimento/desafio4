package com.javanauta.desafio4.business.converter;

import com.javanauta.desafio4.business.dto.request.CategoriaRequest;
import com.javanauta.desafio4.business.dto.request.ProdutosRequest;
import com.javanauta.desafio4.business.dto.response.CategoriaResponse;
import com.javanauta.desafio4.business.dto.response.ProdutoResponse;
import com.javanauta.desafio4.infrasctruture.entity.CategoriaEntity;
import com.javanauta.desafio4.infrasctruture.entity.ProdutosEntity;

@org.mapstruct.Mapper(componentModel = "spring")
public interface Mapper {

    ProdutosEntity paraProdutoEntity(ProdutosRequest request);

    ProdutoResponse paraProdutoResponse(ProdutosEntity entity);

    CategoriaEntity paraCategoriaEntity(CategoriaRequest request);

    CategoriaResponse paraCategoriaResponse(CategoriaEntity entity);



}
