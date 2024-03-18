import java.util.*;

class Solution {
    public int solution(int n, int[][] results) {
        int[][] record = new int[n + 1][n + 1];
        for(int[] result : results) {
            int a = result[0];
            int b = result[1];
            record[a][b] = 1;
            record[b][a] = -1;
        }
        
        for(int i = 1; i < n + 1; i++) {
             for(int j = 1; j < n + 1; j++) {
                 // i가 j를 이기고
                 if(record[i][j] == 1) {
                     for(int k = 1; k < n + 1; k++) {
                         // k가 i를 이기면
                         if(record[i][k] == -1) {
                             // k는 j를 이긴다
                             record[k][j] = 1;
                             record[j][k] = -1;
                         }
                     }
                 }
             }
        }
        
        int answer = 0;
        for(int i = 1; i < n + 1; i++) {
            int tmp = 0;
            for(int j = 1; j < n + 1; j++) {
                tmp += Math.abs(record[i][j]);
            }
            if(tmp == n - 1) {
                answer++;
            }
        }
        
        return answer;
    }
}