package com.bancopan.cloud9.bluebank.repositories;

import com.bancopan.cloud9.bluebank.models.TransacaoModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransacaoRepository extends JpaRepository<TransacaoModel, Long> {

}
