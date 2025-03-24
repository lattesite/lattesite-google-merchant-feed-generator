package lattesite.google.merchant.services;

import lattesite.google.merchant.interfaces.Product;
import lattesite.google.merchant.utils.StringUtil;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GoogleMerchantService {

    private final String storeTitle;
    private final String storeDescription;
    private final String storeLink;
    private final Map<String, String> additionalNameSpaces;
    private final String indentation;
    private final String nl;

    /**
     * Creates a new service.
     *
     * @param storeTitle       Title of the store
     * @param storeDescription Short store description
     * @param storeLink        Weblink to the store
     */
    public GoogleMerchantService(
            String storeTitle,
            String storeDescription,
            String storeLink
    ) {
        this(storeTitle, storeDescription, storeLink, new HashMap<>(), "  ", "\n");
    }

    /**
     * Creates a new service.
     *
     * @param storeTitle           Title of the store
     * @param storeDescription     Short store description
     * @param storeLink            Weblink to the store
     * @param additionalNameSpaces If any additional name spaces should be added into the feed
     * @param nl                   New line character. Default is "\n"
     */
    public GoogleMerchantService(
            String storeTitle,
            String storeDescription,
            String storeLink,
            Map<String, String> additionalNameSpaces,
            String indentation,
            String nl
    ) {
        this.storeTitle = storeTitle;
        this.storeDescription = storeDescription;
        this.storeLink = storeLink;
        this.additionalNameSpaces = additionalNameSpaces;
        this.indentation = indentation;
        this.nl = nl;
    }

    public String generate(List<? extends Product> products) {

        String xml = "";
        xml += "<?xml version='1.0' encoding='UTF-8'?>" + this.nl;
        xml += "<rss xmlns:g=\"http://base.google.com/ns/1.0\" version=\"3.0\"";
        for (Map.Entry<String, String> additionalNameSpace : this.additionalNameSpaces.entrySet()) {
            xml += " xmlns:" + additionalNameSpace.getKey() + "=\"" + additionalNameSpace.getValue() + "\"";
        }
        xml += ">" + this.nl;
        xml += this.indentation.repeat(1) + "<channel>" + this.nl;
        xml += this.indentation.repeat(2) + "<title>" + this.storeTitle + "</title>" + this.nl;
        xml += this.indentation.repeat(2) + "<description>" + this.storeDescription + "</description>" + this.nl;
        xml += this.indentation.repeat(2) + "<link>" + this.storeLink + "</link>" + this.nl;

        for (Product product : products) {

            xml += this.indentation.repeat(2) + "<item>" + this.nl;
            xml += this.indentation.repeat(3) + "<g:id>" + product.getID() + "</g:id>" + this.nl;
            if (!StringUtil.isEmpty(product.getGroupID())) {
                xml += this.indentation.repeat(3) + "<g:item_group_id>" + product.getGroupID() + "</g:id>" + this.nl;
            }

            if (!StringUtil.isEmpty(product.getSKU())) {
                xml += this.indentation.repeat(3) + "<g:sku>" + product.getSKU() + "</g:sku>" + this.nl;
            }

            if (!StringUtil.isEmpty(product.getEAN())) {
                xml += this.indentation.repeat(3) + "<g:ean>" + product.getEAN() + "</g:ean>" + this.nl;
            }
            if (!StringUtil.isEmpty(product.getGTIN())) {
                xml += this.indentation.repeat(3) + "<g:gtin>" + product.getGTIN() + "</g:gtin>" + this.nl;
            }
            if (!StringUtil.isEmpty(product.getMPN())) {
                xml += this.indentation.repeat(3) + "<g:mpn>" + product.getMPN() + "</g:mpn>" + this.nl;
            }

            xml += this.indentation.repeat(3) + "<g:title><![CDATA[" + product.getTitle() + "]]></g:title>" + this.nl;
            xml += this.indentation.repeat(3) + "<g:link><![CDATA[" + product.getLink() + "]]></g:link>" + this.nl;
            xml += this.indentation.repeat(3) + "<g:brand><![CDATA[" + product.getBrand() + "]]></g:brand>" + this.nl;
            xml += this.indentation.repeat(3) + "<g:description><![CDATA[" + product.getDescription() + "]]></g:description>" + this.nl;
            xml += this.indentation.repeat(3) + "<g:condition>" + product.getCondition().getCode() + "</g:condition>" + this.nl;

            xml += this.indentation.repeat(3) + "<g:adult>" + product.isAdult() + "</g:adult>" + this.nl;
            xml += this.indentation.repeat(3) + "<g:age_group>" + product.getAgeGroup().getCode() + "</g:age_group>" + this.nl;

            xml += this.indentation.repeat(3) + "<g:availability>" + product.getAvailability().getCode() + "</g:availability>" + this.nl;
            if (!StringUtil.isEmpty(product.getAvailabilityDate())) {
                xml += this.indentation.repeat(3) + "<g:availability_date]>" + product.getAvailability().getCode() + "</g:availability>" + this.nl;
            }

            String price = product.getPrice() % 1 == 0 ? Integer.toString((int) product.getPrice()) : Double.toString(product.getPrice());
            xml += this.indentation.repeat(3) + "<g:price>" + price + " " + product.getCurrency() + "</g:price>" + this.nl;

            // Image links
            xml += this.indentation.repeat(3) + "<g:image_link><![CDATA[" + product.getImageURLs().get(0) + "]]></g:image_link>" + this.nl;
            // Additional image links
            for (int i = 1; i < product.getImageURLs().size(); i++) {
                xml += this.indentation.repeat(3) + "<g:additional_image_link><![CDATA[" + product.getImageURLs().get(i) + "]]></g:additional_image_link>" + this.nl;
            }
            xml += this.indentation.repeat(3) + "<g:google_product_category>" + product.getProductCategory().getID() + "</g:google_product_category>" + this.nl;

            for (String type : product.getTypes()) {
                xml += this.indentation.repeat(3) + "<g:product_type>" + type + "</g:product_type>" + this.nl;
            }

            xml += this.indentation.repeat(3) + "<g:color>" + product.getColor() + "</g:color>" + this.nl;
            xml += this.indentation.repeat(3) + "<g:gender>" + product.getGender().getCode() + "</g:gender>" + this.nl;
            xml += this.indentation.repeat(3) + "<g:material>" + product.getMaterial() + "</g:material>" + this.nl;
            xml += this.indentation.repeat(3) + "<g:size>" + product.getSize() + "</g:size>" + this.nl;
            xml += this.indentation.repeat(3) + "<g:size_system>" + product.getSizeSystem() + "</g:size_system>" + this.nl;

            if (!StringUtil.isEmpty(product.getProductLength())) {
                xml += this.indentation.repeat(3) + "<g:product_length>" + product.getProductLength() + "</g:product_length>" + this.nl;
            }
            if (!StringUtil.isEmpty(product.getProductWidth())) {
                xml += this.indentation.repeat(3) + "<g:product_width>" + product.getProductWidth() + "</g:product_width>" + this.nl;
            }
            if (!StringUtil.isEmpty(product.getProductHeight())) {
                xml += this.indentation.repeat(3) + "<g:product_height>" + product.getProductHeight() + "</g:product_height>" + this.nl;
            }
            if (!StringUtil.isEmpty(product.getProductWeight())) {
                xml += this.indentation.repeat(3) + "<g:product_height>" + product.getProductWeight() + "</g:product_height>" + this.nl;
            }

            if (product.getProperties() != null) {
                for (Map.Entry<String, String> entry : product.getProperties().entrySet()) {
                    xml += this.indentation.repeat(3) + "<g:product_detail>" + this.nl;
                    xml += this.indentation.repeat(3) + "  <g:attribute_name><![CDATA[" + entry.getKey() + "]]></g:attribute_name>" + this.nl;
                    xml += this.indentation.repeat(3) + "  <g:attribute_value><![CDATA[" + entry.getValue() + "]]></g:attribute_value>" + this.nl;
                    xml += this.indentation.repeat(3) + "</g:product_detail>" + this.nl;
                }
                xml += this.indentation.repeat(2) + "</item>" + this.nl;
            }
        }

        xml += this.indentation.repeat(1) + "</channel>" + this.nl;
        xml += "</rss>" + this.nl;

        return xml;

    }

}
