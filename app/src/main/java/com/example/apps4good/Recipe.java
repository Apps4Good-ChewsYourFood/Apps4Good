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
    private String instructions;
    private ArrayList<Ingredient> ingredients;

    // Constructor
    /**
     * Default constructor. Constructs a Recipe object
     */
    public Recipe() {
        this.ingredients = new ArrayList<Ingredient>();
    }

    /**
     * Constructor. Constructs a Recipe object with a specified
     */
    public Recipe(String instructions) {
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
     * @param instructions the instructions to set
     */
    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

    /**
     * @return the ingredients
     */
    public ArrayList<Ingredient> getIngredients() {
        return ingredients;
    }

    /**
     * @param ingredients the ingredients to set
     */
    public void setIngredients(ArrayList<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

}
