package Store.SaleManagement;

import Store.Products;


enum SaleStatus{

    PRODUCT_ON_SALE,
    CURRENTLY_AVAILABLE,
    CURRENTLY_UNAVAILABLE,
    PRODUCT_OUT_OF_STOCK,
    PRODUCT_AVAILABLE_SOON

}


public abstract class Sale implements Products {

    private final String productName;

    private final int productPrice;

    private final String productType;

    public Sale(String productType, String productName, int productPrice){

        this.productType = productType;
        this.productName = productName;
        this.productPrice = productPrice;

    }

    @Override
    public String getProductName() {
        return this.productName;
    }

    @Override
    public int getProductPrice() {
        return this.productPrice;
    }

    @Override
    public String getProductType() {
        return this.productType;
    }

}
