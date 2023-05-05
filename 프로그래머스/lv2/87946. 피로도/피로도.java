import java.io.*;
import java.util.*;

class Solution {
    static int ans;
    static boolean[] visit;
    
    public int solution(int k, int[][] dungeons) {
        int round = dungeons.length;
        visit = new boolean[round];
        ans = 0;
        dfs(0, k, dungeons);
        return ans;
    }
    
    public void dfs(int cnt, int k, int[][] dungeons) {
        for(int i = 0; i < dungeons.length; i++) {
            if(!visit[i] && k >= dungeons[i][0]) {
                visit[i] = true;
                dfs(cnt + 1, k - dungeons[i][1], dungeons);
                visit[i] = false;
            }
        }
        ans = Math.max(ans, cnt);
    }
    
}