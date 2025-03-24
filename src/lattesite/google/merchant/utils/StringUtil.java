package lattesite.google.merchant.utils;

/**
 * Various String utility methods.
 */
public final class StringUtil {

    /**
     * Checks whether a string is null or empty.
     *
     * @param s The string to be checked
     * @return Whether the string is null or empty
     */
    public static boolean isEmpty(String s) {
        if (s != null && s.equals("null")) {
            throw new RuntimeException("Something went seriously wrong. The string is literally \"null\".");
        }
        return s == null || s.trim().length() == 0;
    }

}
