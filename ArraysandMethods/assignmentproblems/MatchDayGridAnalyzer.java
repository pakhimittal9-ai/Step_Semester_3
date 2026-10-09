public class MatchDayGridAnalyzer {

    static double rowAverage(int[] row) {
        if (row.length == 0) return 0;
        int sum = 0;
        for (int runs : row) {
            sum += runs;
        }
        return (double) sum / row.length;
    }

    static String classifyMatches(int[][] runsPerOver, int threshold) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < runsPerOver.length; i++) {
            if (i > 0) sb.append(" | ");
            String label = rowAverage(runsPerOver[i]) >= threshold ? "Power Surge" : "Normal";
            sb.append("Match ").append(i).append(": ").append(label);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        int[][] grid = {
            {4, 6, 8},
            {10, 12, 14},
            {2, 3, 1}
        };
        System.out.println(classifyMatches(grid, 8));
        // Match 0: Normal | Match 1: Power Surge | Match 2: Normal
    }
}