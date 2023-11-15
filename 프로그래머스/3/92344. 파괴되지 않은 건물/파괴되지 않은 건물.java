class Solution {
    public int solution(int[][] board, int[][] skill) {
        int N = board.length;
        int M = board[0].length;
        
        int[][] sum = makeSumArr(skill, N, M);
        
        int answer = 0;
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(board[i][j] + sum[i][j] > 0) {
                    answer++;
                }
            }
        }
            
        return answer;
    }
    
    private static int[][] makeSumArr(int[][] skill, int N, int M) {
        int[][] result = new int[N + 1][M + 1];
        
        for(int i = 0; i < skill.length; i++) {
            int type = skill[i][0];
            int degree = skill[i][5];
            if(type == 1) {
                degree *= -1;
            }
            
            result[skill[i][1]][skill[i][2]] += degree;
            result[skill[i][1]][skill[i][4] + 1] -= degree;
            result[skill[i][3] + 1][skill[i][2]] -= degree;
            result[skill[i][3] + 1][skill[i][4] + 1] += degree;
        }
        
        for(int i = 0; i < N + 1; i++) {
            for(int j = 1; j < M + 1; j++) {
                result[i][j] += result[i][j - 1];
            }
        }
        
        for(int j = 0; j < M + 1; j++) {
            for(int i = 1; i < N + 1; i++) {
                result[i][j] += result[i - 1][j];
            }
        }
        
        return result;
    }
}