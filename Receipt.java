import java.util.*;

public class Receipt {
  final double BASIC_SALES_TAX_RATE = 0.10;
  final double IMPORT_SALES_TAX_RATE = 0.05;

  final String[] BOOK_PRODUCTS = { "book" };
  final String[] FOOD_PRODUCTS = { "chocolate bar", "box of chocolates" };
  final String[] MEDICAL_PRODUCTS = { "packet of headache pills" };
  final String[] IMPORT_PRODUCTS = { "imported" };

  ArrayList<Item> myItems;

  public Receipt(Basket myBasket) {
    this.myItems = myBasket.myItems;
  }

  public void printReceipt() {
    double totalSalesTaxAmount = 0.00;
    double totalCost = 0.00;

    for (Item myItem : this.myItems) {
      String name = myItem.name;
      double price = myItem.price;

      double currentSalesTaxRate = findSalesTaxRate(name);
      double currentSalesTaxAmount = ((currentSalesTaxRate * 100) * price) / 100;
      double roundedSalesTaxAmount = Math.ceil(currentSalesTaxAmount / 0.05) * 0.05;

      totalSalesTaxAmount += roundedSalesTaxAmount;
      totalCost += (price + roundedSalesTaxAmount);

      System.out.printf("%s: %.2f\n", name, price + roundedSalesTaxAmount);
    }

    System.out.printf("Sales Taxes: %.2f\n", totalSalesTaxAmount);
    System.out.printf("Total: %.2f\n\n", totalCost);
  }

  private double findSalesTaxRate(String name) {
    boolean isBook = isProduct(name, BOOK_PRODUCTS);
    boolean isFood = isProduct(name, FOOD_PRODUCTS);
    boolean isMedical = isProduct(name, MEDICAL_PRODUCTS);
    boolean isImport = isProduct(name, IMPORT_PRODUCTS);

    double currentSalesTaxRate = 0.00;

    if (!isBook && !isFood && !isMedical)
      currentSalesTaxRate += BASIC_SALES_TAX_RATE;
    
    if (isImport)
      currentSalesTaxRate += IMPORT_SALES_TAX_RATE;

    return currentSalesTaxRate;
  }

  private boolean isProduct(String name, String[] PRODUCTS) {
    for (String PRODUCT : PRODUCTS)
      if (name.contains(PRODUCT))
        return true;
    return false;
  }
}