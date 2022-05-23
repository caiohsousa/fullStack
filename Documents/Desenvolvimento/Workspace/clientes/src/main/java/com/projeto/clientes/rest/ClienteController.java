package com.projeto.clientes.rest;
//responsavel por receber as requisições e enviar respostas https rest

import com.projeto.clientes.model.entity.Cliente;
import com.projeto.clientes.model.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {

    private final ClienteRepository repository;

    @Autowired
    public ClienteController(ClienteRepository repository) {
        this.repository = repository;
    }

    //op2 - fica opcional e no construtor é obrigatório a injeção
    // @Autowired public void setRepository (ClienteRepository repository){
    // this.repository = repository;}

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Cliente salvar (@RequestBody @Valid Cliente cliente){
        return repository.save(cliente);
    }

    //criar variavel pela URL, ou seja, buscar pelo ID
    @GetMapping("{id}")
    public Cliente acharPorId(@PathVariable Integer id){
        return repository
                .findById(id)
                //Lançar exception caso n encontre por ID
                .orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "cliente não encontrado"));
    }
    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletar(@PathVariable Integer id){
                repository
                .findById(id)
                        .map( cliente ->{
                            repository.delete(cliente);
                            return Void.TYPE;
                        })
                .orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "cliente não encontrado"));
    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void atualizar(@PathVariable Integer id, @RequestBody @Valid Cliente clienteAtualizado){
        repository
                .findById(id)
                .map( cliente ->{
                    clienteAtualizado.setNome(clienteAtualizado.getNome());
                    clienteAtualizado.setCpf(clienteAtualizado.getCpf());
                    return repository.save(cliente);
                })
                .orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "cliente não encontrado"));
    }

}
