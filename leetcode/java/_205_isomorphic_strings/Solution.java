package _205_isomorphic_strings;

import java.util.HashMap;
import java.util.Map;
/**
 * 同构字符串
 *
 * 给定两个字符串 s 和 t，判断它们是否是同构的。
 *
 * 如果 s 中的字符可以被替换得到 t ，那么这两个字符串是同构的。
 *
 * 所有出现的字符都必须用另一个字符替换，同时保留字符的顺序。两个字符不能映射到同一个字符上，但字符可以映射自己本身。
 *
 * 示例 1:
 *
 * 输入: s = "egg", t = "add"
 * 输出: true
 * 示例 2:
 *
 * 输入: s = "foo", t = "bar"
 * 输出: false
 * 示例 3:
 *
 * 输入: s = "paper", t = "title"
 * 输出: true
 * 说明:
 * 你可以假设 s 和 t 具有相同的长度。
 *
 */
public class Solution {

    /**
     * 1. 使用HashMap存储s和t字母的映射关系
     */
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        return isIsomorphicHelper(s, t) && isIsomorphicHelper(t, s);
    }

    private boolean isIsomorphicHelper(String s, String t) {
        int n = s.length();
        HashMap<Character, Character> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);
            if (map.containsKey(c1)) {
                if (map.get(c1) != c2) {
                    return false;
                }
            } else {
                map.put(c1, c2);
            }
        }
        return true;
    }

    /**
     * 2. 使用数组
     */
    public boolean isIsomorphic2 (String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] mapS = new int[128];
        int[] mapT = new int[128];
        for (int i = 0; i < s.length(); i++) {
            char sChar = s.charAt(i);
            char tChar = t.charAt(i);
            //判断当前映射值是否相同，如果还没有映射则添加
            if (mapS[sChar] != mapT[tChar]) {
                return false;
            } else if (mapS[sChar] == 0) {
                mapS[sChar] = i + 1;
                mapT[tChar] = i + 1;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isIsomorphic2("Za", "ab"));
    }

}
