package dev.velasquez.tuplataya.domain.repository;

import dev.velasquez.tuplataya.domain.entities.Cliente;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClienteRepository extends CrudRepository<Cliente, Long> {
    Optional<Cliente> findClienteByIdentificacion(String identificacion);
}
