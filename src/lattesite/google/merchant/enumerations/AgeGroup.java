package lattesite.google.merchant.enumerations;

public enum AgeGroup {

    NEWBORN("newborn"),
    INFANT("infant"),
    TODDLER("toddler"),
    KIDS("kids"),
    ADULT("adult");

    private final String code;

    AgeGroup(String code) {
        this.code = code;
    }

    public String getCode() {
        return this.code;
    }

}
