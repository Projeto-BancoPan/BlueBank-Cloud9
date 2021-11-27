package com.bancopan.cloud9.bluebank.services;


import com.bancopan.cloud9.bluebank.models.ContaCorrenteModel;
import com.bancopan.cloud9.bluebank.models.TransacaoModel;
import com.bancopan.cloud9.bluebank.repositories.ContaCorrenteRepository;
import com.bancopan.cloud9.bluebank.repositories.TransacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@Service
public class TransacaoService {

    @Autowired
    private TransacaoRepository transacaoRepository;

    @Autowired
    private ContaCorrenteRepository repository;


    @Transactional
    public TransacaoModel pagar(Double valorPagamento, Long idContaOrigem) {

        ContaCorrenteModel contaCorrenteModel = repository.findById(idContaOrigem).get();

        if (contaCorrenteModel.getSaldoContaCorrente() < valorPagamento) {
            return null;
        }

        TransacaoModel transacaoModel = new TransacaoModel();
        transacaoModel.setContaDeOrigem(contaCorrenteModel);
        transacaoModel.setValorDaTransacao(valorPagamento);
        contaCorrenteModel.pagar(valorPagamento);
        return transacaoRepository.save(transacaoModel);


    }

    public TransacaoModel depositar(Double valorPagamento, Long idContaOrigem) {

        ContaCorrenteModel contaCorrenteModel = repository.findById(idContaOrigem).get();
        TransacaoModel transacaoModel = new TransacaoModel();
        transacaoModel.setContaDeDestino(contaCorrenteModel);
        transacaoModel.setValorDaTransacao(valorPagamento);

        contaCorrenteModel.depositar(valorPagamento);

        return transacaoRepository.save(transacaoModel);
    }


//        public TransacaoModel pagar(Double valorPagamento, Long idContaOrigem) {
//
//            ContaCorrenteModel contaCorrenteModel = repository.findById(idContaOrigem).get();
//            TransacaoModel transacaoModel = new TransacaoModel();
//            transacaoModel.setContaDeOrigem(contaCorrenteModel);
//            transacaoModel.setValorDaTransacao(valorPagamento);
//
//            contaCorrenteModel.pagar(valorPagamento);
//
//            return transacaoRepository.save(transacaoModel);
//        }

   /*     public TransacaoModel pagar(Double valorPagamento, Long idContaOrigem) {

            ContaCorrenteModel contaCorrenteModel = repository.findById(idContaOrigem).get();
            TransacaoModel transacaoModel = new TransacaoModel();
            contaCorrenteModel.pagar(valorPagamento);
            if(valorPagamento < contaCorrenteModel.getSaldoContaCorrente()){
                return null;
            } else {
                transacaoModel.setContaDeOrigem(contaCorrenteModel);
                transacaoModel.setValorDaTransacao(valorPagamento);
                return transacaoRepository.save(transacaoModel);
            }
        }*/

}
