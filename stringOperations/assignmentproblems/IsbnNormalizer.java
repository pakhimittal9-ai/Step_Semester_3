import java.util.Scanner;

public class IsbnNormalizer {

    static String normalizeCode(String raw) {
        String trimmed = raw.trim();
        if (trimmed.length() < 3) {
            return trimmed.toUpperCase();
        }
        return trimmed.substring(0, 3).toUpperCase() + trimmed.substring(3);
    }

    static String validateAndFormat(String code) {
        if (code.length() != 13) {
            return "Invalid: wrong length, must be 13 characters";
        }
        for (int i = 0; i < 3; i++) {
            if (!Character.isLetter(code.charAt(i))) {
                return "Invalid: publisher code must be 3 letters";
            }
        }
        for (int i = 3; i < 13; i++) {
            if (!Character.isDigit(code.charAt(i))) {
                return "Invalid: body must be 10 digits";
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("[").append(code, 0, 3).append("] YEAR: ").append(code, 3, 7).append(" | CATALOG: ").append(code.substring(7));
        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter code: ");
        String raw = sc.nextLine();
        String code = normalizeCode(raw);
        System.out.println(validateAndFormat(code));
        sc.close();
    }
}