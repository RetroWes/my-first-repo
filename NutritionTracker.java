import java.util.Scanner;
import java.util.ArrayList;

class NutritionTracker {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // The total amount of calories, fiber, iron content, and vitamin C in all
        // servings of all food items.
        double totalCalories = 0;
        double totalFiber = 0;
        double totalIronContent = 0;
        double totalVitaminC = 0;

        System.out.println("Congratulations on choosing some vegetables!");
        // Create an array for vegetables so that their nutrients can be totalled.
        ArrayList<VegetableItem> vegetableList = new ArrayList<>();
      
        // Creates a LeafyGreen Vegetable Object and adds it to vegetableList.
        System.out.println("Enter details for a leafy green vegetable:");
        LeafyGreens newLeafyGreensObj = new LeafyGreens();
        LeafyGreens leafyGreenObj = getInputVegetable(newLeafyGreensObj);
        vegetableList.add(0, leafyGreenObj);
        totalIronContent += leafyGreenObj.getIronContent();

        // Creates a RootVegetable Object and adds it to vegetableList.
        System.out.println("Enter details for a root vegetable:");
        RootVegetables newRootVegetableObj = new RootVegetables();
        RootVegetables rootVegetableObj = getInputVegetable(newRootVegetableObj);
        vegetableList.add(0, rootVegetableObj);
        totalVitaminC += rootVegetableObj.getVitaminC();

        for (VegetableItem vegetable : vegetableList) {
            totalCalories += vegetable.getCalories(vegetable.getNumOfServings());
            totalFiber += vegetable.getFiber();
        }

        // Initializes an array with enough space for desired number of food items.
        // The do-while loop handles invalid input.
        System.out.print("How many food items would you like to input? ");
        int numOfFoodItems = 0;
        boolean validInputDetected = false;
        do {
            try {
                numOfFoodItems = scanner.nextInt();
            } catch (Exception e) {
                System.out.println("ERROR: Input must be a positive integer");
                scanner.nextLine();
                continue;
            }
            validInputDetected = true;
        } while (!validInputDetected);
        scanner.nextLine();
        FoodItem[] foodList = new FoodItem[numOfFoodItems];

        // Creates {numOfFoodItems} FoodItem objects and allows user to enter and
        // display their nutritional values.
        for (int i = 0; i < foodList.length; i++) {
            System.out.print("Enter the name of the food item: ");
            String name = scanner.nextLine().toLowerCase();

            nutritionInfoPrompt("fat", name, "grams");
            double fat = getInputValue(scanner.nextLine());

            nutritionInfoPrompt("carbohydrates", name, "grams");
            double carbs = getInputValue(scanner.nextLine());

            nutritionInfoPrompt("protein", name, "grams");
            double protein = getInputValue(scanner.nextLine());

            // Each nutrient's entered gram count will be scaled by a factor of
            // {numOfServings}
            System.out.print("Enter the number of servings: ");
            double numOfServings = getInputValue(scanner.nextLine());

            // Stores data for each food object so that it may be accessed later.
            FoodItem foodObj = new FoodItem(name, fat, carbs, protein);
            foodList[i] = foodObj;

            // Adds the calories to the running total so that the total amount of calories
            // in the entire meal can be displayed at the end of the program.
            foodObj.setNumberOfServings(numOfServings);
            totalCalories += foodObj.getCalories(numOfServings);

            foodObj.printInfo();
            foodObj.printTotalCaloriesAndDominantMacro();
        }
        // Close scanner to prevent resource leak.
        scanner.close();

