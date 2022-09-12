import java.util.Arrays;

public class TwoSum {
    public static int[] arrayTask() {
        int[] nums = {3, 2, 4};
        int target = 6;
        for (var i = 0; i < nums.length; i++) {
            for (var x = i + 1; x < nums.length; x++) {
                if (nums[i] + nums[x] == target) {
                    return new int[]{i, x};
                }
            }
        } return nums;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(TwoSum.arrayTask()));
    }
}