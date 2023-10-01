package nl.inthebag.inthebagbackend.repositories;

import nl.inthebag.inthebagbackend.models.GroceryList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GroceryListRepository extends JpaRepository<GroceryList, Integer> {

}
