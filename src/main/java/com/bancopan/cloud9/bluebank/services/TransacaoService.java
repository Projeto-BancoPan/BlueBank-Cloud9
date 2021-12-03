package com.bancopan.cloud9.bluebank.services;


import com.bancopan.cloud9.bluebank.enums.TipoDeTransacao;
import com.bancopan.cloud9.bluebank.exception.ContaException;
import com.bancopan.cloud9.bluebank.models.ContaCorrenteModel;
import com.bancopan.cloud9.bluebank.models.TransacaoModel;
import com.bancopan.cloud9.bluebank.repositories.ContaCorrenteRepository;
import com.bancopan.cloud9.bluebank.repositories.TransacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TransacaoService {

    @Autowired
    private TransacaoRepository transacaoRepository;

    @Autowired
    private ContaCorrenteRepository repository;

    @Autowired
    private ContaCorrenteService contaCorrenteService;


    @Transactional
    public TransacaoModel pagar(Long idContaOrigem, Double valorPagamento) {

        ContaCorrenteModel contaCorrenteModel = repository.findById(idContaOrigem).get();

        if (contaCorrenteModel.getSaldoDaConta() < valorPagamento) {
            throw new ContaException("Saldo Insuficiente");
        }

        TransacaoModel transacaoModel = new TransacaoModel();
        transacaoModel.setContaDeOrigem(contaCorrenteModel);
        transacaoModel.setValorDaTransacao(valorPagamento);
        transacaoModel.setTipoDeTransacao(TipoDeTransacao.PAGAMENTO);
        contaCorrenteModel.sacar(valorPagamento);
        return transacaoRepository.save(transacaoModel);

    }

    public TransacaoModel depositar(Double valorPagamento, Long idContaOrigem) {

        ContaCorrenteModel contaCorrenteModel = repository.findById(idContaOrigem).get();
        TransacaoModel transacaoModel = new TransacaoModel();
        transacaoModel.setTipoDeTransacao(TipoDeTransacao.DEPOSITO);
        transacaoModel.setContaDeDestino(contaCorrenteModel);
        transacaoModel.setValorDaTransacao(valorPagamento);

        contaCorrenteModel.depositar(valorPagamento);

        return transacaoRepository.save(transacaoModel);
    }

    @Transactional
    public TransacaoModel transferir(Long idContaOrigem, Double valorPagamento, Long idContaDestino) {

        ContaCorrenteModel contaCorrenteOrigem = contaCorrenteService.buscar(idContaOrigem);
        ContaCorrenteModel contaCorrenteDestino = contaCorrenteService.buscar(idContaDestino);

        if(contaCorrenteDestino == contaCorrenteOrigem) {
            throw new ContaException("Contas Iguais");
        }

        TransacaoModel transferencia = new TransacaoModel();

        contaCorrenteOrigem.sacar(valorPagamento);

        transferencia.setTipoDeTransacao(TipoDeTransacao.TRANSFERENCIA);
        transferencia.setContaDeOrigem(contaCorrenteOrigem);
        transferencia.setValorDaTransacao(valorPagamento);
        transferencia.setContaDeDestino(contaCorrenteDestino);
        contaCorrenteDestino.depositar(valorPagamento);

        return transacaoRepository.save(transferencia);

    }


}
