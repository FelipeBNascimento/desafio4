package com.javanauta.desafio4.controller;

import com.javanauta.desafio4.business.ProdutoService;
import com.javanauta.desafio4.business.dto.request.ProdutosRequest;
import com.javanauta.desafio4.business.dto.response.ProdutoResponse;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/produtos")
@RequiredArgsConstructor
public class ProdutoController {

    private final ProdutoService service;

    @PostMapping
    public ResponseEntity<ProdutoResponse> criarProduto(@RequestBody ProdutosRequest request){

        return ResponseEntity.ok(service.criarProduto(request));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProdutoResponse> vizualizarProdutoPeloId(@PathVariable Long id){

        return ResponseEntity.ok(service.vizualizarPeloId(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProdutoResponse> atualizarProdutoPeloId(@PathVariable Long id,
                                                                  @RequestBody ProdutosRequest request){
        return ResponseEntity.ok(service.atualizarPeloId(request, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarProdutoPeloId(@PathVariable Long id){

        service.deletarPeloId(id);

        return ResponseEntity.ok().build();
    }
}
