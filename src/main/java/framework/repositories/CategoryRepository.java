package framework.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import framework.domain.Category;

public interface CategoryRepository extends CrudRepository<Category, Long>{
    
    Optional<Category> findByDescription(String description);
}
