import java.util.*;

class Solution {
    public int solution(int[][] maps) {
        int answer = bfs(maps);
        
        return answer;
    }
    
    static int[][] vector = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
    
    private int bfs(int[][] maps) {
        int n = maps.length;
        int m = maps[0].length;
        
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] { 0, 0 });
        
        boolean[][] visited = new boolean[n][m];
        visited[0][0] = true;
        
        int result = 1;
        while(!queue.isEmpty()) {
            int len = queue.size();
            
            for(int i = 0; i < len; i++) {
                int[] node = queue.poll();
                
                if(node[0] == n - 1 && node[1] == m - 1) {
                    return result;
                }
                
                for(int k = 0; k < 4; k++) {
                    int nr = node[0] + vector[k][0];
                    int nc = node[1] + vector[k][1];
                    
                    if(nr < 0 || nc < 0 || nr >= n || nc >= m) {
                        continue;
                    }
                    
                    if(maps[nr][nc] == 0 || visited[nr][nc]) {
                        continue;
                    }
                    
                    visited[nr][nc] = true;
                    queue.add(new int[] { nr, nc });
                }
            }
            
            result++;
        }
        
        return -1;
    }
}