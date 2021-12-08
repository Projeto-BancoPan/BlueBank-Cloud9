package com.bancopan.cloud9.bluebank.controllers;

import com.amazonaws.services.sns.AmazonSNSClient;
import com.amazonaws.services.sns.model.SubscribeRequest;
import com.bancopan.cloud9.bluebank.dtos.*;
import com.bancopan.cloud9.bluebank.models.ClienteModel;
import com.bancopan.cloud9.bluebank.repositories.ClienteRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api")
@Api(value = "API REST BLUEBANK")
@CrossOrigin(origins = "*")
public class ClienteController {

    @Autowired
    private ClienteRepository repository;

    @Autowired
    private AmazonSNSClient snsClient;

    String TOPIC_ARN = "arn:aws:sns:us-east-1:965934840569:Cloud9_sns";

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

        if (!repository.existsById(idCliente)) {
            return ResponseEntity.notFound().build();
        }

        ClienteModel clienteModel = repository.getById(idCliente);
        ConsultaClienteModelDTO consultaClienteModelDTO = new ConsultaClienteModelDTO(clienteModel);
        return ResponseEntity.ok(consultaClienteModelDTO);
    }

    @GetMapping(value = "/cliente_endereco/{idCliente}")
    @ApiOperation(value = "Retorna o cliente pelo id somente com o endereço")
    public ResponseEntity<ConsultaClienteEnderecoDTO> consultarClientePorEnderecoDTO(@PathVariable("idCliente") Long idCliente) {

        if (!repository.existsById(idCliente)) {
            return ResponseEntity.notFound().build();
        }

        ClienteModel clienteModel = repository.getById(idCliente);
        ConsultaClienteEnderecoDTO consultaClienteEnderecoDTO = new ConsultaClienteEnderecoDTO(clienteModel);
        return ResponseEntity.ok(consultaClienteEnderecoDTO);
    }

    @GetMapping(value = "/cliente_contato/{idCliente}")
    @ApiOperation(value = "Retorna o cliente pelo id somente com os contatos")
    public ResponseEntity<ConsultaClienteContatoDTO> consultarClientePorContatoDTO(@PathVariable("idCliente") Long idCliente) {

        if (!repository.existsById(idCliente)) {
            return ResponseEntity.notFound().build();
        }

        ClienteModel clienteModel = repository.getById(idCliente);
        ConsultaClienteContatoDTO consultaClienteContatoDTO = new ConsultaClienteContatoDTO(clienteModel);
        return ResponseEntity.ok(consultaClienteContatoDTO);
    }

    @GetMapping(value = "/tipo_cliente/{tipoCliente}")
    @ApiOperation(value = "Retorna uma lista de clientes pelo tipo")
    public ResponseEntity<List<ClienteModel>> filtroPorTipo(@PathVariable("tipoCLiente") String tipoCliente) {

        List<ClienteModel> listaClienteModel = repository.procuraTipoCliente(tipoCliente);
        return ResponseEntity.ok(listaClienteModel);
    }

    @GetMapping(value = "/tipo_cliente_dto/{tipoCliente}")
    @ApiOperation(value = "Retorna uma lista de clientes pelo tipo com endereços e contatos")
    public ResponseEntity<List<ConsultaClienteTipoDTO>> filtroPorTipoDTO(@PathVariable("tipoCliente") String tipoCliente) {


        List<ClienteModel> listaClienteModel = repository.procuraTipoCliente(tipoCliente);
        List<ConsultaClienteTipoDTO> listaConsultaClienteTipoDTO = ConsultaClienteTipoDTO.converteParaDTO(listaClienteModel);
        return ResponseEntity.ok(listaConsultaClienteTipoDTO);
    }

    @PostMapping(value = "/cliente/salvar")
    @ApiOperation(value = "Salva um novo cliente")
    public ResponseEntity<ClienteModel> salvarCliente(@Valid @RequestBody CriarClienteDTO criarClienteDTO) {
        SubscribeRequest request = new SubscribeRequest(TOPIC_ARN, "email", criarClienteDTO.getEmail());
        snsClient.subscribe(request);

        ClienteModel clienteModel = CriarClienteDTO.converteParaModel(criarClienteDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(clienteModel));
    }

    @DeleteMapping(value = "/cliente/{idCliente}")
    @ApiOperation(value = "Deleta um cliente")
    public ResponseEntity<Void> deleteCliente(@PathVariable("idCliente") Long idCliente) {

        if (!repository.existsById(idCliente)) {
            return ResponseEntity.notFound().build();
        }
        repository.deleteById(idCliente);
        return ResponseEntity.noContent().build();

    }


    @Transactional
    @RequestMapping(value = "/cliente/atualizar/{idCliente}", method = RequestMethod.PUT)
    @ApiOperation(value = "Atualiza os dados de um cliente")
    public ResponseEntity<ClienteModel> Put(@PathVariable(value = "idCliente") Long idCliente, @Valid @RequestBody ClienteModel cliente) {

        Optional<ClienteModel> clienteModel = repository.findById(idCliente);
        if (clienteModel.isPresent()) {
            ClienteModel pessoa = clienteModel.get();
            pessoa.setNome(cliente.getNome());
            pessoa.setEmail(cliente.getEmail());
            pessoa.setTelefone(cliente.getTelefone());
            pessoa.setEnderecoModel(cliente.getEnderecoModel());
            cliente.setContaCorrenteModel(cliente.getContaCorrenteModel());
            pessoa.setRenda(cliente.getRenda());
            repository.save(pessoa);
            return new ResponseEntity<>(pessoa, HttpStatus.OK);
        } else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
