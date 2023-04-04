package com.example.apps4good;
import java.util.ArrayList;

/**
 * This class stores the ingredients of a recipe in an ArrayList
 */
public class Ingredients {

    //Data
    public static ArrayList<String> ingredientsList;

    //Constructor

    /**
     * This constructor creates an Ingredients object that creates an ArrayList to store the
     * ingredients of a recipe
     */
    public Ingredients() {
        ingredientsList = new ArrayList<>();
    }
    //Methods
    /**
     * Allows the user to populate the ArrayList
     */
    /*
    public void addIngredient(String ingredient) {
        ingredientsList.add(ingredient);
    }
     */

    /**
     * Returns the ArrayList that contains the ingredient names of a recipe; the ingredients
     * are stored as Strings
     * @return - the ArrayList of ingredients
     * //also possible to return a string
     */
    public static ArrayList<String> getIngredients() {
        return ingredientsList;
    }

}
