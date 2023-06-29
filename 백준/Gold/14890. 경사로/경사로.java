import java.io.*;
import java.util.*;

public class Main {
    static int N, L;
    static int[][] board;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());

        board = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int ans = 0;
        for (int i = 0; i < N; i++) {
            ans += makeRoad(i);
        }

        System.out.println(ans);
    }

    private static int makeRoad(int num) {
        int result = 0;

        if (check(board[num])) {
            result++;
        }

        int[] tmp = new int[N];
        for (int i = 0; i < N; i++) {
            tmp[i] = board[i][num];
        }
        if (check(tmp)) {
            result++;
        }

        return result;
    }

    private static boolean check(int[] arr) {
        boolean[] visit = new boolean[N];

        for (int i = 1; i < N; i++) {
            if (arr[i] == arr[i - 1]) {
                continue;
            } else if (arr[i] == arr[i - 1] - 1) {
                for (int j = 0; j < L; j++) {
                    if (i + j >= N) {
                        return false;
                    }
                    if (arr[i] != arr[i + j]) {
                        return false;
                    }
                    visit[i + j] = true;
                }
            } else if (arr[i] == arr[i - 1] + 1) {
                for (int j = 1; j <= L; j++) {
                    if (i - j < 0 || visit[i - j]) {
                        return false;
                    }
                    if (arr[i - 1] != arr[i - j]) {
                        return false;
                    }
                    visit[i - j] = true;
                }
            } else {
                return false;
            }
        }

        return true;
    }

}
