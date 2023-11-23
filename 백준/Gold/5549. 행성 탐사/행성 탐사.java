import java.util.*;
import java.io.*;

public class Main {
    static class Node {
        int J;
        int O;
        int I;

        public Node(int J, int O, int I) {
            this.J = J;
            this.O = O;
            this.I = I;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int K = Integer.parseInt(br.readLine());

        Node[][] board = new Node[M + 1][N + 1];
        for (int i = 0; i < M + 1; i++) {
            Arrays.fill(board[i], new Node(0, 0, 0));
        }
        for (int i = 1; i < M + 1; i++) {
            String line = br.readLine();
            for (int j = 1; j < N + 1; j++) {
                Node now = new Node(0, 0, 0);
                now.J = board[i - 1][j].J + board[i][j - 1].J - board[i - 1][j - 1].J;
                now.O = board[i - 1][j].O + board[i][j - 1].O - board[i - 1][j - 1].O;
                now.I = board[i - 1][j].I + board[i][j - 1].I - board[i - 1][j - 1].I;

                char c = line.charAt(j - 1);
                switch (c) {
                    case 'J':
                        now.J++;
                        break;
                    case 'O':
                        now.O++;
                        break;
                    case 'I':
                        now.I++;
                        break;
                }

                board[i][j] = now;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            int J = board[c][d].J - board[c][b - 1].J - board[a - 1][d].J + board[a - 1][b - 1].J;
            int O = board[c][d].O - board[c][b - 1].O - board[a - 1][d].O + board[a - 1][b - 1].O;
            int I = board[c][d].I - board[c][b - 1].I - board[a - 1][d].I + board[a - 1][b - 1].I;

            sb.append(J + " " + O + " " + I).append("\n");
        }

        System.out.println(sb);
    }

}