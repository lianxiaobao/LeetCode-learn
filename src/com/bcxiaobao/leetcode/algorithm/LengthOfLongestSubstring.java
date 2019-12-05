package com.bcxiaobao.leetcode.algorithm;

/**
 * Created by IntelliJ IDEA.
 * User: lianxiaobao
 * Date: 2019-12-05
 * Time: 23:46
 */

/**
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 * 示例 1:
 *
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 *
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 *
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 */
public class LengthOfLongestSubstring {

    public static void main(String[] args) {
        int substring = lengthOfLongestSubstring("bbbbb");
        System.out.println(substring);
    }

    public static int lengthOfLongestSubstring(String s) {

        char[] model = s.toCharArray();
        int maxLenth = 0;
        int leftModel = 0;
        for (int i = 0; i < model.length; i++) {
            for (int j = leftModel; j < i; j++) {
                if(model[i] == model[j]){
                    //i - leftModel 表示的是一个不重复子串的长度，
                    // 然后拿这个长度跟maxLength比一下，
                    // 看它是不是比maxLength还要长，
                    // 如果是的话，maxLength就要更新
                    maxLenth = Math.max(maxLenth,i-leftModel);
                    leftModel = j+1;
                    break;
                }
            }
        }
        return Math.max(model.length-leftModel,maxLenth);
    }

}
