package dev.velasquez.tuplataya.domain.persistence.impl;

import dev.velasquez.tuplataya.domain.entities.Cliente;
import dev.velasquez.tuplataya.domain.persistence.IClienteDAO;
import dev.velasquez.tuplataya.domain.repository.ClienteRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class ClienteDAO implements IClienteDAO {

    private ClienteRepository clienteRepository;

    public ClienteDAO(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @Override
    public List<Cliente> findAll() {
        return (List<Cliente>) clienteRepository.findAll();
    }

    @Override
    public Optional<Cliente> findById(Long id) {
        return clienteRepository.findById(id);
    }

    @Override
    public Optional<Cliente> findByIdentificacion(String identificacion) {
        return clienteRepository.findClienteByIdentificacion(identificacion);
    }

    @Override
    public void save(Cliente cliente) {
        clienteRepository.save(cliente);
    }

    @Override
    public void deleteById(Long id) {
        clienteRepository.deleteById(id);
    }
}