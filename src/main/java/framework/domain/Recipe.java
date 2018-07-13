package framework.domain;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Data
@Entity
public class Recipe {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String description;
    private int prepTime;
    private int cookTime;
    private String servings;
    private String source;
    private String url;
    
    @Lob   //long string value. more than 255
    private String direction;
    
    @Enumerated(value = EnumType.STRING) //instead of using the default Ordinal type
    private Difficulty difficulty;
    
    @Lob  //BLOB to store image
    private byte[] image;
    
    @OneToOne(cascade = CascadeType.ALL)
    private Notes notes;
    
    //Recipe is the owner in this relationship.  Using the recipe field (via get/set) in Ingredient object to maintain this relationship
    @OneToMany(cascade = CascadeType.ALL, mappedBy="recipe")
    private Set<Ingredient> ingredients = new HashSet<>();
    
    
    @ManyToMany
    @JoinTable(name = "recipe_category",
        joinColumns = @JoinColumn(name = "recipe_id"),
            inverseJoinColumns= @JoinColumn(name = "category_id"))
    private Set<Category> categories  = new HashSet<>();

    public Recipe() {
    }

    public void setNotes(Notes notes) {
        this.notes = notes;
        notes.setRecipe(this);
    }

    public void addIngredient(Ingredient ingredient) {
        this.ingredients.add(ingredient);
        ingredient.setRecipe(this);
    }


}
