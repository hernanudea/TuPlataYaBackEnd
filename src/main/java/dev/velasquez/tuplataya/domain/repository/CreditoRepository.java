package dev.velasquez.tuplataya.domain.repository;

import dev.velasquez.tuplataya.domain.entities.Credito;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CreditoRepository extends CrudRepository<Credito, Long> {
}
