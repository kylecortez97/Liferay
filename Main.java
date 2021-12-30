/**
 * Name: Kyle Kiyoshi Cortez
 * Email: kylecortez97@gmail.com
 * Project: Liferay - Technical Challenge
 */

public class Main {
  public static void main(String[] args) {
    for (String filename : args) {
      Basket myBasket = new Basket(filename);
      Receipt myReceipt = new Receipt(myBasket);

      myReceipt.printReceipt();
    }
  }
}