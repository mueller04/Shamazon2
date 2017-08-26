import java.util.ArrayList;
import java.util.Scanner;

public class Cart {

    ArrayList<Product> productsInCart = new ArrayList<>();
    Scanner sc = new Scanner(System.in);

    public void manageCart(Product productSelected) {

        boolean selectionInvalid = false;

        do {
            System.out.println("Press 1 to add to cart or 2 to return to the menu");

            int option = sc.nextInt();

            if (option == 3) {

                for (Product product : productsInCart) {
                    System.out.println(product.name + " : " + product.price);
                }


            } else if (option == 2) {
                //do nothing which goes back to productSelection
            } else if (option == 1) {
                System.out.println("item added!\n");
                Util.sleep();
                productsInCart.add(productSelected);
                selectionInvalid = false;

            } else if (option < 1 || option > 2) {
                selectionInvalid = true;
            }

        } while (selectionInvalid);
    }

    boolean manage() {
        boolean keepRunning = true;
        boolean cartToBeSaved = false;

        while (keepRunning) {
            System.out.println("1 - list of products in cart" +
                    "\n2 - remove product" +
                    "\n3 - order total" +
                    "\n4 - save cart" +
                    "\n5 - exit cart management\n");
            int option = sc.nextInt();

            if (option == 1) {
                listProducts();
            } else if (option == 2) {
                removeProduct();
            } else if (option == 3) {
                viewOrderTotal();
            } else if (option == 4) {
                cartToBeSaved = true;
                System.out.println("Cart saved!\n");
                return  cartToBeSaved;
            } else {
                keepRunning = false;
            }
        }
        return false;
    }

    private void removeProduct() {
        listProducts();
        System.out.println("enter number to select product to delete");
        int productIndex = sc.nextInt();
        productsInCart.remove(productIndex - 1);
    }

    private void viewOrderTotal() {
        double orderTotal = 0;
        for (Product product : productsInCart) {
            orderTotal += product.price;
        }
        System.out.println("product total: " + Util.formatCurrency(orderTotal));

        double tax = orderTotal * .07;
        System.out.println("tax: " + Util.formatCurrency(tax));

        double shipping = 2 + 0.5 * productsInCart.size();
        System.out.println("shipping: " + Util.formatCurrency(shipping));


        orderTotal += tax + shipping;

        System.out.println("order total: \n" + Util.formatCurrency(orderTotal) + "\n");
    }

    private void listProducts() {
        int index = 1;
        for (Product product : productsInCart) {
            System.out.println(index + " " + product.name + " : " + Util.formatCurrency(product.price) + "\n");
            index++;
        }
    }
}
