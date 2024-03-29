import java.util.*;

class Solution {
    static class Point {
        int r;
        int c;
        int time;
        
        public Point(int r, int c, int time) {
            this.r = r;
            this.c = c;
            this.time = time;
        }
    }
    
    static char[][] board;
    static int answer;
    
    static int[][] vector = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    
    public int solution(String[] maps) {
        board = new char[maps.length][maps[0].length()];
        int sr = 0;
        int sc = 0;
        for(int i = 0; i < maps.length; i++) {
            for(int j = 0; j < maps[0].length(); j++) {
                board[i][j] = maps[i].charAt(j);
                if(board[i][j] == 'S') {
                    sr = i;
                    sc = j;
                }
            }
        }
        
        answer = findRoute(sr, sc, 'L');
        
        return answer;
    }
    
    private static int findRoute(int r, int c, char goal) {
        Queue<Point> queue = new LinkedList<>();
        
        boolean[][] visit = new boolean[board.length][board[0].length];
        
        visit[r][c] = true;
        queue.add(new Point(r, c, 0));
        
        while(!queue.isEmpty()) {
            Point curr = queue.poll();
            
            if(board[curr.r][curr.c] == goal) {
                if(goal == 'L') {
                    int f = findRoute(curr.r, curr.c, 'E');
                    if(f == -1) {
                        return -1;
                    }else {
                        return curr.time + f;
                    }
                }else {
                    return curr.time;
                }
                
            } 
            
            for(int i = 0; i < 4; i++) {
                int nr = curr.r + vector[i][0];
                int nc = curr.c + vector[i][1];
                
                if(nr < 0 || nc < 0 || nr >= board.length || nc >= board[0].length || board[nr][nc] == 'X' || visit[nr][nc]) {
                    continue;
                }
                
                queue.add(new Point(nr, nc, curr.time + 1));
                visit[nr][nc] = true;
                
            }
            
        }
        
        return -1;
    }
}