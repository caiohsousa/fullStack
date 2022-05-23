package com.projeto.clientes.model.repository;

import com.projeto.clientes.model.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

//classe do qual se trata e o tipo da chave primaria
public interface ClienteRepository extends JpaRepository <Cliente,Integer>{
}
