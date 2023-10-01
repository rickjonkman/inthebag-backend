package nl.inthebag.inthebagbackend.controllers;

import nl.inthebag.inthebagbackend.dtos.RecipeDto;
import nl.inthebag.inthebagbackend.services.RecipeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/recipes")
public class RecipeController {
    private final RecipeService recipeService;

    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @GetMapping
    public ResponseEntity<List<RecipeDto>> getAllRecipes() {
        List<RecipeDto> allDtoRecipes = recipeService.findAllRecipes();
        return ResponseEntity.ok(allDtoRecipes);
    }

    @GetMapping("/{name}")
    public ResponseEntity<RecipeDto> getRecipeByName(@PathVariable String name) {
        RecipeDto recipeDto = recipeService.findRecipeByName(name);
        return ResponseEntity.ok(recipeDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<RecipeDto> updateRecipeById(@PathVariable int id, @RequestBody RecipeDto recipeDto) {
        RecipeDto recipeDto1 = recipeService.updateRecipeById(id, recipeDto);
        return ResponseEntity.ok(recipeDto1);
    }

}
