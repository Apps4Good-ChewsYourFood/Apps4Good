package com.example.apps4good;
import java.util.ArrayList;

public class Ingredients {

    //Data
    public static ArrayList<String> ingredientsList;

    //Constructor
    public Ingredients() {
        ingredientsList = new ArrayList<>();
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
