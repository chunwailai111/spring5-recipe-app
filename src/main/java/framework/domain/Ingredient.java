package framework.domain;

import java.math.BigDecimal;


import javax.persistence.*;

@Entity
public class Ingredient {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    
    private String description;
    private BigDecimal amount;
    
    @ManyToOne
    private Recipe recipe;
    
    @OneToOne(fetch = FetchType.EAGER)  //default is already Eager. 
    private UnitOfMeasure unitOfMeas;
    
    public Long getId() {
        return Id;
    }
    public void setId(Long id) {
        Id = id;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    
    public Recipe getRecipe() {
        return recipe;
    }
    
    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }
}