package pages;

public abstract class Util {
    public static String extractFirstLine(String input) {
        return input.substring(0, input.indexOf("\n"));
    }
}
