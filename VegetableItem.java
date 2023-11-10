public class VegetableItem extends FoodItem {
    private double fiber;

    // VegetableItem Constructor
    VegetableItem(String name, double fat, double carbs, double protein, double fiber) {
        super(name, fat, carbs, protein);
        this.fiber = fiber;
    }

    VegetableItem() {

    }

    // Extends the printInfo method in the FoodItem class to include this classes
    // relevant nutrients.
    @Override
    public void printInfo() {
        super.printInfo();

        System.out.printf(" Fiber: %.2f g\n", getFiber());
    }

    // Getters for class specific nutrients
    double getFiber() {
        return this.fiber;
    }
}
