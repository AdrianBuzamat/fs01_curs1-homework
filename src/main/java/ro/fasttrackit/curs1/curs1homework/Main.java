package ro.fasttrackit.curs1.curs1homework;

import java.util.List;

import static ro.fasttrackit.curs1.curs1homework.Category.*;

public class Main {
    public static void main(String[] args) {
        List<Product> productList = List.of(
                new Product.ProductBuilder()
                        .name("TV")
                        .category(ELECTRONICS)
                        .price(350)
                        .description("Diagonal 85")
                        .build()
                , new Product.ProductBuilder()
                        .name("Dishwasher Whirlpool")
                        .category(ELECTRONICS)
                        .price(250)
                        .description("Large Capacity Dishwasher with 3rd Rack")
                        .build()
                , new Product.ProductBuilder()
                        .name("Dishwasher Whirlpool")
                        .category(ELECTRONICS)
                        .price(250)
                        .description("Large Capacity Dishwasher with 3rd Rack")
                        .build()
                , new Product.ProductBuilder()
                        .name("Skirt")
                        .category(CLOTHES)
                        .price(250)
                        .description("Blue Patchwork-Effect Cotton Denim")
                        .build()

       );

        Shop shop= new Shop(productList);
        System.out.println(shop.getInventory());
        Product productToAdd =  new Product.ProductBuilder()
                .name("Skirt")
                .category(CLOTHES)
                .price(250)
                .description("Blue Patchwork-Effect Cotton Denim")
                .build();

        shop.addProduct(productToAdd);

        System.out.println(shop.getInventory());

        shop.buyProduct("Skirt", 2);

        System.out.println(shop.getInventory());
    }
}
