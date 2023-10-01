package nl.inthebag.inthebagbackend.services;

import nl.inthebag.inthebagbackend.dtos.GroceryDto;
import nl.inthebag.inthebagbackend.models.Grocery;
import nl.inthebag.inthebagbackend.repositories.GroceryRepository;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.Optional;

@Service
public class GroceryService {
    private final GroceryRepository groceryRepository;

    public GroceryService(GroceryRepository groceryRepository) {
        this.groceryRepository = groceryRepository;
    }

    public GroceryDto getGroceryByName(String name) {
        Optional<Grocery> groceryOptional = groceryRepository.findGroceryByName(name);
        GroceryDto groceryDto = new GroceryDto();

        if (groceryOptional.isPresent()) {
            Grocery grocery = groceryOptional.get();
            groceryDto = transferGroceryToDto(grocery);
        }

        return groceryDto;
    }

    public GroceryDto updateGroceryByName(String name, GroceryDto groceryDto) {
        Optional<Grocery> groceryOptional = groceryRepository.findGroceryByName(name);
        Grocery grocery = new Grocery();

        if (groceryOptional.isPresent()) {
            grocery = groceryOptional.get();

            grocery.setId(groceryDto.getId());
            grocery.setName(groceryDto.getName());
            grocery.setSection(groceryDto.getSection());
            grocery.setGroceryList(groceryDto.getGroceryList());
            groceryRepository.save(grocery);
        }

        return transferGroceryToDto(grocery);
    }

//    Transfer Entity to Dto
    public GroceryDto transferGroceryToDto(Grocery grocery) {
        GroceryDto groceryDto = new GroceryDto();
        groceryDto.setId(grocery.getId());
        groceryDto.setName(grocery.getName());
        groceryDto.setSection(grocery.getSection());
        groceryDto.setGroceryList(grocery.getGroceryList());
        return groceryDto;
    }

//    Transfer Dto to Entity
    public Grocery transferDtoToGrocery(GroceryDto groceryDto) {
        Grocery grocery = new Grocery();
        grocery.setId(groceryDto.getId());
        grocery.setName(groceryDto.getName());
        grocery.setSection(groceryDto.getSection());
        grocery.setGroceryList(groceryDto.getGroceryList());
        return grocery;
    }

}
