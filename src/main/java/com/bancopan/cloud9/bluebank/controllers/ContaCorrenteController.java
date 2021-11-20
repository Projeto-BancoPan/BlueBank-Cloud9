package com.bancopan.cloud9.bluebank.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bancopan.cloud9.bluebank.models.ContaCorrenteModel;
import com.bancopan.cloud9.bluebank.repositories.ContaCorrenteRepository;



@RestController
@RequestMapping(value="/api/conta")
public class ContaCorrenteController {
	
	@Autowired
	private ContaCorrenteRepository repository;
	
	@GetMapping("/Contas")
	public ResponseEntity<List<ContaCorrenteModel>> getAllContas() {
		return ResponseEntity.status(HttpStatus.OK).body(repository.findAll());
	}
	
	@GetMapping("/Contas/{id}")
	public ResponseEntity consultarConta(@PathVariable("id") Long codigo) {
		return repository.findById(codigo)
				.map(record -> ResponseEntity.ok().body(record))
				.orElse(ResponseEntity.notFOund().build));
	}
}
