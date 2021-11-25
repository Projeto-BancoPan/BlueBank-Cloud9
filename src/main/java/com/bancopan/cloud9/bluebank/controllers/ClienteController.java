package com.bancopan.cloud9.bluebank.controllers;

import com.bancopan.cloud9.bluebank.dtos.ClienteContatoDTO;
import com.bancopan.cloud9.bluebank.dtos.ClienteEnderecoDTO;
import com.bancopan.cloud9.bluebank.dtos.ClienteTipoDTO;
import com.bancopan.cloud9.bluebank.enums.TipoCliente;
import com.bancopan.cloud9.bluebank.models.ClienteModel;
import com.bancopan.cloud9.bluebank.repositories.ClienteRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/api")
@Api(value = "API REST BLUEBANK")
@CrossOrigin(origins = "*")
public class ClienteController {

    @Autowired
    private ClienteRepository repository;

    @GetMapping(value = "/clientes")
    @ApiOperation(value = "Retorna uma lista de todos os clientes")
    public ResponseEntity<List<ClienteModel>> getAllClienteModel() {
        return ResponseEntity.ok(repository.findAll());
    }

    @GetMapping(value = "/cliente/{idCliente}")
    @ApiOperation(value = "Retorna um cliente pelo id")
    public ResponseEntity<ClienteModel> consultarCliente(@PathVariable("idCliente") Long idCliente) {
        return repository.findById(idCliente)
                .map(record -> ResponseEntity.ok().body(record))
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping(value = "/cliente_endereco/{idCliente}")
    @ApiOperation(value = "Retorna o cliente pelo id somente com o endereço")
    public ResponseEntity<ClienteEnderecoDTO> consultarClientePorEnderecoDTO(@PathVariable("idCliente") Long idCliente) {
        ClienteModel clienteModel = repository.getById(idCliente);
        ClienteEnderecoDTO clienteEnderecoDTO = new ClienteEnderecoDTO(clienteModel);
        return ResponseEntity.ok(clienteEnderecoDTO);
    }

    @GetMapping(value = "/cliente_contato/{idCliente}")
    @ApiOperation(value = "Retorna o cliente pelo id somente com os contatos")
    public ResponseEntity<ClienteContatoDTO> consultarClientePorContatoDTO(@PathVariable("idCliente") Long idCliente) {
        ClienteModel clienteModel = repository.getById(idCliente);
        ClienteContatoDTO clienteContatoDTO = new ClienteContatoDTO(clienteModel);
        return ResponseEntity.ok(clienteContatoDTO);
    }

    @GetMapping(value = "/tipo_cliente/{tipoCliente}")
    @ApiOperation(value = "Retorna um cliente pelo tipo")
    public ResponseEntity<List<ClienteModel>> filtroId(@PathVariable TipoCliente tipoCliente){
        return ResponseEntity.ok(repository.procuraTipoCliente(tipoCliente));
    }

    @GetMapping(value = "/tipo_cliente_dto/{tipoCliente}")
    @ApiOperation(value = "Retorna uma lista de clientes pelo tipo com filtro de informações")
    public ResponseEntity<List<ClienteTipoDTO>> filtroporTipoDTO(@PathVariable TipoCliente tipoCliente){
        List<ClienteModel> listaClienteModel = repository.findAll();
        List<ClienteTipoDTO> listaClienteTipoDTO = ClienteTipoDTO.converteParaDTO(listaClienteModel);
        return ResponseEntity.ok(listaClienteTipoDTO);
    }

    @PostMapping(value = "/cliente/salvar")
    @ApiOperation(value = "Salva um novo cliente")
    public ResponseEntity<ClienteModel> salvarCliente(@RequestBody ClienteModel cliente) {
        return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(cliente));
    }

    @DeleteMapping(value = "/cliente/{idCliente}")
    @ApiOperation(value = "Deleta um cliente")
    public ResponseEntity<HttpStatus> deleteCliente(@PathVariable("idCliente") Long idCliente) {
        try {
           Optional<ClienteModel> cliente = repository.findById(idCliente);
           if (cliente.isPresent()) {
               repository.delete(cliente.get());
           }
           return new ResponseEntity<HttpStatus>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
           return new ResponseEntity<HttpStatus>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping(value = "/cliente/atualizar")
    @ApiOperation(value = "Atualiza os dados de um cliente")
    public ResponseEntity<ClienteModel> atualizarCliente(@RequestBody ClienteModel cliente) {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(repository.save(cliente));
    }
}
