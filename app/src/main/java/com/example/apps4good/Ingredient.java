package com.example.apps4good;
import java.util.ArrayList;

/**
 * This class stores an ingredient as an individual object
 */
public class Ingredient {

    //Data
    public static ArrayList<String> ingredientsList;

    //Constructor

    /**
     * This constructor
     */
    public Ingredient() {
        ingredientsList = new ArrayList<>();
    }
    //Methods

    /**
     * Returns the ArrayList that contains all ingredients
     * are stored as Strings
     * @return - the ArrayList of ingredients
     */
    public static ArrayList<String> getIngredients() {
        return ingredientsList;
    }

}
