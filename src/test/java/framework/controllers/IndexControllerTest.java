package framework.controllers;

import framework.domain.Recipe;
import framework.repositories.RecipeRepository;
import framework.services.RecipeService;
import framework.services.RecipeServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class IndexControllerTest {

    RecipeServiceImpl service;

    @Mock
    RecipeRepository recipeRepo;

    @Mock
    Model model;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        service = new RecipeServiceImpl(recipeRepo);
    }

    @Test
    public void getIndexPage() {
        Recipe recipe = new Recipe();
        Set<Recipe> result = new HashSet<>();
        result.add(recipe);
        when(service.getRecipes()).thenReturn(result);

        Set<Recipe> recipes = service.getRecipes();

        assertEquals(1,recipes.size());
        verify(recipeRepo,times(1)).findAll();
    }
}