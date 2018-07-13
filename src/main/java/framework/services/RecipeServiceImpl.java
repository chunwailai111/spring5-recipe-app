package framework.services;

import framework.domain.Recipe;
import framework.repositories.RecipeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Slf4j
public class RecipeServiceImpl implements RecipeService {

    private final RecipeRepository recipeRepository;

    public RecipeServiceImpl(RecipeRepository recipeRepository){
        this.recipeRepository = recipeRepository;
    }

    @Override
    public Set<Recipe> getRecipes() {

        Set<Recipe> allReciples = new HashSet<>();
        recipeRepository.findAll().forEach(allReciples::add);
        log.debug("successfully looked up receipes");
        return allReciples;
    }
}
