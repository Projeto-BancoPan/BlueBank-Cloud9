package com.bancopan.cloud9.bluebank.controllers;

import com.bancopan.cloud9.bluebank.models.TransacaoModel;
import com.bancopan.cloud9.bluebank.repositories.ContaCorrenteRepository;
import com.bancopan.cloud9.bluebank.repositories.TransacaoRepository;
import com.bancopan.cloud9.bluebank.services.ContaCorrenteService;
import com.bancopan.cloud9.bluebank.services.TransacaoService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api")
public class TransacaoController {

    @Autowired
    private TransacaoRepository transacaoRepository;

    @Autowired
    private TransacaoService transacaoService;

    @Autowired
    private ContaCorrenteRepository contaCorrenteRepository;

    @Autowired
    private ContaCorrenteService contaCorrenteService;

    @GetMapping(value = "/transacoes")
    @ApiOperation(value = "Retorna uma lista com todas as transacoes")
    public ResponseEntity<List<TransacaoModel>> getAllClienteModel() {
        return ResponseEntity.ok(transacaoRepository.findAll());
    }

    @PostMapping(value = "/transacao/{conta_de_origem}/{valorDaTransacao}")
    @ApiOperation(value = "Efetua um pagamento")
    public ResponseEntity<TransacaoModel> transacaoPagar(@RequestBody @PathVariable("conta_de_origem") Long contaDeOrigem,
                                                         @PathVariable("valorDaTransacao") Double valorDaTransacao) {
        return ResponseEntity.status(HttpStatus.CREATED).body(transacaoService.pagar(contaDeOrigem, valorDaTransacao));
    }

    @PostMapping(value = "/transacaoDepositar/{conta}/{valorDaTransacao}")
    @ApiOperation(value = "Efetua um depósito")
    public ResponseEntity<TransacaoModel> transacaoDepositar(@RequestBody @PathVariable("conta") Long contaDeOrigem,
                                                         @PathVariable("valorDaTransacao") Double valorDaTransacao) {
        return ResponseEntity.status(HttpStatus.CREATED).body(transacaoService.depositar(valorDaTransacao, contaDeOrigem));
    }

    @PostMapping(value = "/transacao/{conta}/{valorDaTransacao}/{contaT}")
    @ApiOperation(value = "Efetua uma transferência para outra conta")
    public ResponseEntity<TransacaoModel> transacaoTranfereir(@RequestBody @PathVariable("conta") Long contaDeOrigem,
                                                              @PathVariable("valorDaTransacao") Double valorDaTransacao, @RequestBody @PathVariable("contaT") Long contaDeDestino) {



        if(contaDeDestino.equals(contaDeOrigem) || !contaCorrenteRepository.existsById(contaDeOrigem)
                || !contaCorrenteRepository.existsById(contaDeDestino)
                || contaCorrenteService.buscar(contaDeOrigem).getSaldoDaConta() < valorDaTransacao){
            return ResponseEntity.badRequest().build();
        }

        return ResponseEntity.status(HttpStatus.OK).body(transacaoService.transferir(contaDeOrigem,valorDaTransacao, contaDeDestino));
    }

}
