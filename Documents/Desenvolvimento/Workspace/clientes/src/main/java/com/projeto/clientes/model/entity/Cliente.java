package com.projeto.clientes.model.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Cliente {
    //mapear essa classe para o bd
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Auto incremet
    private Integer id;

    @Column(nullable = false,length = 150) //notnull e tamanho do campo
    @NotEmpty(message="{campo.nome.obrigatorio}")
    private String nome;

    @Column(nullable = false,length = 11)
    @NotNull(message = "{campo.cpf.obrigatorio}")
    @CPF(message ="{campo.cpf.invalido}")
    private String cpf;

    @Column(name = "data_cadastro")
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataCadastro;

    @PrePersist
    public void preSave() {
        this.dataCadastro = LocalDate.now();
    }

    //@data cria os getters e setter + to string e construtores

    }



