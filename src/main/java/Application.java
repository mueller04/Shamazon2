import com.google.gson.Gson;

import java.io.*;
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
                    "\n5 - load cart from file" +
                    "\n6 - exit Shamazon");
            int selection = sc.nextInt();
            if (selection == 6) {
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
            } else if (selection ==5) {
                readFromFile();
            }
        }
        return keepRunningShamazon;
    }

    private void readFromFile() {
        Gson gson = new Gson();

        BufferedReader reader = getReaderForFile();

        String contentsStr = getFileAsString(reader);

        currentCart = gson.fromJson(contentsStr, Cart.class);

        for (Product product : currentCart.productsInCart) {
            System.out.println(product.name);
            System.out.println(product.description);
            System.out.println(product.price + "\n");
        }
    }

    private String getFileAsString(BufferedReader reader) {
        StringBuilder builder = new StringBuilder();
        String line;
        try {
            while ((line = reader.readLine()) != null) {
                builder.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return builder.toString();
    }

    private BufferedReader getReaderForFile() {
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader("cart.json"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return reader;
    }

    private void saveCart(ArrayList<Cart> cartList) {
        boolean cartToBeSaved = currentCart.manage();
        if (cartToBeSaved) {
            cartList.add(currentCart);

            Gson gson = new Gson();

            String cartJSON = gson.toJson(currentCart);

            writeToFile(cartJSON);
        }
    }

    private void writeToFile(String cartJSON) {
        try (Writer writer = new BufferedWriter(new OutputStreamWriter(
                new FileOutputStream("cart.json"), "utf-8"))) {

            writer.write(cartJSON);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void selectCart(ArrayList<Cart> cartList, Scanner sc)  {
        listCarts(cartList);
        System.out.println("select a cart");
        int cartIndex = sc.nextInt();
        if (cartList.size() >= cartIndex) {
            currentCart = cartList.get(cartIndex - 1);

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



