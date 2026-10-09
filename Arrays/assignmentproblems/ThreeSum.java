import java.util.*;

public class ThreeSum {

    public static int[][] threeSum(int[] nums) {
        int[] a = nums.clone();
        Arrays.sort(a);
        List<int[]> result = new ArrayList<>();
        int n = a.length;

        for (int i = 0; i < n - 2; i++) {
            if (a[i] > 0) break;
            if (i > 0 && a[i] == a[i - 1]) continue;       // skip duplicate first element

            int left = i + 1, right = n - 1;
            while (left < right) {
                int sum = a[i] + a[left] + a[right];
                if (sum == 0) {
                    result.add(new int[]{a[i], a[left], a[right]});
                    left++;
                    right--;
                    while (left < right && a[left] == a[left - 1]) left++;      // skip duplicate second
                    while (left < right && a[right] == a[right + 1]) right--;   // skip duplicate third
                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return result.toArray(new int[0][]);
    }

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(threeSum(new int[]{-1, 0, 1, 2, -1, -4})));  // [[-1, -1, 2], [-1, 0, 1]]
        System.out.println(Arrays.deepToString(threeSum(new int[]{0, 0, 0})));              // [[0, 0, 0]]
    }
}