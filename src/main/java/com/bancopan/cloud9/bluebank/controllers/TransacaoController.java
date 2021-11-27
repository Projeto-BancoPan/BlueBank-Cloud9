package com.bancopan.cloud9.bluebank.controllers;

import com.bancopan.cloud9.bluebank.models.ClienteModel;
import com.bancopan.cloud9.bluebank.models.ContaCorrenteModel;
import com.bancopan.cloud9.bluebank.models.TransacaoModel;
import com.bancopan.cloud9.bluebank.repositories.ContaCorrenteRepository;
import com.bancopan.cloud9.bluebank.repositories.TransacaoRepository;
import com.bancopan.cloud9.bluebank.services.TransacaoService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping(value = "/api")
public class TransacaoController {

    @Autowired
    private TransacaoRepository transacaoRepository;

    @Autowired
    private TransacaoService transacaoService;

    @GetMapping(value = "/transacoes")
    @ApiOperation(value = "Retorna uma lista com todas as transacoes")
    public ResponseEntity<List<TransacaoModel>> getAllClienteModel() {
        return ResponseEntity.ok(transacaoRepository.findAll());
    }

    @PostMapping(value = "/transacao/{conta}/{valorDaTransacao}")
    @ApiOperation(value = "Salvar nova transacao")
    public ResponseEntity<TransacaoModel> transacaoPagar(@RequestBody @PathVariable("conta") Long contaDeOrigem,
                                                         @PathVariable("valorDaTransacao") Double valorDaTransacao) {
        return ResponseEntity.status(HttpStatus.CREATED).body(transacaoService.pagar(valorDaTransacao, contaDeOrigem));
    }

    @PostMapping(value = "/transacaoDepositar/{conta}/{valorDaTransacao}")
    @ApiOperation(value = "Salvar nova transacao")
    public ResponseEntity<TransacaoModel> transacaoDepositar(@RequestBody @PathVariable("conta") Long contaDeOrigem,
                                                             @PathVariable("valorDaTransacao") Double valorDaTransacao) {
        return ResponseEntity.status(HttpStatus.CREATED).body(transacaoService.depositar(valorDaTransacao, contaDeOrigem));
    }


}
