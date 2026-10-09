import java.util.Scanner;

public class TypingAccuracy {

    static void checkTypingAccuracy(String original, String typed) {
        int matched = 0;
        int firstMismatch = -1;
        int total = original.length();
        for (int i = 0; i < total; i++) {
            if (original.charAt(i) == typed.charAt(i)) {
                matched++;
            } else if (firstMismatch == -1) {
                firstMismatch = i;
            }
        }
        double accuracy = total == 0 ? 100.0 : (matched * 100.0) / total;
        String tail = firstMismatch == -1
                ? "No Mismatches"
                : "First Mismatch at position " + (firstMismatch + 1) + " ('" + original.charAt(firstMismatch) + "' vs '" + typed.charAt(firstMismatch) + "')";
        System.out.printf("Matched: %d/%d | Accuracy: %.2f%% | %s%n", matched, total, accuracy, tail);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter original passage: ");
        String original = sc.nextLine();
        System.out.print("Enter typed text: ");
        String typed = sc.nextLine();
        if (original.length() != typed.length()) {
            System.out.println("Both strings must be of equal length");
        } else {
            checkTypingAccuracy(original, typed);
        }
        sc.close();
    }
}