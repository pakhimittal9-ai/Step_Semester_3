import java.util.Scanner;

public class TransactionReference {

    static String normalizeReference(String raw) {
        String trimmed = raw.trim();
        if (trimmed.length() < 3) {
            return trimmed.toUpperCase();
        }
        return trimmed.substring(0, 3).toUpperCase() + trimmed.substring(3);
    }

    static String validateAndFormat(String reference) {
        if (reference.length() != 14) {
            return "Invalid: wrong length, must be 14 characters";
        }
        for (int i = 0; i < 3; i++) {
            if (!Character.isLetter(reference.charAt(i))) {
                return "Invalid: bank code must be 3 letters";
            }
        }
        for (int i = 3; i < 14; i++) {
            if (!Character.isDigit(reference.charAt(i))) {
                return "Invalid: body must be 11 digits";
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("[").append(reference, 0, 3).append("] DATE: ")
                .append(reference, 3, 5).append("/")
                .append(reference, 5, 7).append("/")
                .append(reference, 7, 9)
                .append(" | SEQ: ").append(reference.substring(9));
        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter reference: ");
        String raw = sc.nextLine();
        String reference = normalizeReference(raw);
        System.out.println(validateAndFormat(reference));
        sc.close();
    }
}