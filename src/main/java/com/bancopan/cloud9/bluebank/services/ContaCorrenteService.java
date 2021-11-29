package com.bancopan.cloud9.bluebank.services;

import com.bancopan.cloud9.bluebank.exception.ContaException;
import com.bancopan.cloud9.bluebank.models.ContaCorrenteModel;
import com.bancopan.cloud9.bluebank.repositories.ContaCorrenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ContaCorrenteService {

    @Autowired
    private ContaCorrenteRepository contaCorrenteRepository;


    public ContaCorrenteModel buscar(Long contaId) {
        return contaCorrenteRepository.findById(contaId)
                .orElseThrow(() -> new ContaException("Conta não encontrada"));
    }

}
