package com.bancopan.cloud9.bluebank.controllers;


import com.bancopan.cloud9.bluebank.models.TransacaoModel;
import com.bancopan.cloud9.bluebank.repositories.TransacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Scanner;

@RestController
@RequestMapping(path = "/api/transacao")
class TransacaoController {

    @Autowired
    private TransacaoRepository transacaoRepository;

    @PostMapping("/salvar")
    public ResponseEntity<TransacaoModel> salvarTransacao(@RequestBody TransacaoModel transacao){
        return ResponseEntity.status(HttpStatus.CREATED).body(transacaoRepository.save(transacao));
    }

    @GetMapping("/listar")
    public ResponseEntity<List<TransacaoModel>> getAllTransacao() {
        return ResponseEntity.status(HttpStatus.OK).body(transacaoRepository.findAll());
    }
}
