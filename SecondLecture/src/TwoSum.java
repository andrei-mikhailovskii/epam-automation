/* Unfortunately, I don't know how to pass an array as input,
so I solved the task, but "input" here is just a "nums" variable
with an array as a value, and "target" variable also has a preset value
 */
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