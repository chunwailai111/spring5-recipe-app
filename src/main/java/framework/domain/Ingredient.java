package framework.domain;

import lombok.*;

import java.math.BigDecimal;


import javax.persistence.*;

@Data
@EqualsAndHashCode(exclude = {"recipe"})
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

    public Ingredient() {
    }

    public Ingredient(String description, BigDecimal amount, UnitOfMeasure unitOfMeas, Recipe recipe) {
        // "ripe avocados", new BigDecimal(2), eachUom, guacRecipe
        this.description = description;
        this.amount = amount;
        this.unitOfMeas = unitOfMeas;
        this.recipe = recipe;
    }

    public Ingredient(String description, BigDecimal amount, UnitOfMeasure unitOfMeas) {
        // "ripe avocados", new BigDecimal(2), eachUom, guacRecipe
        this.description = description;
        this.amount = amount;
        this.unitOfMeas = unitOfMeas;
    }

    public Long getId() {
        return Id;
    }
    public void setId(Long id) {
        Id = id;
    }

}
