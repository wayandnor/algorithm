/**
 * @version 1.0
 * @author: Nor Way
 * @description:
 * @date 2023/1/19 12:41
 */

/**
 * 给定一个数组nums，将其划分为两个连续子数组left和right，使得：
 * left中的每个元素都小于或等于right中的每个元素。
 * left 和right都是非空的。
 * left 的长度要尽可能小。
 * 在完成这样的分组后返回left的长度。
 * 用例可以保证存在这样的划分方法。
 */
public class PartitionDisjoint {
    public static void main(String[] args) {
        int[] array = {1, 1};
        int i = partitionDisjoint(array);
        System.out.println(i);
    }

    public static int partitionDisjoint(int[] nums) {
        int len = nums.length;
        int[] minRight = new int[len];
        int rMin = nums[len - 1];
        for (int i = len - 1; i >= 0; i--) {
            rMin = Math.min(rMin, nums[i]);
            minRight[i] = rMin;
        }

        int leftMax = nums[0];
        int rLen = 0;
        for (int i = 1; i <= len - 1; i++) {
            if (leftMax <= minRight[i]) {
                rLen = i;
                break;
            }
            leftMax = Math.max(leftMax, nums[i]);
        }

        return rLen;
    }
}
