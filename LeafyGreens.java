public class LeafyGreens extends VegetableItem {
  private double ironContent;

  // LeafyGreens Constructor
  LeafyGreens(String name, double fat, double carbs, double protein, double fiber, double ironContent) {
    super(name, fat, carbs, protein, fiber);
    this.ironContent = ironContent;
  }

  LeafyGreens() {

  }

  // Extends the printInfo method in the VegetableItem class to include this
  // classes relevant nutrients.
  @Override
  public void printInfo() {
    super.printInfo();

    System.out.printf(" Iron Content: %.2f mg\n", getIronContent());

    super.printTotalCaloriesAndDominantMacro();
  }

  // Getters for class specific nutrients
  public double getIronContent() {
    return ironContent;
  }
}
