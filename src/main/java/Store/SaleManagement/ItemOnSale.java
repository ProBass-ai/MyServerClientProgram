package Store.SaleManagement;

import Store.Cart.Cart;

public class ItemOnSale extends Sale {

    public void sendToCart(Cart cart){
        cart.addToCart(this);
    }


    public ItemOnSale(String productType, String productName, int productPrice) {

        super(productType, productName, productPrice);

    }

}
