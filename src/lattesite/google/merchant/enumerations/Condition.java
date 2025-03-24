package lattesite.google.merchant.enumerations;

public enum Condition {

    NEW("new"),
    REFURBISHED("refurbished"),
    USED("used");

    private final String code;

    Condition(String code) {
        this.code = code;
    }

    public String getCode() {
        return this.code;
    }

}
