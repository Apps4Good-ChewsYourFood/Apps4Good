package com.example.apps4good;
//import java.util.ArrayList;

/**
 * This class stores an ingredient as an individual object
 */
public class Ingredient {

    //Data
    private String name;

    //Constructor

    /**
     * This constructor creates an ingredient with a name. In the future it is possible
     * to include other identifying features such as allergens. Most likely, the Ingredient
     * Object would have the same name as the ingredient.
     */
    public Ingredient(String name) {
        this.name = name;
    }
    //Methods

    /**
     * Returns the name of the ingredient. getIngredient() made more sense than toString()
     * because a possible extension would be to add more data to a class
     */
    public String getIngredient() {
        return name;
    }

}
