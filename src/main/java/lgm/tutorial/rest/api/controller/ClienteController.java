package lgm.tutorial.rest.api.controller;

import lgm.tutorial.rest.api.model.ClienteModel;
import lgm.tutorial.rest.api.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.nio.file.Path;
import java.util.List;

@RestController
public class ClienteController {

    @Autowired
    private ClienteRepository repository;

    @GetMapping("/api/cliente")
    public List<ClienteModel> getAllClienteModel() {
        return (List<ClienteModel>) repository.findAll();
    }

    @GetMapping(path = "/api/cliente/{codigo}")
    public ResponseEntity consultar(@PathVariable("codigo") Integer codigo) {
        return repository.findById(codigo)
                .map(record -> ResponseEntity.ok().body(record))
                .orElse(ResponseEntity.notFound().build());
    }
    @PostMapping(path = "/api/cliente/salvar")
    public ClienteModel salvar(@RequestBody ClienteModel cliente) {
        return repository.save(cliente);
    }

   @DeleteMapping("api/cliente/{codigo}")
   public void deleteClienteModel(@PathVariable Integer codigo) {
       repository.deleteById(codigo);
  }
}
