package nl.inthebag.inthebagbackend.models;

import jakarta.persistence.*;

@Entity
@Table(name = "nutrition_values")
public class Nutrition {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "calories")
    private int calories;
    @Column(name = "carbs")
    private int carbs;
    @Column(name = "sugar")
    private int sugar;
    @Column(name = "fat")
    private int fat;
    @Column(name = "proteine")
    private int proteine;
    @Column(name = "fibers")
    private int fibers;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public int getCarbs() {
        return carbs;
    }

    public void setCarbs(int carbs) {
        this.carbs = carbs;
    }

    public int getSugar() {
        return sugar;
    }

    public void setSugar(int sugar) {
        this.sugar = sugar;
    }

    public int getFat() {
        return fat;
    }

    public void setFat(int fat) {
        this.fat = fat;
    }

    public int getProteine() {
        return proteine;
    }

    public void setProteine(int proteine) {
        this.proteine = proteine;
    }

    public int getFibers() {
        return fibers;
    }

    public void setFibers(int fibers) {
        this.fibers = fibers;
    }
}
