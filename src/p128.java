import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by mengwliu on 10/30/17
 * 128. Longest Consecutive Sequence
 */
public class p128 {
    public int longestConsecutive(int[] nums) {
        Map<Integer, int[]> map = new HashMap<>();
        Set<Integer> set = new HashSet<>();
        int max = 0;

        for (int num: nums) {
            if (set.contains(num)) continue;
            if (!map.containsKey(num)) {
                int[] left = map.getOrDefault(num-1, new int[]{0, 0});
                left[1] = 1;
                int[] right = map.getOrDefault(num+1, new int[]{0, 0});
                right[0] = 1;
                map.put(num-1, left);
                map.put(num+1, right);
                max = Math.max(max, 1);
            } else {
                int[] width = map.get(num);
                // go update the other boundary
                if (width[0] != 0) map.get(num-width[0]-1)[1] += width[1] + 1;
                if (width[1] != 0) map.get(num+width[1]+1)[0] += width[0] + 1;

                // create new boundary
                if (width[0] == 0) {
                    map.putIfAbsent(num-1, new int[]{0, 0});
                    map.get(num-1)[1] += width[1] + 1;
                } else if (width[1] == 0) {
                    map.putIfAbsent(num+1, new int[]{0, 0});
                    map.get(num+1)[0] += width[0] + 1;
                }
                max = Math.max(max, width[0] + width[1] + 1);
                map.remove(num);
            }
            set.add(num);
        }
        return max;
    }

    public static void main(String[] args) {
        p128 sol = new p128();
        sol.longestConsecutive(new int[]{-2,-3,-3,7,-3,0,5,0,-8,-4,-1,2});
    }
}
