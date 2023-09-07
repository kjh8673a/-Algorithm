import java.util.*;

class Solution {
    static class Node {
        int r;
        int c;
        int dir;
        int cost;
        
        public Node(int r, int c, int dir, int cost) {
            this.r = r;
            this.c = c;
            this.dir = dir;
            this.cost = cost;
        }
    }
    
    static int[][] vector = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    
    public int solution(int[][] board) {
        int len = board.length;
        for(int i = 0; i < len; i++) {
            for(int j = 0; j < len; j++) {
                if(board[i][j] == 0){
                    board[i][j] = Integer.MAX_VALUE;
                }
            }
        }
        
        return bfs(board);
    }
    
    private int bfs(int[][] board) {
        int len = board.length;
        
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(0, 0, -1, 0));
        
        boolean[][][] visit = new boolean[len][len][4];
        for(int i = 0; i < 4; i++) {
            visit[0][0][i] = true;
        }
        
        board[0][0] = 0;
        
        int ans = Integer.MAX_VALUE;
        while(!queue.isEmpty()) {
            Node cur = queue.poll();
            
            if(cur.r == len - 1 && cur.c == len - 1) {
                ans = Math.min(ans, cur.cost);
                continue;
            }
            
            for(int i = 0; i < 4; i++) {
                int nr = cur.r + vector[i][0];
                int nc = cur.c + vector[i][1];
                
                if(nr < 0 || nc < 0 || nr >= len || nc >= len || board[nr][nc] == 1) {
                    continue;
                }
                
                int tmp = 100;
                if(cur.dir != -1 && cur.dir != i) {
                    tmp += 500;
                }
                
                if(!visit[nr][nc][i] || cur.cost + tmp <= board[nr][nc]) {
                    queue.add(new Node(nr, nc, i, cur.cost + tmp));
                    board[nr][nc] = cur.cost + tmp;
                    visit[nr][nc][i] = true;
                }         
                
            }
        }
        
        return ans;
    }
}