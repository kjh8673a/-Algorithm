import java.util.*;
import java.io.*;

public class Main {
    static int[] dr = { 1, 0, -1, 0 };
    static int[] dc = { 0, 1, 0, -1 };
    static int[][] map;

    static class Node {
        int r;
        int c;

        public Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        map = new int[R + 2][C + 2];
        for (int i = 1; i < R + 1; i++) {
            String line = br.readLine();
            for (int j = 1; j < C + 1; j++) {
                map[i][j] = line.charAt(j - 1) == '.' ? 0 : 1;
            }
        }

        Queue<Node> queue = new LinkedList<>();
        int minR = Integer.MAX_VALUE;
        int minC = Integer.MAX_VALUE;
        int maxR = Integer.MIN_VALUE;
        int maxC = Integer.MIN_VALUE;
        for (int i = 1; i < R + 1; i++) {
            for (int j = 1; j < C + 1; j++) {
                if (map[i][j] == 1 && !isSink(i, j)) {
                    queue.add(new Node(i, j));
                    minR = Math.min(minR, i);
                    minC = Math.min(minC, j);
                    maxR = Math.max(maxR, i);
                    maxC = Math.max(maxC, j);
                }
            }
        }

        int[][] ans = new int[maxR - minR + 1][maxC - minC + 1];
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            ans[node.r - minR][node.c - minC] = 1;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < ans.length; i++) {
            for (int j = 0; j < ans[i].length; j++) {
                if (ans[i][j] == 0) {
                    sb.append(".");
                } else {
                    sb.append("X");
                }
            }
            sb.append("\n");
        }

        System.out.println(sb);

    }

    static boolean isSink(int r, int c) {
        int close = 0;
        for (int i = 0; i < 4; i++) {
            if (map[r + dr[i]][c + dc[i]] == 0) {
                close++;
            }
        }

        if (close >= 3) {
            return true;
        } else {
            return false;
        }
    }
}
