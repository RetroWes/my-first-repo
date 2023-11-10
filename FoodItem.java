class FoodItem {
    protected String name;
    private double fat;
    private double carbs;
    private double protein;
    private double numOfServings;

    // Calorie count for each macronutrient
    static final double CALORIES_PER_GRAM_FAT = 9.0;
    static final double CALORIES_PER_GRAM_CARBS = 4.0;
    static final double CALORIES_PER_GRAM_PROTEIN = 4.0;

    // FoodItem Constructor
    public FoodItem(String name, double fat, double carbs, double protein) {
        this.name = name;
        this.fat = fat;
        this.carbs = carbs;
        this.protein = protein;
    }

    public FoodItem() {

    }

    // Summarizes all nutritional information for the entered food item.
    public void printInfo() {
        System.out.println("Nutritional information per serving of " + this.name + ": ");
        System.out.printf(" Fat: %.2f g\n", getFat());
        System.out.printf(" Carbohydrates: %.2f g\n", getCarbs());
        System.out.printf(" Protein: %.2f g\n", getProtein());
        // System.out.printf(" Total calories for %.2f servings of %s: %.2f%n",
        // getNumOfServings(), getName(),
        // getCalories(getNumOfServings()));
        // System.out.println(" Dominant Macronutrient: " + getDominantMacronutrient() +
        // "\n");
    }

    // Only call this function at the end of the overriding printInfo functions in
    // FoodItem's bottom-most subclasses.
    public void printTotalCaloriesAndDominantMacro() {
        System.out.printf(" Total calories for %.2f servings of %s: %.2f%n", getNumOfServings(), getName(),
                getCalories(getNumOfServings()));
        System.out.println(" Dominant Macronutrient: " + getDominantMacronutrient() + "\n");
    }

    // Getters & Setters
    // Returns number of calories in a given number of servings of a food item.
    public double getCalories(double numServings) {
        double fatCalories = getFat() * CALORIES_PER_GRAM_FAT;
        double carbCalories = getCarbs() * CALORIES_PER_GRAM_CARBS;
        double proteinCalories = getProtein() * CALORIES_PER_GRAM_PROTEIN;

        double totalCalories = fatCalories + carbCalories + proteinCalories;
        return totalCalories * numServings;
    }

    // Returns the macronutrient with the highest gram count within a food item.
    /*
     * Each macronutrient value is converted into an Object so that it may be stored
     * in the same array as the name of its corresponding macronutrient.
     * Typecasting Order: double -> Double -> String (store in array) -> double
     * (store in grams).
     */
    public String getDominantMacronutrient() {
        Double fat = getFat();
        Double carbs = getCarbs();
        Double protein = getProtein();

        int macroIndex = 0;
        int amountIndex = 1;

        String[][] nutrients = {
                { "Fat", fat.toString() },
                { "Carbohydrates", carbs.toString() },
                { "Protein", protein.toString() } };

        double largest = 0;
        int indexOfLargest = 0;
        for (int i = 0; i < nutrients.length; i++) {
            double grams = Double.parseDouble(nutrients[i][amountIndex]);

            if (grams > largest) {
                largest = grams;
                indexOfLargest = i;
            }
        }

        return nutrients[indexOfLargest][macroIndex];
    }

    public void setNumberOfServings(double num) {
        if (num >= 0) {
            this.numOfServings = num;
        }
    }

    public double getNumOfServings() {
        return this.numOfServings;
    }

    public String getName() {
        return this.name;
    }

    public double getFat() {
        return this.fat;
    }

    public double getCarbs() {
        return this.carbs;
    }

    public double getProtein() {
        return this.protein;
    }
}