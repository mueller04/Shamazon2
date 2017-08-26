import java.util.ArrayList;
import java.util.Scanner;

public class ProductSelectScreen {

    Scanner sc = new Scanner(System.in);

    public void select(ArrayList<Product> productList, Cart cart) {
        productSelection(productList, cart);
    }

    private void productSelection(ArrayList<Product> productList, Cart cart) {

        Product selectedProduct = null;
        boolean keepRunning = true;

        while (keepRunning) {

            if (selectedProduct == null) {
                listEachProduct(productList);
            }

            if (selectedProduct != null) {
                System.out.println("You Have Currently Selected:\n" + selectedProduct.name + " - " + selectedProduct.description + "\n");
                cart.manageCart(selectedProduct);
                selectedProduct = null;
            } else {
                System.out.println("Pick a number to see a products description. Or press 0 to exit product selection");

                int itemNumber = sc.nextInt();
                itemNumber = itemNumber - 1;

                if (itemNumber == -1) {
                    keepRunning = false;
                    System.out.println("Exiting Product Selection.\n");
                } else {
                    selectedProduct = productList.get(itemNumber);
                }
            }
        }
    }

    private void listEachProduct(ArrayList<Product> productList) {

        int numericalIndexForList = 0;

        for (Product currentProduct : productList){

            String name = currentProduct.name;
            double price = currentProduct.price;

            numericalIndexForList = numericalIndexForList + 1;

            System.out.println(numericalIndexForList + " - $"+ price + " " + name + "\n");
        }
    }
}


