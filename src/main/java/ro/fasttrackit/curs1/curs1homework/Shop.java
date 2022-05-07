package ro.fasttrackit.curs1.curs1homework;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Shop {
    private final List<Product> products;
    private final Map<String, Long> inventory;

    public Shop(List<Product> products) {
        this.products = new ArrayList<>(products);
        this.inventory = products.stream()
                .collect(Collectors.groupingBy(Product::getName, Collectors.counting()));
    }

    public List<Product> getProducts() {
        return new ArrayList<>(products);
    }

    public Map<String, Long> getInventory() {
        return new HashMap<>(inventory);
    }

    public void addProduct(Product newProduct){
        if(isValid(newProduct)){
            this.products.add(newProduct);
            this.inventory.put(newProduct.getName(), 1L);
        } else {
            Long existingValue = this.inventory.get(newProduct.getName());
            this.inventory.replace(newProduct.getName(), existingValue+1L);
        }
    }

    public void buyProduct (String name, Integer amount){
        if (!inventory.containsKey(name)){
            throw new IllegalArgumentException("Product not found in the list");
        }
        if (inventory.get(name)<amount){
            throw new IllegalArgumentException("You can buy only " + inventory.get(name) + " pcs!");
        } else {
            Long existingValue = this.inventory.get(name);
            inventory.replace(name, existingValue-amount);
        }
    }


    private boolean isValid(Product newProduct) {
        if (this.products.contains(newProduct)) {
            return false;
        }
        return true;
    }
}
