package com.bancopan.cloud9.bluebank.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bancopan.cloud9.bluebank.models.ContaCorrenteModel;

public  interface ContaCorrenteRepository extends JpaRepository<ContaCorrenteModel, Long> {
	
}
