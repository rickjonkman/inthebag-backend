package nl.inthebag.inthebagbackend.repositories;

import nl.inthebag.inthebagbackend.models.Grocery;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface GroceryRepository extends JpaRepository<Grocery, Integer> {
    Optional<Grocery> findGroceryByName(String name);
}
