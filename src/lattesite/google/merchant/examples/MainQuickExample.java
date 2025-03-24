package lattesite.google.merchant.examples;

import lattesite.google.merchant.enumerations.*;
import lattesite.google.merchant.interfaces.Product;
import lattesite.google.merchant.services.GoogleMerchantService;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class MainQuickExample {

    public static void main(String[] args) {

        // Initiate the service
        String storeTitle = "My awesome online store!";
        String storeDescription = "Here you can buy the next big thing!";
        String storeLink = "https://www.store.com";

        GoogleMerchantService googleMerchantService = new GoogleMerchantService(
                storeTitle,
                storeDescription,
                storeLink
        );

        // Create a list of products
        List<MyProduct> products = new ArrayList<>();
        products.add(
                new MyProduct(
                        "Anna",
                        "sku_anna",
                        199
                )
        );
        products.add(
                new MyProduct(
                        "Steve",
                        "sku_steve",
                        149.99
                )
        );

        // Generate the XML feed
        String xml = googleMerchantService.generate(products);

        // Prints the XML
        System.out.println(xml);
/*

<?xml version='1.0' encoding='UTF-8'?>
<rss xmlns:g="http://base.google.com/ns/1.0" version="3.0">
  <channel>
    <title>My awesome online store!</title>
    <description>Here you can buy the next big thing!</description>
    <link>https://www.store.com</link>
    <item>
      <g:id>sku_anna</g:id>
      <g:sku>sku_anna</g:sku>
      <g:title><![CDATA[Anna]]></g:title>
      <g:link><![CDATA[https://www.store.com/product/sku_anna/]]></g:link>
      <g:brand><![CDATA[My Brand]]></g:brand>
      <g:description><![CDATA[This is a super fancy dress!]]></g:description>
      <g:condition>new</g:condition>
      <g:adult>false</g:adult>
      <g:age_group>adult</g:age_group>
      <g:availability>in_stock</g:availability>
      <g:price>199 USD</g:price>
      <g:image_link><![CDATA[https://www.store.com/product/sku_anna/1.jpg]]></g:image_link>
      <g:additional_image_link><![CDATA[https://www.store.com/product/sku_anna/2.jpg]]></g:additional_image_link>
      <g:additional_image_link><![CDATA[https://www.store.com/product/sku_anna/3.jpg]]></g:additional_image_link>
      <g:google_product_category>2271</g:google_product_category>
      <g:product_type>Product > Women > Dresses</g:product_type>
      <g:color>Green</g:color>
      <g:gender>female</g:gender>
      <g:material>Cotton</g:material>
      <g:size>XL</g:size>
      <g:size_system>EU</g:size_system>
      <g:product_length>160 cm</g:product_length>
      <g:product_height>240 grams</g:product_height>
      <g:product_detail>
        <g:attribute_name><![CDATA[Sleeves]]></g:attribute_name>
        <g:attribute_value><![CDATA[Sleeveless]]></g:attribute_value>
      </g:product_detail>
    </item>
    <item>
      <g:id>sku_steve</g:id>
      <g:sku>sku_steve</g:sku>
      <g:title><![CDATA[Steve]]></g:title>
      <g:link><![CDATA[https://www.store.com/product/sku_steve/]]></g:link>
      <g:brand><![CDATA[My Brand]]></g:brand>
      <g:description><![CDATA[This is a super fancy dress!]]></g:description>
      <g:condition>new</g:condition>
      <g:adult>false</g:adult>
      <g:age_group>adult</g:age_group>
      <g:availability>in_stock</g:availability>
      <g:price>149.99 USD</g:price>
      <g:image_link><![CDATA[https://www.store.com/product/sku_steve/1.jpg]]></g:image_link>
      <g:additional_image_link><![CDATA[https://www.store.com/product/sku_steve/2.jpg]]></g:additional_image_link>
      <g:additional_image_link><![CDATA[https://www.store.com/product/sku_steve/3.jpg]]></g:additional_image_link>
      <g:google_product_category>2271</g:google_product_category>
      <g:product_type>Product > Women > Dresses</g:product_type>
      <g:color>Green</g:color>
      <g:gender>female</g:gender>
      <g:material>Cotton</g:material>
      <g:size>XL</g:size>
      <g:size_system>EU</g:size_system>
      <g:product_length>160 cm</g:product_length>
      <g:product_height>240 grams</g:product_height>
      <g:product_detail>
        <g:attribute_name><![CDATA[Sleeves]]></g:attribute_name>
        <g:attribute_value><![CDATA[Sleeveless]]></g:attribute_value>
      </g:product_detail>
    </item>
  </channel>
</rss>

 */

    }

    public static class MyProduct implements Product {

        private final String title;
        private final String sku;
        private final double price;

        public MyProduct(String title, String sku, double price) {
            this.title = title;
            this.sku = sku;
            this.price = price;
        }

        @Override
        public String getID() {
            return this.sku;
        }

        @Override
        public String getSKU() {
            return this.sku;
        }

        @Override
        public String getGroupID() {
            return null;
        }

        @Override
        public String getEAN() {
            return null;
        }

        @Override
        public String getDescription() {
            return "This is a super fancy dress!";
        }

        @Override
        public String getTitle() {
            return this.title;
        }

        @Override
        public String getCurrency() {
            return "USD";
        }

        @Override
        public double getPrice() {
            return this.price;
        }

        @Override
        public List<String> getImageURLs() {
            List<String> imageURLs = new ArrayList<>();
            imageURLs.add("https://www.store.com/product/" + this.getSKU() + "/1.jpg");
            imageURLs.add("https://www.store.com/product/" + this.getSKU() + "/2.jpg");
            imageURLs.add("https://www.store.com/product/" + this.getSKU() + "/3.jpg");
            return imageURLs;
        }

        @Override
        public ProductCategory getProductCategory() {
            return ProductCategory.APPAREL_ACCESSORIES_CLOTHING_DRESSES;
        }

        @Override
        public String getBrand() {
            return "My Brand";
        }

        @Override
        public String getLink() {
            return "https://www.store.com/product/" + this.getSKU() + "/";
        }

        @Override
        public ProductAvailability getAvailability() {
            return ProductAvailability.IN_STOCK;
        }

        @Override
        public Map<String, String> getProperties() {
            Map<String, String> properties = new LinkedHashMap<>();
            properties.put("Sleeves", "Sleeveless");
            return properties;
        }

        @Override
        public String getAvailabilityDate() {
            return null;
        }

        @Override
        public List<String> getTypes() {
            List<String> types = new ArrayList<>();
            types.add("Product > Women > Dresses");
            return types;
        }

        @Override
        public String getGTIN() {
            return null;
        }

        @Override
        public String getMPN() {
            return null;
        }

        @Override
        public Condition getCondition() {
            return Condition.NEW;
        }

        @Override
        public AgeGroup getAgeGroup() {
            return AgeGroup.ADULT;
        }

        @Override
        public boolean isAdult() {
            return false;
        }

        @Override
        public String getColor() {
            return "Green";
        }

        @Override
        public Gender getGender() {
            return Gender.FEMALE;
        }

        @Override
        public String getMaterial() {
            return "Cotton";
        }

        @Override
        public String getSize() {
            return "XL";
        }

        @Override
        public SizeSystem getSizeSystem() {
            return SizeSystem.EU;
        }

        @Override
        public String getProductLength() {
            return "160 cm";
        }

        @Override
        public String getProductHeight() {
            return null;
        }

        @Override
        public String getProductWidth() {
            return null;
        }

        @Override
        public String getProductWeight() {
            return "240 grams";
        }

    }

}