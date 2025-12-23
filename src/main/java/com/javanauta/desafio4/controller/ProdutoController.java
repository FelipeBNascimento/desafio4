package com.javanauta.desafio4.controller;

import com.javanauta.desafio4.business.ProdutoService;
import com.javanauta.desafio4.business.dto.request.ProdutosRequest;
import com.javanauta.desafio4.business.dto.response.ProdutoResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/produtos", produces = {"application/json"})
@RequiredArgsConstructor
@Tag(name = "Gerenciamento produtos")
public class ProdutoController {

    private final ProdutoService service;

    @Operation(summary = "Cadastrar um produto", method = "POST")
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ProdutoResponse> criarProduto(@RequestBody ProdutosRequest request){

        return ResponseEntity.ok(service.criarProduto(request));
    }

    @Operation(summary = "Mostrar produtos", method = "GET")
    @GetMapping("/{id}")
    public ResponseEntity<ProdutoResponse> vizualizarProdutoPeloId(@PathVariable Long id){

        return ResponseEntity.ok(service.vizualizarPeloId(id));
    }

    @Operation(summary = "Atualizar Produto", method = "PUT")
    @PutMapping("/{id}")
    public ResponseEntity<ProdutoResponse> atualizarProdutoPeloId(@PathVariable Long id,
                                                                  @RequestBody ProdutosRequest request){
        return ResponseEntity.ok(service.atualizarPeloId(request, id));
    }

    @Operation(summary = "Excluir produto", method = "DELETE")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarProdutoPeloId(@PathVariable Long id){

        service.deletarPeloId(id);

        return ResponseEntity.ok().build();
    }
}
