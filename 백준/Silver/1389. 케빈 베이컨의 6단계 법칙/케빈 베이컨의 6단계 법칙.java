import java.io.*;
import java.util.*;

public class Main {
    static List<Integer>[] adjList;
    static boolean[] visit;
    static int[][] board;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        adjList = new ArrayList[N];
        for(int i = 0; i < N; i++) {
            adjList[i] = new ArrayList<>();
        }   
        
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            adjList[a].add(b);
            adjList[b].add(a);
        }

        board = new int[N][N];
        for(int i = 0; i < N; i++) {
            visit = new boolean[N];
            solve(i, i, 1);
        }

        int ans = 0;
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < N; i++) {
            int sum = 0;
            for(int j = 0; j < N; j++) {
                sum += board[i][j];
            }
            if(sum < min) {
                ans = i + 1;
                min = sum;
            }
        }

        System.out.println(ans);

    }

    public static void solve(int st, int n, int cnt) {
        visit[n] = true;
        for(int i : adjList[n]) {
            if(!visit[i] || board[st][i] > cnt) {
                board[st][i] = cnt;
                solve(st, i, cnt + 1);
            }
        }
    }

}