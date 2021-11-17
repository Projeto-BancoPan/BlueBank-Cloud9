package com.bancopan.cloud9.bluebank.repositories;

import com.bancopan.cloud9.bluebank.models.ClienteModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<ClienteModel, Long> {
}
