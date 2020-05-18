package win.elegentjs.leetcode;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class LongestString {

    // 查找最长无重复字符的字符串，用一个TreeMap存储各种子串组合，用HashSet判定字符重复性
    public int lengthOfLongestSubstring(String s) {

        TreeMap<Integer, String> treeMap = new TreeMap<>((o1, o2) -> -1 * o1.compareTo(o2));
        Set<Character> set = new HashSet<>();

        StringBuilder sb = new StringBuilder();
        for (int index = 0; index < s.length(); index ++) {
            char c = s.charAt(index);

            if (!set.contains(c)) {
                sb.append(c);
                set.add(c);

            } else {
                set.clear();
                treeMap.put(sb.length(), sb.toString());
                sb.delete(0, sb.length());
            }
        }

        return treeMap.firstKey();
    }

    public static void main(String[] args) {
        Integer result = new LongestString().lengthOfLongestSubstring("3123asdqe123");
        System.out.println(result);
    }
}
