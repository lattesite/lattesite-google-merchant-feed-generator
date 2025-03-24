package lattesite.google.merchant.enumerations;

/**
 * Based on https://support.google.com/merchants/answer/6324448?hl=en
 */

public enum ProductAvailability {

    PREORDER("preorder"),
    BACKORDER("backorder"),
    IN_STOCK("in_stock"),
    OUT_OF_STOCK("out_of_stock");

    private final String code;

    ProductAvailability(String code) {
        this.code = code;
    }

    public String getCode() {
        return this.code;
    }

}
