package com.bancopan.cloud9.bluebank.controllers;

import com.bancopan.cloud9.bluebank.dtos.ConsultaListaDeTransacoesDTO;
import com.bancopan.cloud9.bluebank.models.ContaCorrenteModel;
import com.bancopan.cloud9.bluebank.models.TransacaoModel;
import com.bancopan.cloud9.bluebank.repositories.ContaCorrenteRepository;
import com.bancopan.cloud9.bluebank.services.ContaCorrenteService;
import com.bancopan.cloud9.bluebank.services.TransacaoService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/api/transacao")
public class TransacaoController {

    @Autowired
    private TransacaoService transacaoService;

    @Autowired
    private ContaCorrenteRepository contaCorrenteRepository;

    @Autowired
    private ContaCorrenteService contaCorrenteService;

    @GetMapping(value = "/listar")
    @ApiOperation(value = "Retorna uma lista com todas as transacoes")
    public ResponseEntity<List<ConsultaListaDeTransacoesDTO>> listarTodasAsTransacoes() {
        List<ContaCorrenteModel> contaCorrenteModelList = contaCorrenteRepository.findAll();
        List<ConsultaListaDeTransacoesDTO> consultaListaDeTransacoesDTO = ConsultaListaDeTransacoesDTO.converteParaDTO(contaCorrenteModelList);
        return ResponseEntity.ok(consultaListaDeTransacoesDTO);
    }

    @GetMapping(value = "/{conta_de_origem}/")
    @ApiOperation(value = "Retorna uma lista com todas as transacoes do cliente")
    public ResponseEntity transacaoClienteConsultar(@PathVariable("conta_de_origem") Long conta_de_origem) {
        if (!contaCorrenteRepository.existsById(conta_de_origem)) {
            return ResponseEntity.notFound().build();
        }
        ContaCorrenteModel contaCorrenteModel = contaCorrenteRepository.getById(conta_de_origem);
        ConsultaListaDeTransacoesDTO consultaListaDeTransacoesDTO = new ConsultaListaDeTransacoesDTO(contaCorrenteModel);
        return ResponseEntity.ok(consultaListaDeTransacoesDTO);
    }

    @PostMapping(value = "/pagar/{conta_de_origem}/{valor_transacao}")
    @ApiOperation(value = "Efetuar um pagamento")
    public ResponseEntity<TransacaoModel> transacaoPagar(@Valid @RequestBody @PathVariable("conta_de_origem") Long contaDeOrigem,
                                                         @PathVariable("valor_transacao") Double valorDaTransacao) {


        if (!contaCorrenteRepository.existsById(contaDeOrigem)
                || contaCorrenteService.buscar(contaDeOrigem).getSaldoDaConta() < valorDaTransacao
                || contaCorrenteService.buscar(contaDeOrigem).getDataDeEncerramento() != null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.status(HttpStatus.CREATED).body(transacaoService.pagar(contaDeOrigem, valorDaTransacao));
    }


    @PostMapping(value = "/depositar/{conta_de_destino}/{valor_transacao}")
    @ApiOperation(value = "Efetuar um depósito")
    public ResponseEntity<TransacaoModel> transacaoDepositar(@Valid @RequestBody @PathVariable("conta_de_destino") Long contaDeOrigem,
                                                             @PathVariable("valor_transacao") Double valorDaTransacao) {

        if (!contaCorrenteRepository.existsById(contaDeOrigem) || contaCorrenteService.buscar(contaDeOrigem).getDataDeEncerramento() != null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.status(HttpStatus.CREATED).body(transacaoService.depositar(valorDaTransacao, contaDeOrigem));
    }


    @PostMapping(value = "/transferir/{conta_de_origem}/{valor_transacao}/{conta_de_destino}")
    @ApiOperation(value = "Efetua uma transferência para outra conta")
    public ResponseEntity<TransacaoModel> transacaoTranferir(@Valid @RequestBody @PathVariable("conta_de_origem") Long contaDeOrigem,
                                                             @PathVariable("valor_transacao") Double valorDaTransacao,
                                                             @PathVariable("conta_de_destino") Long contaDeDestino) {

        if (contaDeDestino.equals(contaDeOrigem) || !contaCorrenteRepository.existsById(contaDeOrigem) || !contaCorrenteRepository.existsById(contaDeDestino)
                || contaCorrenteService.buscar(contaDeOrigem).getSaldoDaConta() < valorDaTransacao
                || contaCorrenteService.buscar(contaDeOrigem).getDataDeEncerramento() != null || contaCorrenteService.buscar(contaDeDestino).getDataDeEncerramento() != null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(transacaoService.transferir(contaDeOrigem, valorDaTransacao, contaDeDestino));
    }


}
