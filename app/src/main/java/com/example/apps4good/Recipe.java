package com.example.apps4good;

import java.util.ArrayList;

/**
 * This Recipe object is capable of storing Ingredients that are used in a
 * certain recipe in an ArrayList and instructions on how to make the Recipe
 *
 * @author Venkat
 *
 */
public class Recipe {
    // Data
    private String name;
    private String instructions;
    private ArrayList<Ingredient> ingredients;

    // Constructor
    /**
     * Default constructor. Constructs a Recipe object
     */
    public Recipe() {
        this.ingredients = new ArrayList<Ingredient>();
    }

    public Recipe(String name) {
        this.name = name;
        this.ingredients = new ArrayList<Ingredient>();
    }

    /**
     * Constructor. Constructs a Recipe object with a specified instructions
     */
    public Recipe(String name, String instructions) {
        this.name = name;
        this.ingredients = new ArrayList<Ingredient>();
        this.instructions = instructions;
    }
    // Methods

    /**
     * Adds the given ingredient to the ingredients ArrayList
     */
    public void addIngredient(Ingredient i) {
        ingredients.add(i);
    }

    /**
     * Removes the last added ingredient from the recipe
     *
     * @return the removed Ingredient
     */
    public Ingredient removeIngredient() {
        return ingredients.remove(ingredients.size() - 1);
    }

    /**
     * @return the instructions
     */
    public String getInstructions() {
        return instructions;
    }

    /**
     * @return the ingredients
     */
    public ArrayList<Ingredient> getIngredients() {
        return ingredients;
    }

    /**
     *
     * @param index
     * @return the Ingredient specified by the index
     */
    public Ingredient getIngredient(int index) {
        return ingredients.get(index);
    }

    /** 
     *
     * @return the name of the Recipe
     */
    public String getName() {
        return name;
    }

    /**
     * @return the name of the Recipe object and the Ingredients for that recipe
     */
    @Override
    public String toString() {
        String output = name + ": ";
        for(int i = 0; i < ingredients.size(); i ++) {
            output += ingredients.get(i) + ", ";
        }
        output = output.substring(0, output.length() - 2);
        return output;
    }
}
