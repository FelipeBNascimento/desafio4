package com.javanauta.desafio4.infrasctruture.repository;

import com.javanauta.desafio4.infrasctruture.entity.ProdutosEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutosRepository extends JpaRepository<ProdutosEntity, Long> {
}
