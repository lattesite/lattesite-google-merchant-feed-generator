package lattesite.google.merchant.enumerations;

public enum Gender {

    MALE("male"),
    FEMALE("female"),
    UNISEX("unisex");

    private final String code;

    Gender(String code) {
        this.code = code;
    }

    public String getCode() {
        return this.code;
    }

}
