package dev.velasquez.tuplataya.service;

import dev.velasquez.tuplataya.domain.entities.Credito;

import java.util.List;
import java.util.Optional;

public interface ICreditoService {
    List<Credito> findAll();

    Optional<Credito> findById(Long id);

    void save(Credito credito);

    void deleteById(Long id);


}
