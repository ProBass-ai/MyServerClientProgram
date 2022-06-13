package Store;


enum SaleStatus{

    PRODUCT_ON_SALE,
    CURRENTLY_AVAILABLE,
    CURRENTLY_UNAVAILABLE,
    PRODUCT_OUT_OF_STOCK,
    PRODUCT_AVAILABLE_SOON

}


public interface Products {

    String productName = null;

    int productPrice = 0;

    String productType = null;

}
