package com.javanauta.desafio4.business.dto.response;

import com.javanauta.desafio4.business.dto.request.CategoriaRequest;

import java.math.BigDecimal;

public record ProdutoResponse(Long id, String nome, String descricao,
                              BigDecimal preco, CategoriaResponse categoria) {
}
