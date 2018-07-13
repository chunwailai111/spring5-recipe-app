package framework.services;

import framework.domain.Recipe;
import framework.repositories.RecipeRepository;
import org.springframework.stereotype.Service;

import java.util.Set;

public interface RecipeService {

    Set<Recipe> getRecipes();
}
