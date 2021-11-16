package lgm.tutorial.rest.api.repository;

import lgm.tutorial.rest.api.model.ClienteModel;
import org.springframework.data.repository.CrudRepository;

public interface ClienteRepository extends CrudRepository<ClienteModel, Integer> {
}
