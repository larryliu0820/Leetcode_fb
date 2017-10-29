import java.util.*;

/**
 * Created by Larry Liu on 10/27/2017.
 * 49. Group Anagrams
 */
public class p049 {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new LinkedList<>();
        Map<String, List<String>> map = new HashMap<>();

        for (String str: strs) {
            String converted = convert(str);
            map.putIfAbsent(converted, new LinkedList<>());
            map.get(converted).add(str);
        }

        res.addAll(map.values());
        return res;
    }

    private String convert(String str) {
        int[] arr = new int[26];
        for (char c: str.toCharArray()) arr[c-'a']++;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            if (arr[i] > 0) {
                char[] chars = new char[arr[i]];
                Arrays.fill(chars, (char)(i+'a'));
                sb.append(chars);
            }
        }
        return sb.toString();
    }
}
