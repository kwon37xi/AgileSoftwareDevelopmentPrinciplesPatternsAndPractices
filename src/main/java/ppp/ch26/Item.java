package ppp.ch26;

public class Item {
    private Product itsProduct;
    private int itsQuantity;

    public Item(Product product, int quantity) {
        itsProduct = product;
        itsQuantity = quantity;
    }

    public Product getProduct() {
        return itsProduct;
    }

    public int getQuantity() {
        return itsQuantity;
    }
}
