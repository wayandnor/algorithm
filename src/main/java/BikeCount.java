/*
 * 华为OD笔试第一题
 */

import java.util.Arrays;
import java.util.Date;
import java.util.Random;
public class BikeCount {
    public static void main(String[] args) {
        int limit = 5;

        // 测试数据生成
        Random random = new Random();
        int[] weights = new int[1000000];
        for (int i = 0; i < 1000000; i++) {
            int weight = random.nextInt(5) + 1;
            weights[i] = weight;
        }

        Date date = new Date();
        long start = date.getTime();

        int[] perWeight = {};
        perWeight = weights;
        int totalPersonCount = perWeight.length;

        int bikeCount = 0;
        Arrays.sort(perWeight);
        int leftPointer = 0;
        int rightPointer = totalPersonCount - 1;
        while(leftPointer <= rightPointer){
            if(leftPointer == rightPointer){
                bikeCount++;
                rightPointer--;
                break;
            }
            if(perWeight[leftPointer] + perWeight[rightPointer] <= limit){
                leftPointer++;
                rightPointer--;
                bikeCount++;
            }else{
                rightPointer--;
                bikeCount++;
            }
        }

        System.out.println(bikeCount);
        date = new Date();
        long endTime = date.getTime();
        System.out.println(endTime - start);
    }
}