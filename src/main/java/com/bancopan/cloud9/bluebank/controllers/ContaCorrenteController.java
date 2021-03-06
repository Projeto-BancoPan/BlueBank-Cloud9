package com.bancopan.cloud9.bluebank.controllers;

import com.bancopan.cloud9.bluebank.models.ContaCorrenteModel;
import com.bancopan.cloud9.bluebank.repositories.ContaCorrenteRepository;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping(value = "/api/conta_corrente")
public class ContaCorrenteController {

    @Autowired
    private ContaCorrenteRepository repository;

    @GetMapping("/listar")
    @ApiOperation(value = "Listar todas as contas")
    public ResponseEntity<List<ContaCorrenteModel>> getAllContas() {
        return ResponseEntity.status(HttpStatus.OK).body(repository.findAll());
    }

    @GetMapping("/{conta}")
    @ApiOperation(value = "Localiza o cliente pelo número da conta")
    public ResponseEntity consultarConta(@PathVariable("conta") Long codigo) {
        return repository.findById(codigo)
                .map(record -> ResponseEntity.ok().body(record))
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping(path = "/atualizar")
    @ApiOperation(value = "Atualiza os dados de uma conta")
    public ResponseEntity<ContaCorrenteModel> atualizarCliente(@Valid @RequestBody ContaCorrenteModel conta) {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(repository.save(conta));

    }

}
