package com.projeto.clientes.model.repository;

import com.projeto.clientes.model.entity.Servico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServicoRepository extends JpaRepository <Servico, Integer> {
}
