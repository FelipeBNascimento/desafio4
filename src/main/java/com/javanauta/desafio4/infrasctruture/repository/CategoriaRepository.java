package com.javanauta.desafio4.infrasctruture.repository;

import com.javanauta.desafio4.infrasctruture.entity.CategoriaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaRepository extends JpaRepository<CategoriaEntity, Long> {
}
