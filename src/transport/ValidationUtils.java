package transport;

public class ValidationUtils {
    public static String validOrDefault(String value, String defaultValue) {
        if (value == null || value.isEmpty()) {
            return value = defaultValue;
        } else {
            return value = value;
        }
    }
}
