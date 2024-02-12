import java.util.*;

class Solution {
    static class SegmentTree {
        int[] tree;
        int treeSize;
        
        public SegmentTree(int arrSize) {
            int height = (int) Math.ceil(Math.log(arrSize) / Math.log(2));
            this.treeSize = (int) Math.pow(2, height + 1);
            tree = new int[treeSize];
        }
        
        public int init(int[] arr, int node, int start, int end) {
            if(start == end) {
                return tree[node] = arr[start];
            } else {
                return tree[node] = Math.max(init(arr, node * 2, start, (start + end) / 2), init(arr, node * 2 + 1, (start + end) / 2 + 1, end));
            }
        }
        
        public int maxValue(int node, int start, int end, int left, int right) {
            if(left > end || right < start) {
                return 0;
            }
            
            if(left <= start && end <= right) {
                return tree[node];
            }
            
            return Math.max(maxValue(node * 2, start, (start + end) / 2, left, right), maxValue(node * 2 + 1, (start + end) / 2 + 1, end, left, right));
        }
    }
    
    public int solution(int[] stones, int k) {
        int len = stones.length;
        int[] arr = new int[len + 1];
        for(int i = 1; i < len + 1; i++) {
            arr[i] = stones[i - 1];
        }
        
        SegmentTree seg = new SegmentTree(len);
        seg.init(arr, 1, 1, len);
        
        int answer = 200_000_001;
        for(int i = 1; i <= len + 1 - k; i++) {
            answer = Math.min(seg.maxValue(1, 1, len, i, i + k - 1), answer);
        }
        
        return answer;    
    }
}