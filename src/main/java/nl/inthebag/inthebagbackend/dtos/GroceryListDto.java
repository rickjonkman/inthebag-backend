package nl.inthebag.inthebagbackend.dtos;

import nl.inthebag.inthebagbackend.models.Grocery;

import java.util.List;

public class GroceryListDto {
    private int id;
    private List<Grocery> groceries;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Grocery> getGroceries() {
        return groceries;
    }

    public void setGroceries(List<Grocery> groceries) {
        this.groceries = groceries;
    }
}
