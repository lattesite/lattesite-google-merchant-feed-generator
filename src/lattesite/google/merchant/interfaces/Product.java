package lattesite.google.merchant.interfaces;

import lattesite.google.merchant.enumerations.*;

import java.util.List;
import java.util.Map;

public interface Product {

    String getID();

    String getSKU();

    String getGroupID();

    String getEAN();

    String getDescription();

    String getTitle();

    String getCurrency();

    double getPrice();

    List<String> getImageURLs();

    ProductCategory getProductCategory();

    String getBrand();

    String getLink();

    ProductAvailability getAvailability();

    Map<String, String> getProperties();

    String getAvailabilityDate();

    List<String> getTypes();

    String getGTIN();

    String getMPN();

    Condition getCondition();

    AgeGroup getAgeGroup();

    boolean isAdult();

    String getColor();

    Gender getGender();

    String getMaterial();

    /**
     * Example: XL
     */

    String getSize();

    SizeSystem getSizeSystem();

    String getProductLength();

    String getProductHeight();

    String getProductWidth();

    String getProductWeight();
}
