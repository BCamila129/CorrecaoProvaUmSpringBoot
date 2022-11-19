package com.example.CorrecaoProvaUmSpringBoot.repository;

import com.example.CorrecaoProvaUmSpringBoot.entity.Cliente;
import com.example.CorrecaoProvaUmSpringBoot.entity.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
