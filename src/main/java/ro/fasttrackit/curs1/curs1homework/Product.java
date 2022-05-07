package ro.fasttrackit.curs1.curs1homework;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Product {
    private final String name;
    private final int price;
    private final List<Category> categories;
    private final String description;

    private Product(ProductBuilder builder) {
        this.name = builder.name;
        this.price = builder.price;
        this.categories = builder.categories;
        this.description = builder.description;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public List<Category> getCategories() {
        return new ArrayList<>(categories);
    }

    public String getDescription() {
        return description;
    }

    public static class ProductBuilder {
        private String name;
        private int price;
        private List<Category> categories = new ArrayList<>();
        private String description;

        public ProductBuilder name(String name) {
            this.name = name;
            return this;
        }

        public ProductBuilder category(Category category) {
            this.categories.add(category);
            return this;
        }

        public ProductBuilder price(int price) {
            this.price = price;
            return this;
        }

        public ProductBuilder description(String description) {
            this.description = description;
            return this;
        }

        public Product build() {
            return new Product(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return price == product.price && Objects.equals(name, product.name) && Objects.equals(categories, product.categories) && Objects.equals(description, product.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price, categories, description);
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", categories=" + categories +
                ", description='" + description + '\'' +
                '}';
    }
}
