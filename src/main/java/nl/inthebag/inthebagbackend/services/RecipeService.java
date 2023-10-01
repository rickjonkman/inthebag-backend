package nl.inthebag.inthebagbackend.services;

import nl.inthebag.inthebagbackend.dtos.RecipeDto;
import nl.inthebag.inthebagbackend.exceptions.RecordNotFoundException;
import nl.inthebag.inthebagbackend.models.Recipe;
import nl.inthebag.inthebagbackend.repositories.RecipeRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class RecipeService {
    private final RecipeRepository recipeRepository;

    public RecipeService(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

//    Get all recipes
    public List<RecipeDto> findAllRecipes() {
        List<Recipe> allRecipes = recipeRepository.findAll();
        List<RecipeDto> allDtoRecipes = new ArrayList<>();

        for (Recipe r : allRecipes) {
            RecipeDto recipeDto = transferFromRecipeToDto(r);
            allDtoRecipes.add(recipeDto);
        }

        return allDtoRecipes;
    }

//    Get Recipe by name
    public RecipeDto findRecipeByName(String name) {
        Optional<Recipe> recipeOptional = recipeRepository.findRecipeByName(name);
        RecipeDto recipeDto = new RecipeDto();

        if (recipeOptional.isPresent()) {
            Recipe recipe = recipeOptional.get();
            recipeDto = transferFromRecipeToDto(recipe);
        }

        return recipeDto;
    }

//    Update recipe by id
    public RecipeDto updateRecipeById(int id, RecipeDto recipeDto) {
        Optional<Recipe> recipeOptional = recipeRepository.findById(id);
        RecipeDto recipeDto1 = new RecipeDto();

        if (recipeOptional.isPresent()) {
            Recipe recipeFromDb = recipeOptional.get();
            recipeFromDb = transferFromDtoToRecipe(recipeDto);
            recipeRepository.save(recipeFromDb);
            transferFromRecipeToDto(recipeFromDb);
        } else {
            throw new RecordNotFoundException("Dit recept komt niet voor in de database.");
        }

        return recipeDto1;
    }

//    Transfer from Dto to Recipe
    public Recipe transferFromDtoToRecipe(RecipeDto recipeDto) {
        Recipe recipe = new Recipe();
        recipe.setId(recipeDto.getId());
        recipe.setName(recipeDto.getName());
        recipe.setDescription(recipeDto.getDescription());
        recipe.setInstructions(recipeDto.getInstructions());
        recipe.setPrepTime(recipeDto.getPrepTime());
        recipe.setCookTime(recipeDto.getCookTime());
        recipe.setServings(recipeDto.getServings());
        recipe.setNutritionValues(recipeDto.getNutritionValues());
        recipe.setCuisine(recipeDto.getCuisine());
        recipe.setCourse(recipeDto.getCourse());
        recipe.setIngredients(recipeDto.getIngredients());
        return recipe;
    }

//    Transfer from Recipe to Dto
    public RecipeDto transferFromRecipeToDto(Recipe recipe) {
        RecipeDto recipeDto = new RecipeDto();
        recipeDto.setId(recipe.getId());
        recipeDto.setName(recipe.getName());
        recipeDto.setDescription(recipe.getDescription());
        recipeDto.setInstructions(recipe.getInstructions());
        recipeDto.setPrepTime(recipe.getPrepTime());
        recipeDto.setCookTime(recipe.getCookTime());
        recipeDto.setServings(recipe.getServings());
        recipeDto.setNutritionValues(recipe.getNutritionValues());
        recipeDto.setCuisine(recipe.getCuisine());
        recipeDto.setCourse(recipe.getCourse());
        recipeDto.setIngredients(recipe.getIngredients());
        return recipeDto;
    }
}
