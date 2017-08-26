import org.junit.Test;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Application {

    ArrayList<Cart> cartList = new ArrayList<>();
    Cart currentCart = new Cart();
    Scanner sc = new Scanner(System.in);

    public void start() {

        System.out.println("Starting Shamazon\n");

        ProductListFactory productListFactory = new ProductListFactory();
        ArrayList<Product> productList = productListFactory.GenerateProductList();

        ProductSelectScreen productSelectScreen = new ProductSelectScreen();

        boolean keepRunningShamazon = true;

        while (keepRunningShamazon) {
            keepRunningShamazon = mainMenu(keepRunningShamazon, cartList);

            if (keepRunningShamazon){
                productSelectScreen.select(productList, currentCart);
            }
        }
    }

    private boolean mainMenu(boolean keepRunningShamazon, ArrayList<Cart> cartList) {

        boolean keepRunning = true;

        while (keepRunning) {
            System.out.println("1 - go to product selection" +
                    "\n2 - manage your cart" +
                    "\n3 - create a new cart" +
                    "\n4 - select a cart" +
                    "\n5 - exit Shamazon");
            int selection = sc.nextInt();
            if (selection == 5) {
                keepRunningShamazon = false;
                keepRunning = false;
                System.out.println("Exiting Shamazon...");
            } else if (selection == 1) {
                keepRunning = false;
            } else if (selection == 2) {
                saveCart(cartList);
            } else if (selection == 3) {
                currentCart = new Cart();
                System.out.println("New Cart Created!\n");
            } else if (selection == 4) {
                selectCart(cartList, sc);
            }
        }
        return keepRunningShamazon;
    }

    private void saveCart(ArrayList<Cart> cartList) {
        boolean cartToBeSaved = currentCart.manage();
        if (cartToBeSaved) {
            cartList.add(currentCart);
        }
    }

    private void selectCart(ArrayList<Cart> cartList, Scanner sc)  {
        listCarts(cartList);
        System.out.println("select a cart");
        int cartIndex = sc.nextInt();
        if (cartList.size() >= cartIndex) {
            currentCart = cartList.get(cartIndex - 1);


//            JSONArray jsonArray = new JSONArray();
//            GSON gson = new GSON();


            try {
                FileWriter file = new FileWriter("./Files/cart.json");



            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

    private void listCarts(ArrayList<Cart> cartList) {
        int index = 1;
        for (Cart cart : cartList) {
            System.out.println("Cart " + index);
            index++;
        }
    }

}



