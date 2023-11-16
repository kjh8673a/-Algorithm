import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i = 0; i < scoville.length; i++) {
            pq.offer(scoville[i]);
        }
        
        int answer = 0;
        while(pq.size() > 1 && pq.peek() < K) {
            int a = pq.poll();
            int b = pq.poll();
            
            int tmp = a + b * 2;
            pq.offer(tmp);
            answer++;
        }
        
        if(pq.peek() < K) {
            answer = -1;
        }
        
        return answer;
    }
}