package lattesite.google.merchant.enumerations;

/**
 * Based on https://support.google.com/merchants/answer/6324502?visit_id=638784220089169021-37800635&rd=1
 */

public enum SizeSystem {

    AU,
    BR,
    CN,
    DE,
    EU,
    FR,
    IT,
    JP,
    MEX,
    UK,
    US;

    public String getCode() {
        return this.name();
    }

}
