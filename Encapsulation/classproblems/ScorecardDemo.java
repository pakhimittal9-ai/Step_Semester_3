class Scorecard {
    private final boolean[] results;
    private int recorded;

    Scorecard(int totalQuestions) {
        results = new boolean[totalQuestions];
        recorded = 0;
    }

    void recordAnswer(boolean correct) {
        if (recorded == results.length) {
            System.out.println("All answers already recorded");
            return;
        }
        results[recorded++] = correct;
    }

    int getScore() {
        int score = 0;
        for (int i = 0; i < recorded; i++) {
            if (results[i]) score++;
        }
        return score;
    }
}

public class ScorecardDemo {
    public static void main(String[] args) {
        Scorecard sc = new Scorecard(4);
        sc.recordAnswer(true);
        sc.recordAnswer(true);
        sc.recordAnswer(false);
        sc.recordAnswer(true);
        sc.recordAnswer(true);                          // ignored: over the limit

        System.out.println("Score: " + sc.getScore());  // 3
    }
}