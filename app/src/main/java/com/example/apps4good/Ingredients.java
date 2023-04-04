package com.example.apps4good;
import java.util.ArrayList;

public class Ingredients {

    //Data
    public static ArrayList<String> ingredientsList;
    public String name;

    //Constructor
    public Ingredients(String name) {
        ingredientsList = new ArrayList<>();
        this.name = name;
    }
    //Methods
    /*
    public void addIngredient(String ingredient) {
        ingredientsList.add(ingredient);
    }
     */

    public static ArrayList<String> getIngredients() {
        return ingredientsList;
    }

}
