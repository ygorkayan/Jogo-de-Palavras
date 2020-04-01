package com.projeto.servidor.repository;

import com.projeto.servidor.model.Placar;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * PlacarRepository
 */
public interface PlacarRepository extends JpaRepository<Placar, Integer>{

    
}