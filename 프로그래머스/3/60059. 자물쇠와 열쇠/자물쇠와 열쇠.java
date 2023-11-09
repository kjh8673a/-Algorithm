import java.util.*;

class Solution {
    static class Hole {
        int r;
        int c;
        
        public Hole(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
    
    static int M, N;
    static ArrayList<Hole> holes;
    public boolean solution(int[][] key, int[][] lock) {
        M = key.length;
        N = lock.length;
        holes = new ArrayList<>();
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(lock[i][j] == 0) {
                    holes.add(new Hole(i, j));
                }
            }
        }
        
        boolean answer = false;
        if(holes.size() == 0) {
            answer = true;
        }else {
            answer = check(key, lock);
        }
        
        return answer;
    }
    
    private static boolean check(int[][] key, int[][] lock) {
        for(int i = 0; i < 4; i++) {
            if(match(key, lock)) {
                return true;
            }
            key = rotate(key);
        }
        
        return false;
    }
    
    private static boolean match(int[][] key, int[][] lock) {
        for(int i = N - 1; i >= 1 - M; i--) {
            for(int j = N - 1; j >= 1 - M; j--) {
                boolean flag = true;
                for(int r = 0; r < N; r++) {
                    for(int c = 0; c < N; c++) {
                        if(r - i < 0 || c - j < 0 || r - i >= M || c - j >= M) {
                            if(lock[r][c] == 0) {
                                flag = false;
                                break;
                            }
                        }else {
                            if((lock[r][c] == 1 && key[r - i][c - j] == 1) || (lock[r][c] == 0 && key[r - i][c - j] == 0)) {
                                flag = false;
                                break;
                            }
                        }
                    }
                }
                if(flag) {
                    return true;
                }                
            }
        }
        
        return false;
    }
    
    private static int[][] rotate(int[][] key) {
        int[][] tmp = new int[M][M];
        
        for(int i = 0; i < M; i++){
            for(int j = 0; j < M; j++){
                tmp[i][j] = key[M - j - 1][i];
            }
        }
        
        return tmp;
    }
    
    
}