        // End-of-program message
        System.out.printf("Total combined calories for all food items: %.2f%n", totalCalories);
        System.out.printf("Total combined fiber for all food items: %.2f g%n", totalFiber);
        System.out.printf("Total combined iron content for all food items: %.2f mg%n", totalIronContent);
        System.out.printf("Total combined Vitamin C for all food items: %.2f mg%n", totalVitaminC);
        System.out.println("\nThank you for using the Nutrition Information System!");
    }

    // This getter includes error handling. Valid input will be requested until
    // either 0 or a positive number is entered. A different error message will be
    // displayed depending on the error.
    private static double getInputValue(String input) {
        double doubleValue = 0;
        boolean validInputDetected = false;

        while (!validInputDetected) {
            try {
                doubleValue = Double.parseDouble(input);
            } catch (Exception e) {
                System.out.println("ERROR: Input must be a number!");
                doubleValue = getInputValue(scanner.nextLine());
            }
            validInputDetected = true;
            break;
        }

        if (doubleValue >= 0) {
            return doubleValue;
        } else {
            System.out.println("ERROR: Input cannot be negative!");
            doubleValue = getInputValue(scanner.nextLine());
        }

        return doubleValue;
    }

    // Collects nutrient information specific to LeafyGreen object and passes it
    // into the LeafyGreen constructor.
    static LeafyGreens getInputVegetable(LeafyGreens vegetable) {
        System.out.print("Enter the name of the vegetable: ");
        String name = scanner.nextLine().toLowerCase();

        nutritionInfoPrompt("fat", name, "grams");
        double fat = getInputValue(scanner.nextLine());

        nutritionInfoPrompt("carbohydrates", name, "grams");
        double carbs = getInputValue(scanner.nextLine());

        nutritionInfoPrompt("protein", name, "grams");
        double protein = getInputValue(scanner.nextLine());

        nutritionInfoPrompt("fiber", name, "grams");
        double fiber = getInputValue(scanner.nextLine());

        nutritionInfoPrompt("iron content", name, "mg");
        double ironContent = getInputValue(scanner.nextLine());

        LeafyGreens vegetableObj = new LeafyGreens(name, fat, carbs, protein, fiber, ironContent);

        // Each nutrient's entered gram count will be scaled by a factor of
        // {numOfServings}
        System.out.print("Enter the number of servings: ");
        double numOfServings = getInputValue(scanner.nextLine());

        // Adds the calories to the running total so that the total amount of calories
        // in the entire meal can be displayed at the end of the program.
        vegetableObj.setNumberOfServings(numOfServings);

        vegetableObj.printInfo();

        return vegetableObj;
    }

    // Collects nutrient information specific to RootVegetable object and passes it
    // into the RootVegetable constructor.
    static RootVegetables getInputVegetable(RootVegetables vegetable) {
        System.out.print("Enter the name of the vegetable: ");
        String name = scanner.nextLine().toLowerCase();

        nutritionInfoPrompt("fat", name, "grams");
        double fat = getInputValue(scanner.nextLine());

        nutritionInfoPrompt("carbohydrates", name, "grams");
        double carbs = getInputValue(scanner.nextLine());

        nutritionInfoPrompt("protein", name, "grams");
        double protein = getInputValue(scanner.nextLine());

        nutritionInfoPrompt("fiber", name, "grams");
        double fiber = getInputValue(scanner.nextLine());

        nutritionInfoPrompt("vitamin C", name, "mg");
        double vitaminC = getInputValue(scanner.nextLine());

        RootVegetables vegetableObj = new RootVegetables(name, fat, carbs, protein, fiber, vitaminC);

        // Each nutrient's entered gram count will be scaled by a factor of
        // {numOfServings}
        System.out.print("Enter the number of servings: ");
        double numOfServings = getInputValue(scanner.nextLine());

        // Adds the calories to the running total so that the total amount of calories
        // in the entire meal can be displayed at the end of the program.
        vegetableObj.setNumberOfServings(numOfServings);

        vegetableObj.printInfo();

        return vegetableObj;
    }

    // Prompts the user to enter in a macronutrient count (in grams) of a food item.
    static void nutritionInfoPrompt(String nutrientName, String foodName, String measure) {
        System.out.print("Enter the amount of " + nutrientName + " in " + foodName + " (" + measure + "): ");
    }
}