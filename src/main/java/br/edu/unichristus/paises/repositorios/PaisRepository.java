package br.edu.unichristus.paises.repositorios;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.edu.unichristus.paises.entidades.Pais;

public interface PaisRepository extends MongoRepository<Pais, String> {
    
}
