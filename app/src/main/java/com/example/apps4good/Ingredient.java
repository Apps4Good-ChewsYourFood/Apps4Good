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
    // Methods
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
	 *         are different (including if the parameter is null)
	 */
	public boolean equals(Ingredient check) {
        if(check == null) {
            return false;
        }
        return name.equals(check.name);
	}

}

//This is an example
