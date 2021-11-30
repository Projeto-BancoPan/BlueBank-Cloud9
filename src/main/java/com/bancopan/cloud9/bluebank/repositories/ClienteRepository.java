package com.bancopan.cloud9.bluebank.repositories;

import com.bancopan.cloud9.bluebank.models.ClienteModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ClienteRepository extends JpaRepository<ClienteModel, Long> {

    @Query(value= "SELECT * FROM TB_CLIENTES u WHERE u.tipo_cliente = :tipoCliente", nativeQuery = true)
    List<ClienteModel> procuraTipoCliente(String tipoCliente);

}
