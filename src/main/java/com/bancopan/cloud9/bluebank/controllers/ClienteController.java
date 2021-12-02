package com.bancopan.cloud9.bluebank.controllers;

import com.bancopan.cloud9.bluebank.dtos.*;
import com.bancopan.cloud9.bluebank.models.ClienteModel;
import com.bancopan.cloud9.bluebank.repositories.ClienteRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api")
@Api(value = "API REST BLUEBANK")
@CrossOrigin(origins = "*")
public class ClienteController {

    @Autowired
    private ClienteRepository repository;

    @GetMapping(value = "/clientes")
    @ApiOperation(value = "Retorna uma lista de todos os clientes")
    public ResponseEntity<List<ConsultaClienteModelDTO>> getAllClienteModel() {
        List<ClienteModel> clienteModelList = repository.findAll();
        List<ConsultaClienteModelDTO> consultaClienteModelDTOList = ConsultaClienteModelDTO.converteParaDTO(clienteModelList);
        return ResponseEntity.ok(consultaClienteModelDTOList);
    }

    @GetMapping(value = "/cliente/{idCliente}")
    @ApiOperation(value = "Retorna um cliente pelo id")
    public ResponseEntity<ConsultaClienteModelDTO> consultarCliente(@PathVariable("idCliente") Long idCliente) {
        ClienteModel clienteModel = repository.getById(idCliente);
        ConsultaClienteModelDTO consultaClienteModelDTO = new ConsultaClienteModelDTO(clienteModel);
        return ResponseEntity.ok(consultaClienteModelDTO);
    }

    @GetMapping(value = "/cliente_endereco/{idCliente}")
    @ApiOperation(value = "Retorna o cliente pelo id somente com o endereço")
    public ResponseEntity<ConsultaClienteEnderecoDTO> consultarClientePorEnderecoDTO(@PathVariable("idCliente") Long idCliente) {
        ClienteModel clienteModel = repository.getById(idCliente);
        ConsultaClienteEnderecoDTO consultaClienteEnderecoDTO = new ConsultaClienteEnderecoDTO(clienteModel);
        return ResponseEntity.ok(consultaClienteEnderecoDTO);
    }

    @GetMapping(value = "/cliente_contato/{idCliente}")
    @ApiOperation(value = "Retorna o cliente pelo id somente com os contatos")
    public ResponseEntity<ConsultaClienteContatoDTO> consultarClientePorContatoDTO(@PathVariable("idCliente") Long idCliente) {
        ClienteModel clienteModel = repository.getById(idCliente);
        ConsultaClienteContatoDTO consultaClienteContatoDTO = new ConsultaClienteContatoDTO(clienteModel);
        return ResponseEntity.ok(consultaClienteContatoDTO);
    }

    @GetMapping(value = "/tipo_cliente/{tipoCliente}")
    @ApiOperation(value = "Retorna uma lista de clientes pelo tipo")
    public ResponseEntity<List<ClienteModel>> filtroPorTipo( String tipoCliente){
        return ResponseEntity.ok(repository.procuraTipoCliente(tipoCliente));
    }

    @GetMapping(value = "/tipo_cliente_dto/{tipoCliente}")
    @ApiOperation(value = "Retorna uma lista de clientes pelo tipo com endereços e contatos")
    public ResponseEntity<List<ConsultaClienteTipoDTO>> filtroPorTipoDTO(@PathVariable String tipoCliente){
        List<ClienteModel> listaClienteModel = repository.procuraTipoCliente(tipoCliente);
        List<ConsultaClienteTipoDTO> listaConsultaClienteTipoDTO = ConsultaClienteTipoDTO.converteParaDTO(listaClienteModel);
        return ResponseEntity.ok(listaConsultaClienteTipoDTO);
    }

    @PostMapping(value = "/cliente/salvar")
    @ApiOperation(value = "Salva um novo cliente")
    public ResponseEntity<ClienteModel> salvarCliente(@RequestBody CriarClienteDTO criarClienteDTO) {
        ClienteModel clienteModel = CriarClienteDTO.converteParaModel(criarClienteDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(clienteModel));
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
