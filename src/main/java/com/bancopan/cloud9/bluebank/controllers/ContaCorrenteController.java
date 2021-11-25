package com.bancopan.cloud9.bluebank.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bancopan.cloud9.bluebank.models.ContaCorrenteModel;
import com.bancopan.cloud9.bluebank.repositories.ContaCorrenteRepository;



@RestController
@RequestMapping(value="/api/conta_corrente")
public class ContaCorrenteController {
	
	@Autowired
	private ContaCorrenteRepository repository;
	
	@GetMapping("/listar")
	public ResponseEntity<List<ContaCorrenteModel>> getAllContas() {
		return ResponseEntity.status(HttpStatus.OK).body(repository.findAll());
	}
	
	@GetMapping("/lista/{numeroConta}")
	public ResponseEntity consultarConta(@PathVariable("{numeroConta}") Long codigo) {
		return repository.findById(codigo)
				.map(record -> ResponseEntity.ok().body(record))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@PostMapping(path = "/salvar")
	public ResponseEntity<ContaCorrenteModel> salvarConta(@RequestBody ContaCorrenteModel conta){
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(conta));
	}
	
	@DeleteMapping(path = "/{numeroConta}")
	public ResponseEntity<HttpStatus> deleteConta(@PathVariable("{numeroConta}") Long codigo) {
	       try { 
	    	   Optional<ContaCorrenteModel> conta = repository.findById(codigo);
	    	   if (conta.isPresent()) {
	    		   repository.delete(conta.get());
	    	   }
	    	   return new ResponseEntity<HttpStatus>(HttpStatus.NO_CONTENT);
	       } catch (Exception e) {
	    	   return new ResponseEntity<HttpStatus>(HttpStatus.INTERNAL_SERVER_ERROR);
	       }
	       
	  }
	
	@PutMapping(path = "/atualizar")
    public ResponseEntity<ContaCorrenteModel> atualizarCliente(@RequestBody ContaCorrenteModel conta) {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(repository.save(conta));
        	
    }
	
}
