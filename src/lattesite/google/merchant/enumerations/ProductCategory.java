package lattesite.google.merchant.enumerations;

/**
 * Based on https://www.google.com/basepages/producttype/taxonomy-with-ids.en-US.txt
 */

public enum ProductCategory {

    ELECTRONICS_ELECTRONICS_ACCESSORIES_COMPUTER_ACCESSORIES_MOUSE_PADS("Electronics > Electronics Accessories > Computer Accessories > Mouse Pads", 1993),
    APPAREL_ACCESSORIES_CLOTHING_DRESSES("Apparel & Accessories > Clothing > Dresses", 2271);

    private final String tree;
    private final int id;

    ProductCategory(String tree, int id) {
        this.tree = tree;
        this.id = id;
    }

    public String getTree() {
        return this.tree;
    }

    public int getID() {
        return this.id;
    }

}
