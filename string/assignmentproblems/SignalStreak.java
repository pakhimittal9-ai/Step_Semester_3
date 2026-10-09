import java.util.Scanner;

public class SignalStreak {

    static void findLongestStreak(String signalLog) {
        if (signalLog.isEmpty()) {
            System.out.println("Empty log");
            return;
        }
        char bestChar = signalLog.charAt(0);
        int bestLen = 1;
        int curLen = 1;
        for (int i = 1; i < signalLog.length(); i++) {
            if (signalLog.charAt(i) == signalLog.charAt(i - 1)) {
                curLen++;
            } else {
                curLen = 1;
            }
            if (curLen > bestLen) {
                bestLen = curLen;
                bestChar = signalLog.charAt(i);
            }
        }
        System.out.println("Longest Streak: '" + bestChar + "' repeated " + bestLen + " times");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter signal log: ");
        String log = sc.nextLine();
        findLongestStreak(log);
        sc.close();
    }
}