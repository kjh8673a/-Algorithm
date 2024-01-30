import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int work : works) {
            pq.add(work);
        }
        
        while(n-- > 0) {
            int work = pq.poll();
            if(work == 0) {
                break;
            }
            pq.add(work - 1);
        }
        
        long answer = 0;
        while(!pq.isEmpty()) {
            int work = pq.poll();
            answer += work * work;
        }
        
        return answer;
    }
}