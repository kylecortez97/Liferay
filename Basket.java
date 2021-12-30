import java.io.*;
import java.util.*;

public class Basket {
  ArrayList<Item> myItems;

  public Basket(String filename) {
    myItems = addItems(filename);
  }

  private ArrayList<Item> addItems(String filename) {
    ArrayList<Item> myItems = new ArrayList<Item>();

    try {
      File myFile = new File(filename);
      Scanner myScanner = new Scanner(myFile);

      while (myScanner.hasNextLine()) {
        String line = myScanner.nextLine();
        Item myItem = splitLine(line);

        myItems.add(myItem);
      }

      myScanner.close();
    } catch (Exception e) {
      System.out.println("An Error Occurred.");
      e.printStackTrace();
    }

    return myItems;
  }

  private Item splitLine(String line) {
    String name = line.substring(0, line.lastIndexOf(" at"));
    double price = Double.parseDouble(line.substring(line.lastIndexOf(" ")));

    Item myItem = new Item(name, price);

    return myItem;
  }
}