package nl.inthebag.inthebagbackend.dtos;

import jakarta.persistence.Column;
import jakarta.persistence.ManyToOne;
import nl.inthebag.inthebagbackend.models.Grocery;
import nl.inthebag.inthebagbackend.models.GroceryList;

import java.util.List;

public class GroceryDto {
    private int id;
    private String name;
    private String section;
    private GroceryList groceryList;

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

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public GroceryList getGroceryList() {
        return groceryList;
    }

    public void setGroceryList(GroceryList groceryList) {
        this.groceryList = groceryList;
    }
}
