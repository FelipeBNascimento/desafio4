package com.javanauta.desafio4.business;

import com.javanauta.desafio4.business.converter.Mapper;
import com.javanauta.desafio4.business.converter.MapperUpdate;
import com.javanauta.desafio4.business.dto.request.ProdutosRequest;
import com.javanauta.desafio4.business.dto.response.ProdutoResponse;
import com.javanauta.desafio4.infrasctruture.IdNaoEncontrado;
import com.javanauta.desafio4.infrasctruture.entity.ProdutosEntity;
import com.javanauta.desafio4.infrasctruture.repository.ProdutosRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProdutoService {

    private final ProdutosRepository repository;
    private final Mapper mapper;
    private final MapperUpdate mapperUpdate;

    public ProdutoResponse criarProduto(ProdutosRequest request) {

        ProdutosEntity produto = mapper.paraProdutoEntity(request);

        ProdutosEntity produtoSalvo = repository.save(produto);

        return mapper.paraProdutoResponse(produtoSalvo);

    }

    public ProdutoResponse vizualizarPeloId (Long id){

       ProdutosEntity produtoNoBanco = buscarProdutoNobanco(id);

        return mapper.paraProdutoResponse(produtoNoBanco);

    }

    public void deletarPeloId(Long id){

        repository.deleteById(id);
    }

    @Transactional
    public ProdutoResponse atualizarPeloId(ProdutosRequest request, Long id){

        ProdutosEntity produtoBanco = buscarProdutoNobanco(id);

        ProdutosEntity produtoAtualizado = mapperUpdate.atualizarProdutoEntity(request,produtoBanco);

        repository.save(produtoAtualizado);

        return mapper.paraProdutoResponse(produtoAtualizado);
    }

    // metodo criado somente para buscar produto no banco de dados
    private ProdutosEntity buscarProdutoNobanco (Long id){

        return repository.findById(id).orElseThrow(
                ()->  new IdNaoEncontrado("Id não encontrado")
        );
    }
}
