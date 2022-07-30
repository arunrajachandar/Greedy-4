// time: O(N) | Space: O(1)

class Solution {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        int m = tops.length;
        int n = bottoms.length;
        if(m != n) return -1;
        int res = provideCount(tops, bottoms, tops[0]);
        if(res != -1) return res;
        return provideCount(tops, bottoms, bottoms[0]);
    }
    private int provideCount(int[] tops, int[] bottoms, int target) {
        int topRot = 0;
        int bottomRot = 0;
        for(int i=0;i<tops.length;i++) {
            int b = tops[i];
            int c = bottoms[i];
            if(b != target && c != target) return -1;
            if(b != target) topRot++;
            if(c != target) bottomRot++;
        }
        return Math.min(topRot, bottomRot);
    }
}

// with hashMap solution - taking max Freq

// time: O(N) | Space: O(1)

class Solution {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        int m = tops.length;
        int n = bottoms.length;
        if(m != n) return -1;
        Map<Integer, Integer> map = new HashMap<>();
        int maxFreqEle = tops[0];
        for(int i=0;i<m;i++) {
            int b = tops[i];
            map.put(b, map.getOrDefault(b, 0)+1);
            if(map.get(maxFreqEle) < map.get(b)) maxFreqEle = b;
            int c = bottoms[i];
            map.put(c, map.getOrDefault(c, 0)+1);
            if(map.get(maxFreqEle) < map.get(c)) maxFreqEle = c;
        }
        int topRot = 0;
        int bottomRot = 0;
        for(int i=0;i<m;i++) {
            int b = tops[i];
            int c = bottoms[i];
            if(b != maxFreqEle && c != maxFreqEle) return -1;
            if(b != maxFreqEle) topRot++;
            if(c != maxFreqEle) bottomRot++;
        }
        return Math.min(topRot, bottomRot);
    }

}