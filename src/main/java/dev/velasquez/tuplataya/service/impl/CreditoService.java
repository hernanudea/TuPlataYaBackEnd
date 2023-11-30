package dev.velasquez.tuplataya.service.impl;

import dev.velasquez.tuplataya.domain.entities.Credito;
import dev.velasquez.tuplataya.domain.persistence.ICreditoDAO;
import dev.velasquez.tuplataya.service.ICreditoService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CreditoService implements ICreditoService {

    private ICreditoDAO creditoDAO;

    public CreditoService(ICreditoDAO creditoDAO) {
        this.creditoDAO = creditoDAO;
    }

    @Override
    public List<Credito> findAll() {
        return creditoDAO.findAll();
    }

    @Override
    public Optional<Credito> findById(Long id) {
        return creditoDAO.findById(id);
    }

    @Override
    public void save(Credito credito) {
        creditoDAO.save(credito);
    }

    @Override
    public void deleteById(Long id) {
        creditoDAO.deleteById(id);
    }
}
