package dev.velasquez.tuplataya.domain.persistence;

import dev.velasquez.tuplataya.domain.entities.Cliente;

import java.util.List;
import java.util.Optional;

public interface IClienteDAO {

    List<Cliente> findAll();

    Optional<Cliente> findById(Long id);

    Optional<Cliente> findByIdentificacion(String identificacion);

    void save(Cliente cliente);

    void deleteById(Long id);
}
