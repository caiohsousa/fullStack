package com.projeto.clientes.model.entity;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Data
public class Servico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 150)
    private String descricao;

    //relacionamento 1 cliente pode ter muitos serv. e o serv só pode ter 1 cliente (1 para muitos)
    @ManyToOne
    @JoinColumn(name= "id_cliente")
    private Cliente cliente;

    @Column
    private BigDecimal valor;


}
