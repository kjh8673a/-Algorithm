import java.util.*;

class Solution {
    static class Node {
        int r;
        int c;
        int cnt;
        
        public Node(int r, int c, int cnt) {
            this.r = r;
            this.c = c;
            this.cnt = cnt;
        }
    }
    
    static Map<Integer, ArrayList<Node>> map;
    static ArrayList<Integer> list;
    static int sr, sc, answer;
    static int[][] board, boardCopy;
    
    static int[][] vector = { {1, 0}, {-1, 0}, {0, 1}, {0, -1} };
    
    public int solution(int[][] board, int r, int c) {
        sr = r;
        sc = c;
        this.board = board;
        
        map = new HashMap<>();
        list = new ArrayList<>();
        
        for(int i = 0; i < 4; i++) {
            for(int j = 0; j < 4; j++) {
                if(board[i][j] > 0) {
                    if(!map.containsKey(board[i][j])) {
                        map.put(board[i][j], new ArrayList<>());
                        list.add(board[i][j]);
                    }
                    map.get(board[i][j]).add(new Node(i, j, 0));
                }
            }
        }
        
        answer = Integer.MAX_VALUE;
        
        permutation(new int[list.size()], new boolean[list.size()], 0);
        
        return answer;
    }
    
    private static void permutation(int[] order, boolean[] visit, int idx) {
        if(idx == list.size()) {
            answer = Math.min(play(order), answer);
            return;
        }
        
        for(int i = 0; i < list.size(); i++) {
            if(visit[i]) {
                continue;
            }
            order[idx] = list.get(i);
            visit[i] = true;
            permutation(order, visit, idx + 1);
            visit[i] = false;
        }
    }
    
    private static int play(int[] order) {
        int r = sr;
        int c = sc;
        
        boardCopy = new int[4][4];
        for(int i = 0; i < 4; i++) {
            boardCopy[i] = Arrays.copyOf(board[i], 4);
        }
        
        int tmp = 0;
        for(int i = 0; i < order.length; i++) {
            Node targetA = map.get(order[i]).get(0);
            Node targetB = map.get(order[i]).get(1);
            
            int distA = getDist(r, c, targetA);
            int distB = getDist(r, c, targetB);
            
            if(distA < distB) {
                tmp += distA + 1;
                tmp += getDist(targetA.r, targetA.c, targetB) + 1;
                r = targetB.r;
                c = targetB.c;
            }else {
                tmp += distB + 1;
                tmp += getDist(targetB.r, targetB.c, targetA) + 1;
                r = targetA.r;
                c = targetA.c;
            }
            
            boardCopy[targetA.r][targetA.c] = 0;
            boardCopy[targetB.r][targetB.c] = 0;
        }
    
        return tmp;
    }
    
    private static int getDist(int r, int c, Node target) {
        Queue<Node> queue = new LinkedList<>();
        boolean[][] visit = new boolean[4][4];
        
        queue.offer(new Node(r, c, 0));
        visit[r][c] = true;
        
        while(!queue.isEmpty()) {
            Node curr = queue.poll();
            
            if(curr.r == target.r && curr.c == target.c) {
                return curr.cnt;
            }
            
            for(int k = 0; k < 4; k++) {
                int nr = curr.r + vector[k][0];
                int nc = curr.c + vector[k][1];
                
                if(!isInBound(nr, nc)) {
                    continue;
                }
                
                if(!visit[nr][nc]) {
                    queue.add(new Node(nr, nc, curr.cnt + 1));
                    visit[nr][nc] = true;
                }
                
                while(isInBound(nr + vector[k][0], nc + vector[k][1])) {
                    if(boardCopy[nr][nc] != 0) {
                        break;
                    }
                    nr += vector[k][0];
                    nc += vector[k][1];
                }
                
                if(!visit[nr][nc]) {
                    queue.add(new Node(nr, nc, curr.cnt + 1));
                    visit[nr][nc] = true;
                }
            }
            
        }
        
        return 0;
    }
    
    private static boolean isInBound(int r, int c) {
        if(r < 0 || c < 0 || r >= 4 || c >= 4) {
            return false;
        }
        
        return true;
    }
}