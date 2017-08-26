import java.util.ArrayList;

public class ProductListFactory {

    public ArrayList<Product> GenerateProductList(){

        ArrayList<Product> listOfProducts = new ArrayList<>();

        Product product1 = new Product();

        product1.price = 10;
        product1.name = "bag";
        product1.description = "change purse";

        Product product2 = new Product();
        product2.price = 15;
        product2.name = "used socks";
        product2.description = "Previously worn socks by NBA players";

        Product product3 = new Product();
        product3.price = 20;
        product3.name = "Holey towels";
        product3.description = "Towels that have been worn out and used for cleaning car parts";

        Product product4 = new Product();
        product4.price = 1;
        product4.name = "Used Q-tip";
        product4.description = "Q-tip was found the trash of Justin Beiber and other famous celebrities";

        Product product5 = new Product();
        product5.price = 2;
        product5.name = "Dog Toy";
        product5.description = "Slighly used dog toys with sqeakers missing";

        Product product6 = new Product();
        product6.price = 8;
        product6.name = "Not so Fun Sand";
        product6.description = "Sand that cannot be molded to hold its shape";

        Product product7 = new Product();
        product7.price = 5;
        product7.name = "T-shirts";
        product7.description = "Off white t-shirts that are no longer off white and may have sweat stains";

        Product product8 = new Product();
        product8.price = 12;
        product8.name = "DVD";
        product8.description = "Surprise DVD's which may have scratches and dings";

        Product product9 = new Product();
        product9.price = 100;
        product9.name = "Braces";
        product9.description = "Guaranteed previous user brushed and flossed regularly";

        Product product10 = new Product();
        product10.price = 15;
        product10.name = "Cat Litter";
        product10.description = "Used cat litter from local animal shelter";

        listOfProducts.add(product1);

        listOfProducts.add(product2);

        listOfProducts.add(product3);

        listOfProducts.add(product4);

        listOfProducts.add(product5);

        listOfProducts.add(product6);

        listOfProducts.add(product7);

        listOfProducts.add(product8);

        listOfProducts.add(product9);

        listOfProducts.add(product10);

        return listOfProducts;
    }
}
