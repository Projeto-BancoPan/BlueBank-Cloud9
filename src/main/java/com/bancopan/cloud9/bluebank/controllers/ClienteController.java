package com.bancopan.cloud9.bluebank.controllers;

import com.bancopan.cloud9.bluebank.models.ClienteModel;
import com.bancopan.cloud9.bluebank.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api")
public class ClienteController {

    @Autowired
    private ClienteRepository repository;

    @GetMapping("/clientes")
    public ResponseEntity<List<ClienteModel>> getAllClienteModel() {
        return ResponseEntity.status(HttpStatus.OK).body(repository.findAll());
    }

    @GetMapping(path = "/cliente/{codigo}")
    public ResponseEntity consultar(@PathVariable("codigo") Long codigo) {
        return repository.findById(codigo)
                .map(record -> ResponseEntity.ok().body(record))
                .orElse(ResponseEntity.notFound().build());
    }
    @PostMapping(path = "/cliente/salvar")
    public ResponseEntity<ClienteModel> salvar(@RequestBody ClienteModel cliente) {
        return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(cliente));
    }

   @DeleteMapping(path = "/cliente/{codigo}")
   public void deleteClienteModel(@PathVariable Long codigo) {
        repository.deleteById(codigo);
  }

    @PutMapping(path = "/cliente/atualizar")
    public ClienteModel atualizar(@RequestBody ClienteModel cliente) {
        return repository.save(cliente);
    }
}
