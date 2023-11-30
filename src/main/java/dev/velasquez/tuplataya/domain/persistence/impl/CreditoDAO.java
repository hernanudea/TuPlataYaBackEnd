package dev.velasquez.tuplataya.domain.persistence.impl;

import dev.velasquez.tuplataya.domain.entities.Credito;
import dev.velasquez.tuplataya.domain.persistence.ICreditoDAO;
import dev.velasquez.tuplataya.domain.repository.CreditoRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class CreditoDAO implements ICreditoDAO {

    private CreditoRepository creditoRepository;

    public CreditoDAO(CreditoRepository creditoRepository) {
        this.creditoRepository = creditoRepository;
    }

    @Override
    public List<Credito> findAll() {
        return (List<Credito>) creditoRepository.findAll();
    }

    @Override
    public Optional<Credito> findById(Long id) {
        return creditoRepository.findById(id);
    }

    @Override
    public void save(Credito credito) {
        creditoRepository.save(credito);
    }

    @Override
    public void deleteById(Long id) {
        creditoRepository.deleteById(id);
    }
}
