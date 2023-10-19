import java.util.*;

class Solution {
    public String solution(int n, int t, int m, String[] timetable) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(String time : timetable) {
            int hour = Integer.parseInt(time.split(":")[0]);
            int minute = Integer.parseInt(time.split(":")[1]);
            pq.add(hour * 60 + minute);
        }
        
        int start = 9 * 60;
        int cnt = 0;
        int ans = 0;
        while(cnt++ < n) {
            int seat = 0;
            while(!pq.isEmpty() && pq.peek() <= start && seat < m) {
                int tmp = pq.poll();
                seat++;
                if(seat == m) {
                    ans = tmp - 1;
                }
            }
            
            if(seat < m) {
                ans = start;
            }
            start += t;
        }
        
        String answer = String.format("%02d:%02d", ans/60, ans%60);
        
        return answer;
    }
}