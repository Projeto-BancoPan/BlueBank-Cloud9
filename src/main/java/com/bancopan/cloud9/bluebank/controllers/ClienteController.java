package com.bancopan.cloud9.bluebank.controllers;

import com.bancopan.cloud9.bluebank.models.ClienteModel;
import com.bancopan.cloud9.bluebank.repositories.ClienteRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api")
@Api(value = "API REST BLUEBANK")
@CrossOrigin(origins = "*")
public class ClienteController {

    @Autowired
    private ClienteRepository repository;

    @GetMapping(value = "/clientes")
    @ApiOperation(value = "Retorna uma lista de todos os clientes")
    public ResponseEntity<List<ClienteModel>> getAllClienteModel() {
        return ResponseEntity.ok(repository.findAll());
    }

    @GetMapping(value = "/cliente/{id}")
    @ApiOperation(value = "Retorna um cliente pelo id")
    public ResponseEntity<ClienteModel> consultarCliente(@PathVariable("codigo") Long codigo) {
        return repository.findById(codigo)
                .map(record -> ResponseEntity.ok().body(record))
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping(value = "/tipo_cliente/{tipoCliente}")
    @ApiOperation(value = "Salva um novo cliente")
    public ResponseEntity<List<ClienteModel>> filtroId(@PathVariable Integer tipoCliente){
        return ResponseEntity.ok(repository.procuraTipoCliente(tipoCliente));
    }
    
    @PostMapping(value = "/cliente/salvar")
    public ResponseEntity<ClienteModel> salvarCliente(@RequestBody ClienteModel cliente) {
        return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(cliente));
    }

    @DeleteMapping(value = "/cliente/{id}")
    @ApiOperation(value = "Deleta um cliente")
    public ResponseEntity<HttpStatus> deleteCliente(@PathVariable Long codigo) {
        try {
           Optional<ClienteModel> cliente = repository.findById(codigo);
           if (cliente.isPresent()) {
               repository.delete(cliente.get());
           }
           return new ResponseEntity<HttpStatus>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
           return new ResponseEntity<HttpStatus>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping(value = "/cliente/atualizar")
    @ApiOperation(value = "Atualiza os dados de um cliente")
    public ResponseEntity<ClienteModel> atualizarCliente(@RequestBody ClienteModel cliente) {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(repository.save(cliente));
    }
}
