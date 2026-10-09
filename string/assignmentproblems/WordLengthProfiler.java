import java.util.Scanner;

public class WordLengthProfiler {

    static void classifyWordLengths(String review) {
        int shortCount = 0;
        int mediumCount = 0;
        int longCount = 0;
        String[] words = review.trim().split("\\s+");
        for (String word : words) {
            String clean = word.replaceAll("[^A-Za-z]", "");
            int len = clean.length();
            if (len == 0) {
                continue;
            }
            if (len <= 4) {
                shortCount++;
            } else if (len <= 8) {
                mediumCount++;
            } else {
                longCount++;
            }
        }
        System.out.println("Short: " + shortCount + " | Medium: " + mediumCount + " | Long: " + longCount);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter review: ");
        String review = sc.nextLine();
        classifyWordLengths(review);
        sc.close();
    }
}