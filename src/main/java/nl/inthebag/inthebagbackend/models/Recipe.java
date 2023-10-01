package nl.inthebag.inthebagbackend.models;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "recipe")
public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;
    @Column(name = "description")
    private String description;
    @Column(name = "instructions")
    private String instructions;
    @Column(name = "prep_time")
    private int prepTime;
    @Column(name = "cook_time")
    private int cookTime;
    @Column(name = "servings")
    private int servings;
    @OneToOne
    @JoinColumn(name = "nutrition_id")
    private Nutrition nutritionValues;
    @Column(name = "cuisine")
    private String cuisine;
    @Column(name = "course")
    private String course;
    @ManyToMany(mappedBy = "recipes")
    private List<Ingredient> ingredients;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

    public int getPrepTime() {
        return prepTime;
    }

    public void setPrepTime(int prepTime) {
        this.prepTime = prepTime;
    }

    public int getCookTime() {
        return cookTime;
    }

    public void setCookTime(int cookTime) {
        this.cookTime = cookTime;
    }

    public int getServings() {
        return servings;
    }

    public void setServings(int servings) {
        this.servings = servings;
    }

    public Nutrition getNutritionValues() {
        return nutritionValues;
    }

    public void setNutritionValues(Nutrition nutritionValues) {
        this.nutritionValues = nutritionValues;
    }

    public String getCuisine() {
        return cuisine;
    }

    public void setCuisine(String cuisine) {
        this.cuisine = cuisine;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }
}
