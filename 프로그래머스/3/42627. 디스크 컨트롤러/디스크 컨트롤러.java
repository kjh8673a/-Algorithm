import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        PriorityQueue<int[]> requestTime = new PriorityQueue<>((o1, o2) -> o1[0] - o2[0]);
        for(int[] job : jobs) {
            requestTime.add(job);
        }
        
        PriorityQueue<int[]> workingTime = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
        
        int answer = 0;
        int time = 0;
        while(!requestTime.isEmpty() || !workingTime.isEmpty()) {
            while(!requestTime.isEmpty() && requestTime.peek()[0] <= time) {
                workingTime.add(requestTime.poll());
            }
            
            if(workingTime.isEmpty()) {
                time = requestTime.peek()[0];
            }else {
                int[] work = workingTime.poll();
                answer += time + work[1] - work[0];
                time += work[1];
            }
        }
        
        return answer / jobs.length;
    }
}