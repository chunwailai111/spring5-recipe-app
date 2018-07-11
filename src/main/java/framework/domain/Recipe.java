package framework.domain;

import java.util.Set;

import javax.persistence.*;

import org.springframework.format.annotation.NumberFormat;


@Entity
public class Recipe {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String description;
    private String prepTime;
    private String cookTime;
    private String servings;
    private String source;
    private String url;
    private String direction;
    
    @Enumerated(value = EnumType.STRING) //instead of using the default Ordinal type
    private Difficulty difficulty;
    
    @Lob  //BLOB to store image
    private byte[] image;
    
    @OneToOne(cascade = CascadeType.ALL)
    private Notes notes;
    
    //Recipe is the owner in this relationship.  Using the recipe field (via get/set) in Ingredient object to maintain this relationship
    @OneToMany(cascade = CascadeType.ALL, mappedBy="recipe")
    private Set<Ingredient> ingredients;
    
    @ManyToMany(mappedBy="recipes")
    private Set<Category> categories;
    
    public String getDescription() {
        return description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    
    public String getPrepTime() {
        return prepTime;
    }
    
    public void setPrepTime(String prepTime) {
        this.prepTime = prepTime;
    }
    
    public String getCookTime() {
        return cookTime;
    }
    
    public void setCookTime(String cookTime) {
        this.cookTime = cookTime;
    }
    
    public String getServings() {
        return servings;
    }
    
    public void setServings(String servings) {
        this.servings = servings;
    }
    
    public String getSource() {
        return source;
    }
    
    public void setSource(String source) {
        this.source = source;
    }
    
    public String getUrl() {
        return url;
    }
    
    public void setUrl(String url) {
        this.url = url;
    }
    
    public String getDirection() {
        return direction;
    }
    
    public void setDirection(String direction) {
        this.direction = direction;
    }
    
    public Notes getNotes() {
        return notes;
    }
    
    public void setNotes(Notes notes) {
        this.notes = notes;
    }
    
    public byte[] getImage() {
        return image;
    }
    
    public void setImage(byte[] image) {
        this.image = image;
    }
    
    public Set<Category> getCategories() {
        return categories;
    }
    
    public void setCategories(Set<Category> categories) {
        this.categories = categories;
    }
}
