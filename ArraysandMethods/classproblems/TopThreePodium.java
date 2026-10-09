import java.util.*;

public class TopThreePodium {

    static int[] findTopThreeScores(int[] scores) {
        int first = Integer.MIN_VALUE;
        int second = Integer.MIN_VALUE;
        int third = Integer.MIN_VALUE;

        for (int s : scores) {
            if (s >= first) {            // new highest (or tie for highest)
                third = second;
                second = first;
                first = s;
            } else if (s >= second) {    // new second
                third = second;
                second = s;
            } else if (s >= third) {     // new third
                third = s;
            }
        }
        return new int[]{first, second, third};
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(findTopThreeScores(new int[]{45, 82, 79, 90, 33, 90, 61})));
        // [90, 90, 82]
    }
}