import java.util.Arrays;

/**
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 * <p>
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 * <p>
 * 示例:
 * <p>
 * 给定 nums = [2, 7, 11, 15], target = 9
 * <p>
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 */
public class ArraySum {

    public static void main(String[] args) {
        int[] nums = {3, 2, 4};
        int target = 6;

        int[] total = twoSum(nums, target);
        System.out.println(Arrays.toString(total));
    }

    /**
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum(int[] nums, int target) {

        int[] total = new int[2];

        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (nums[i] + nums[j] == target && i != j) {
                    total[0] = i;
                    total[1] = j;

                    return total;
                } else {
                    continue;
                }
            }
        }

        return total;
    }
}
