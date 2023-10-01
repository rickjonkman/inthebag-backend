package nl.inthebag.inthebagbackend.controllers;

import nl.inthebag.inthebagbackend.dtos.GroceryDto;
import nl.inthebag.inthebagbackend.services.GroceryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/groceries")
public class GroceryController {
    private final GroceryService groceryService;

    public GroceryController(GroceryService groceryService) {
        this.groceryService = groceryService;
    }

    @GetMapping("/{name}")
    public ResponseEntity<GroceryDto> getGroceryByName(@PathVariable String name) {
        GroceryDto groceryDto = groceryService.getGroceryByName(name);
        return ResponseEntity.ok(groceryDto);
    }

    @PutMapping("/{name}")
    public ResponseEntity<GroceryDto> updateGroceryByName(@PathVariable String name, @RequestBody GroceryDto groceryDto) {
        GroceryDto groceryDto1 = groceryService.updateGroceryByName(name, groceryDto);
        return ResponseEntity.ok(groceryDto1);
    }
}
