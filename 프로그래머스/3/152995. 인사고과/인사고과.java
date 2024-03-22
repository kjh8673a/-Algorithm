import java.util.*;

class Solution {
    public int solution(int[][] scores) {
        int n = scores[0][0];
        int m = scores[0][1];
        
        Arrays.sort(scores, (o1, o2) -> {
           if(o1[0] == o2[0]) {
               return o1[1] - o2[1];
           } else {
               return o2[0] - o1[0];
           }
        });
        
        int answer = 1;
        int maxM = 0;
        for(int i = 0; i < scores.length; i++) {
            if(maxM > scores[i][1]) {
                if(scores[i][0] == n && scores[i][1] == m) {
                    return -1;
                }
                
                continue;
            }else {
                maxM = Math.max(maxM, scores[i][1]);
                if(scores[i][0] + scores[i][1] > n + m) {
                    answer++;
                }
            }
            
           
        }
        
        return answer;
    }
}