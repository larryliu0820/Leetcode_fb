import java.util.*;

/**
 * Created by Larry Liu on 10/28/2017.
 * 127. Word Ladder
 */
public class p127 {
    int minLen = Integer.MAX_VALUE;
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        Map<String, Integer> map = new HashMap<>();
        map.put(beginWord, 1);
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        while (!queue.isEmpty()) {
            String curr = queue.poll();
            Set<String> neighbors = findNeighbor(curr, wordSet);
            for (String neighbor: neighbors) {
                if (!map.containsKey(neighbor)) {
                    queue.offer(neighbor);
                    map.put(neighbor, map.get(curr) + 1);
                    if (neighbor.equals(endWord)) return map.get(neighbor);
                }
            }
        }
        return 0;
    }
    private Set<String> findNeighbor(String word, Set<String> wordList) {
        Set<String> neighbors = new HashSet<>();
        char[] arr = word.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            char backup = arr[i];
            for (int j = 0; j < 26; j++) {
                if ('a' + j == backup) continue;
                arr[i] = (char)('a' + j);
                String newStr = String.valueOf(arr);
                if (wordList.contains(newStr) && !neighbors.contains(newStr))
                    neighbors.add(newStr);
            }
            arr[i] = backup;
        }
        return neighbors;
    }

    public static void main(String[] args) {
        p127 sol = new p127();
        String[] wordList = new String[]{"hot","dot","dog","lot","log","cog"};
        System.out.println(sol.ladderLength("hit", "cog", Arrays.asList(wordList) ));
    }
}
