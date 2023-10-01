package nl.inthebag.inthebagbackend.repositories;

import nl.inthebag.inthebagbackend.models.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RecipeRepository extends JpaRepository<Recipe, Integer> {

    Optional<Recipe> findRecipeByName(String name);
}
