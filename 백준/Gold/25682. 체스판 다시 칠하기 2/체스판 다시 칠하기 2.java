import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[][] white = new int[n][m];
        int[][] black = new int[n][m];
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < m; j++) {
                char color = line.charAt(j);
                if ((i + j) % 2 == 0) {
                    white[i][j] = color == 'W' ? 0 : 1;
                    black[i][j] = color == 'B' ? 0 : 1;
                } else {
                    white[i][j] = color == 'W' ? 1 : 0;
                    black[i][j] = color == 'B' ? 1 : 0;
                }
            }
        }

        int[][] sumWhite = new int[n + 1][m + 1];
        int[][] sumBlack = new int[n + 1][m + 1];
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                sumWhite[i][j] = sumWhite[i - 1][j] + sumWhite[i][j - 1] - sumWhite[i - 1][j - 1] + white[i - 1][j - 1];
                sumBlack[i][j] = sumBlack[i - 1][j] + sumBlack[i][j - 1] - sumBlack[i - 1][j - 1] + black[i - 1][j - 1];
            }
        }

        int answer = Integer.MAX_VALUE;
        for (int i = 1; i <= n - k + 1; i++) {
            for (int j = 1; j <= m - k + 1; j++) {
                int cntWhite = sumWhite[i + k - 1][j + k - 1] - sumWhite[i - 1][j + k - 1] - sumWhite[i + k - 1][j - 1]
                        + sumWhite[i - 1][j - 1];
                int cntBlack = sumBlack[i + k - 1][j + k - 1] - sumBlack[i - 1][j + k - 1] - sumBlack[i + k - 1][j - 1]
                        + sumBlack[i - 1][j - 1];
                answer = Math.min(answer, Math.min(cntWhite, cntBlack));
            }
        }

        System.out.println(answer);
    }

}