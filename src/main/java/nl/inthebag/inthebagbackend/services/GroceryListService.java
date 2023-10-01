package nl.inthebag.inthebagbackend.services;

import nl.inthebag.inthebagbackend.dtos.GroceryDto;
import nl.inthebag.inthebagbackend.dtos.GroceryListDto;
import nl.inthebag.inthebagbackend.exceptions.RecordNotFoundException;
import nl.inthebag.inthebagbackend.models.Grocery;
import nl.inthebag.inthebagbackend.models.GroceryList;
import nl.inthebag.inthebagbackend.repositories.GroceryListRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class GroceryListService {

    private final GroceryListRepository groceryListRepository;

    public GroceryListService(GroceryListRepository groceryListRepository) {
        this.groceryListRepository = groceryListRepository;
    }

//    Get all grocery lists
    public List<GroceryListDto> findAllGroceryLists() {
        List<GroceryList> allGroceryLists = groceryListRepository.findAll();
        List<GroceryListDto> allDtoGroceryLists = new ArrayList<>();

        for (GroceryList gL : allGroceryLists) {
            GroceryListDto groceryListDto = transferGroceryListToDto(gL);
            allDtoGroceryLists.add(groceryListDto);
        }

        return allDtoGroceryLists;
    }

//    Create new Grocery list
    public GroceryListDto createNewGroceryList(GroceryListDto groceryListDto) {
        GroceryList groceryList = transferDtoToGroceryList(groceryListDto);
        groceryListRepository.save(groceryList);
        return transferGroceryListToDto(groceryList);
    }

//    Delete grocery list
    public void deleteGroceryListById(int id) {
        Optional<GroceryList> groceryListOptional = groceryListRepository.findById(id);
        if (groceryListOptional.isPresent()) {
            groceryListRepository.deleteById(id);
        } else {
            throw new RecordNotFoundException("Deze boodschappenlijst bestaat niet.");
        }
    }

//    Transfer GroceryList to Dto
    public GroceryListDto transferGroceryListToDto(GroceryList groceryList) {
        GroceryListDto groceryListDto = new GroceryListDto();
        groceryListDto.setId(groceryList.getId());
        groceryListDto.setGroceries(groceryList.getGroceries());
        return groceryListDto;
    }

    public GroceryList transferDtoToGroceryList(GroceryListDto groceryListDto) {
        GroceryList groceryList = new GroceryList();
        groceryList.setId(groceryListDto.getId());
        groceryList.setGroceries(groceryListDto.getGroceries());
        return groceryList;
    }
}
