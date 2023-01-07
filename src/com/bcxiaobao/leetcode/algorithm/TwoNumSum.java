package com.bcxiaobao.leetcode.algorithm;

import java.util.Arrays;
import java.util.HashMap;

/**
 * Created by IntelliJ IDEA.
 * User: lianxiaobao
 * Date: 2019-12-02
 * Time: 22:16
 *
 *
 *
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 *
 * 示例:
 *
 * 给定 nums = [2, 7, 11, 15], target = 9
 *
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 */
public class TwoNumSum {

    public static void main(String[] args) {

        int[] nums  = new int[]{3, 2, 4, 15};

        System.out.println(Arrays.toString(nums));

        System.out.println(Arrays.toString(twoSumOrdinary(nums, 6)));
        System.out.println(Arrays.toString(twoSumByMap(nums, 6)));
        System.out.println(Arrays.toString(twoSumOrd(nums, 6)));


    }


    public static int[] twoSumOrdinary(int[] nums, int target) {
        int[] num = new int[2];
        for (int i = 0; i <nums.length ; i++) {
            for (int j = nums.length-1; j >i ; j--) {
                if((nums[i]+ nums[j]) == target){
                    num[0] = i;
                    num[1] = j;
                    return num;
                }
            }
        }
        return num;
    }

    public static int[] twoSumOrd(int[] nums, int target){
        int[] num = new int[2];

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target){
                    num[0] = i;
                    num[1] = j;
                    return num;
                }
            }
        }
        return num;
    }


    /**
     * leetcode 测试性能提高十倍
     * @param nums
     * @param target
     * @return
     */
    public static  int[] twoSumByMap(int[] nums,int target){
        int[] num = new int[2];
        // 建立k-v ，一一对应的哈希表
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        for(int i = 0; i < nums.length; i++){
            if(map.containsKey(nums[i])){
                num[0] = i;
                num[1] = map.get(nums[i]);
                return num;
            }
            // 将数据存入 key为补数 ，value为下标
            map.put(target-nums[i], i);
        }
        return num;
    }


    public static Long now(){
        long l = System.currentTimeMillis();
        return l;
    }


}
