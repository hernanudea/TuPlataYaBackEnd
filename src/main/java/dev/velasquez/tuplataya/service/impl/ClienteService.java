package dev.velasquez.tuplataya.service.impl;

import dev.velasquez.tuplataya.domain.entities.Cliente;
import dev.velasquez.tuplataya.domain.persistence.IClienteDAO;
import dev.velasquez.tuplataya.service.IClienteService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService implements IClienteService {

    private IClienteDAO clienteDAO;

    public ClienteService(IClienteDAO clienteDAO) {
        this.clienteDAO = clienteDAO;
    }

    @Override
    public List<Cliente> findAll() {
        return clienteDAO.findAll();
    }

    @Override
    public Optional<Cliente> findById(Long id) {
        return clienteDAO.findById(id);
    }

    @Override
    public Optional<Cliente> findByIdentificacion(String identificacion) {
        return clienteDAO.findByIdentificacion(identificacion);
    }

    @Override
    public void save(Cliente cliente) {
        clienteDAO.save(cliente);
    }

    @Override
    public void deleteById(Long id) {
        clienteDAO.deleteById(id);
    }
}
