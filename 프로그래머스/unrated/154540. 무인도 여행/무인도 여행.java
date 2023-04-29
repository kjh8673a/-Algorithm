import java.io.*;
import java.util.*;

class Solution {
    static int[][] board;
    static int[] dr = {1, -1, 0, 0};
    static int[] dc = {0, 0, 1, -1};
    static int N, M, val;
    
    public int[] solution(String[] maps) {
        N = maps.length;
        M = maps[0].length();
        board = new int[N][M];
        for(int i = 0; i < N; i++) {
            String s = maps[i];
            for(int j = 0; j < M; j++) {
                if(s.charAt(j) == 'X') {
                    board[i][j] = 0;
                }else {
                    board[i][j] = s.charAt(j) - '0';
                }
            }
        }
        
        ArrayList<Integer> list = new ArrayList<>();
        // Map<Integer, Integer> map = new HashMap<>();
        // int cnt = 0;
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(board[i][j] != 0) {
                    val = board[i][j];
                    board[i][j] = 0;
                    dfs(i,j);
                    list.add(val);
                    // map.put(val, map.getOrDefault(map.get(val), 0) + 1);
                    // cnt++;
                }
            }
        }
        
        if(list.isEmpty()) {
            int[] answer = {-1};
            return answer;
        }else {
            int[] answer = new int[list.size()];
            // int idx = 0;
            // for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            //     for(int i = 0; i < entry.getValue(); i++) {
            //         answer[idx++] = entry.getKey();
            //     }
            // }
            
            for(int i = 0; i < list.size(); i++) {
                answer[i] = list.get(i);
            }
            Arrays.sort(answer);            
            return answer;
        }
    }
    
    static void dfs(int r, int c) {
        
        for(int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];
            if(nr >= 0 && nc >= 0 && nr < N && nc < M && board[nr][nc] != 0) {
                val += board[nr][nc];
                board[nr][nc] = 0;
                dfs(nr, nc);
                
            }
        }
    }
}