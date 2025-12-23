package com.javanauta.desafio4.business.dto.request;

import java.math.BigDecimal;

public record ProdutosRequest(String nome, String descricao,
                              BigDecimal preco, CategoriaRequest categoria) {
}
