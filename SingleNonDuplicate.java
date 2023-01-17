package algorithm;

/**
 * 给你一个仅由整数组成的有序数组，其中每个元素都会出现两次，唯有一个数只会出现一次。
 * 请你找出并返回只出现一次的那个数。
 * 你设计的解决方案必须满足 O(log n) 时间复杂度和 O(1) 空间复杂度
 * 
 * 输入: nums = [1,1,2,3,3,4,4,8,8]
 * 输出: 2
 */

/*
 * 解题思路
 * 1.因为已经排好序，要求查找元素，首先考虑使用二分查找
 * 2.不知道具体元素，但是其他元素都是成对出现，因此数组长度一定为奇数
 * 3.所以从数组中间划分，判断左右哪个相等，如果都不想等，则这个数就是要找的数
 * 4.如果有相等，判断哪边剩余数量为奇数，然后递归查找
 * 5.如果最终剩一个元素，也寻找成功
 */
public class SingleNonDuplicate {
    public int singleNonDup(int[] array) {
        if (array.length == 0) {
            return -1;
        }

        return find(array, 0, array.length - 1);
    }

    public static int find(int[] array, int startIndex, int endIndex) {
        if (startIndex == endIndex) {
            return array[startIndex];// 对应第5点
        }

        int midIndex = (endIndex - startIndex) / 2 + startIndex;
        if (array[midIndex] == array[midIndex - 1]) {
            int leftLen = midIndex - startIndex + 1;
            if (leftLen % 2 == 1) {
                return find(array, startIndex, midIndex);
            } else {
                return find(array, midIndex + 1, endIndex);
            }
        } else if (array[midIndex] == array[midIndex + 1]) {
            int leftLen = midIndex - startIndex;
            if (leftLen % 2 == 1) {
                return find(array, startIndex, midIndex - 1);
            } else {
                return find(array, midIndex, endIndex);
            }
        } else {
            return array[midIndex];// 对应3的边界条件
        }
    }
}
