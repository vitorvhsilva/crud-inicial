package com.example.crud.domain.repository;

import com.example.crud.domain.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


// faz consulta no banco de dados da tabela Product
@Repository
public interface ProductRepository extends JpaRepository<Product, String> {

}
