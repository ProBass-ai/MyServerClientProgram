package Store.Cart;

import Store.SaleManagement.Sale;

import java.util.ArrayList;

public class Cart {

    ArrayList<Sale> itemsOnCart = new ArrayList<>();

    public void addToCart(Sale item){
        this.itemsOnCart.add(item);
    }

    public ArrayList<Sale> getItemsOnCart() {
        return itemsOnCart;
    }

}
