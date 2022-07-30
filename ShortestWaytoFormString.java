// time: O(MN) | space: O(1)
//brute force
class Solution {
    public int shortestWay(String source, String target) {
        int m = target.length();
        int n = source.length();
        int count = 0;
        int sp = 0;
        int tp = 0;
        int prevTarget = 0;
        while (tp < m) {
            if (source.charAt(sp) == target.charAt(tp)) {
                tp++;
            }
            sp++;
            if (sp == n || tp == m)
                count++;

            if (sp == n) {
                sp = 0;
                if (prevTarget == tp) return -1;
                prevTarget = tp;
            }
        }
        return count;
    }
}

//optimal
// time: O(M*log(K)) | Space: O(N)
class Solution {
    public int shortestWay(String source, String target) {
        int m = target.length();
        int n = source.length();
        Map<Character, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            char curr = source.charAt(i);
            if (!map.containsKey(curr)) {
                map.put(curr, new ArrayList<>());
            }
            map.get(curr).add(i);
        }
        int count = 1;
        int sp = 0;
        int tp = 0;
        while (tp < m) {
            char targetChar = target.charAt(tp);
            if (!map.containsKey(targetChar)) return -1;
            List<Integer> currIntegers = map.get(targetChar);
            int pos = Collections.binarySearch(currIntegers, sp);
            if (pos < 0) pos = -(pos) - 1;
            if (pos == currIntegers.size()) {
                sp = 0;
                count++;
            } else {
                sp = currIntegers.get(pos);
                sp++;
                tp++;
            }


        }
        return count;
    }

}
