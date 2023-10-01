package nl.inthebag.inthebagbackend.controllers;

import nl.inthebag.inthebagbackend.dtos.GroceryListDto;
import nl.inthebag.inthebagbackend.services.GroceryListService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/grocerylists")
public class GroceryListController {
    private final GroceryListService groceryListService;

    public GroceryListController(GroceryListService groceryListService) {
        this.groceryListService = groceryListService;
    }

    @GetMapping
    public ResponseEntity<List<GroceryListDto>> getAllGroceryLists() {
        List<GroceryListDto> allDtoGroceryLists = groceryListService.findAllGroceryLists();
        return ResponseEntity.ok(allDtoGroceryLists);
    }

    @PostMapping
    public ResponseEntity<GroceryListDto> createNewGroceryList(@RequestBody GroceryListDto groceryListDto) {
        GroceryListDto groceryListDto1 = groceryListService.createNewGroceryList(groceryListDto);

        URI uri = URI.create(ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/" + groceryListDto1.getId())
                .toUriString());

        return ResponseEntity.created(uri).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteGroceryList(@PathVariable int id) {
        groceryListService.deleteGroceryListById(id);
        return ResponseEntity.noContent().build();
    }
}
