package com.frewen.algorithm.demo.strings;

/**
 * 给定一个字符串，你的任务是计算这个字符串中有多少个回文子串。
 *
 * 具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被视作不同的子串。
 *
 *
 * 示例 1：
 *
 * 输入："abc"
 * 输出：3
 * 解释：三个回文子串: "a", "b", "c"
 * 示例 2：
 *
 * 输入："aaa"
 * 输出：6
 * 解释：6个回文子串: "a", "a", "a", "aa", "aa", "aaa"
 *  
 *
 * 提示：
 *
 * 输入的字符串长度不会超过 1000 。
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/palindromic-substrings
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L647CountSubstringsTest {
    public int countSubstrings(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int len = s.length();
        if (len <= 1) {
            return 1;
        }
        int count = 0;
        for (int i = 0; i < len; i++) {
            for (int j = i; j < len; j++) {
                if (i == j) {
                    ++count;
                } else {
                    int gap = j - i;
                    for (int z = 0; z < gap / 2 + 1; z++) {
                        if (s.charAt(i + z) != s.charAt(j - z)) {
                            break;
                        } else {
                            if (z == gap / 2) {
                                ++count;
                            }
                            continue;
                        }

                    }
                }

            }
        }
        return count;
    }
}
