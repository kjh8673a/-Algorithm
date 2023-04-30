import java.io.*;
import java.util.*;

class Solution {
    
    class Node implements Comparable<Node> {
        int size;
        int cnt;
        
        public Node(int size, int cnt) {
            this.size = size;
            this.cnt = cnt;
        }
        
        @Override
        public int compareTo(Node o) {
            return o.cnt - this.cnt;
        }
    }
    public int solution(int k, int[] tangerine) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < tangerine.length; i++) {
            map.put(tangerine[i], map.getOrDefault(tangerine[i], 0) + 1);
        }
        
        PriorityQueue<Node> pq = new PriorityQueue<>();
        for(int key : map.keySet()) {
            pq.add(new Node(key, map.get(key)));
        }
        
        int total = k;
        int answer = 0;
        while(total > 0) {
            total -= pq.poll().cnt;
            answer++;
        }
        
        return answer;
    }
}

