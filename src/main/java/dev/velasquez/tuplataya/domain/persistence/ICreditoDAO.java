package dev.velasquez.tuplataya.domain.persistence;

import dev.velasquez.tuplataya.domain.entities.Credito;

import java.util.List;
import java.util.Optional;

public interface ICreditoDAO {

    List<Credito> findAll();

    Optional<Credito> findById(Long id);

    void save(Credito credito);

    void deleteById(Long id);
}
