package Store.SaleManagement;


import Store.Cart.Cart;

public class PreOrder extends Sale {

    public void sendToCart(Cart cart){
        cart.addToCart(this);
    }


    public PreOrder(String productType, String productName, int productPrice) {

        super(productType, productName, productPrice);

    }

}
