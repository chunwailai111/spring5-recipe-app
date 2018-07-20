package framework.repositories;

import org.springframework.data.repository.CrudRepository;

import framework.domain.Recipe;

public interface RecipeRepository extends CrudRepository<Recipe, Long>{
    
    
}
