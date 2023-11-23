import java.util.*;
import java.io.*;

public class Main {
    static class Node {
        int[] cnt;

        public Node(int[] cnt) {
            this.cnt = cnt;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int K = Integer.parseInt(br.readLine());

        Node[][] board = new Node[M + 1][N + 1];
        int[] init = { 0, 0, 0 };
        for (int i = 0; i < M + 1; i++) {
            Arrays.fill(board[i], new Node(init));
        }
        for (int i = 1; i < M + 1; i++) {
            String line = br.readLine();
            for (int j = 1; j < N + 1; j++) {
                int[] tmp = new int[3];
                tmp[0] = board[i - 1][j].cnt[0] + board[i][j - 1].cnt[0] - board[i - 1][j - 1].cnt[0];
                tmp[1] = board[i - 1][j].cnt[1] + board[i][j - 1].cnt[1] - board[i - 1][j - 1].cnt[1];
                tmp[2] = board[i - 1][j].cnt[2] + board[i][j - 1].cnt[2] - board[i - 1][j - 1].cnt[2];

                char c = line.charAt(j - 1);
                switch (c) {
                    case 'J':
                        tmp[0]++;
                        break;
                    case 'O':
                        tmp[1]++;
                        break;
                    case 'I':
                        tmp[2]++;
                        break;
                }

                board[i][j] = new Node(tmp);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            int J = board[c][d].cnt[0] - board[c][b - 1].cnt[0] - board[a - 1][d].cnt[0] + board[a - 1][b - 1].cnt[0];
            int O = board[c][d].cnt[1] - board[c][b - 1].cnt[1] - board[a - 1][d].cnt[1] + board[a - 1][b - 1].cnt[1];
            int I = board[c][d].cnt[2] - board[c][b - 1].cnt[2] - board[a - 1][d].cnt[2] + board[a - 1][b - 1].cnt[2];

            sb.append(J + " " + O + " " + I).append("\n");
        }

        System.out.println(sb);
    }

}