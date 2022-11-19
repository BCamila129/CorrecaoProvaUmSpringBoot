package com.example.CorrecaoProvaUmSpringBoot.repository;

import com.example.CorrecaoProvaUmSpringBoot.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnderecoRepository extends JpaRepository<Cliente, Long> {
}
