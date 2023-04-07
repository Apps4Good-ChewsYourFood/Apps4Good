package com.example.apps4good;

/**
 * This class stores an ingredient as an individual object
 *
 * @author shulinglin
 *
 */
public class Ingredient {

    // Data

    private String name;

    // Constructor

    /**
     * This constructor creates an ingredient with a name. In the future it is
     * possible to include other identifying features such as allergens. Most
     * likely, the Ingredient Object would have the same name as the ingredient.
     */
    public Ingredient(String name) {
        this.name = name;
    }

    /**
     * Returns the name of the ingredient a possible extension would be to add more
     * data to the ingredient class. Then we would have to decide if the toString()
     * includes this data.
     *
     * @return - the name of the ingredient
     */
    @Override
    public String toString() {
        return name;
    }

    /**
     * Checks if two Ingredients are the same
     *
     * @param check - the Ingredient the method is comparing this Ingredient to
     * @return - true if the Ingredient objects are the same; false if the objects
     *         are different
     */
    public boolean equals(Ingredient check) {
        if (name.equals(check.toString()))
            return true;
        return false;
    }

}