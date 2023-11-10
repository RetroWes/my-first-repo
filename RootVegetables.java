public class RootVegetables extends VegetableItem {
    private double vitaminC;

    // RootVegetables Constructor
    RootVegetables(String name, double fat, double carbs, double protein, double fiber, double vitaminC) {
        super(name, fat, carbs, protein, fiber);
        this.vitaminC = vitaminC;
    }

    RootVegetables() {

    }

    // Extends the printInfo method in the VegetableItem class to include this
    // classes relevant nutrients.
    @Override
    public void printInfo() {
        super.printInfo();

        System.out.printf(" Vitamin C: %.2f mg\n", getVitaminC());

        super.printTotalCaloriesAndDominantMacro();
    }

    // Getters for class specific nutrients
    public double getVitaminC() {
        return vitaminC;
    }
}
