package framework.controllers;

import framework.domain.Recipe;
import framework.repositories.RecipeRepository;
import framework.services.RecipeService;
import framework.services.RecipeServiceImpl;
import lombok.extern.slf4j.Slf4j;
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

    IndexController controller;

    @Mock
    RecipeServiceImpl service;

    @Mock
    Model model;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        controller = new IndexController(service);
    }

    @Test
    public void getIndexPage() {
        String pageName = controller.getIndexPage(model);

        assertEquals("index",pageName);
        verify(model, times(1)).addAttribute(eq("recipes"), anySet());
        verify(service, times(1)).getRecipes();

    }
}