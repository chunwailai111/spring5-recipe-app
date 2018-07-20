package framework.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import framework.domain.UnitOfMeasure;

public interface UnitOfMeasureRepository extends CrudRepository<UnitOfMeasure, Long>{

    Optional<UnitOfMeasure> findByDescription(String description);
}
