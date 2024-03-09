import java.io.*;
import java.util.*;

public class Main {
    static class Node {
        int r;
        int c;

        public Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    static int n, m, total, answer;
    static int[][] lab;
    static ArrayList<Node> list;
    static boolean[] selectedVirus;

    static int[][] vector = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        lab = new int[n][n];

        list = new ArrayList<>();
        total = 0;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                lab[i][j] = Integer.parseInt(st.nextToken());
                if (lab[i][j] == 2) {
                    list.add(new Node(i, j));
                }
                if (lab[i][j] != 1) {
                    total++;
                }
            }
        }

        answer = Integer.MAX_VALUE;

        selectedVirus = new boolean[list.size()];
        selectVirus(0, 0);

        System.out.println(answer == Integer.MAX_VALUE ? -1 : answer);
    }

    private static void selectVirus(int idx, int cnt) {
        if (cnt == m) {
            spreadVirus();
            return;
        }
        if (idx == list.size()) {
            return;
        }

        selectedVirus[idx] = true;
        selectVirus(idx + 1, cnt + 1);
        selectedVirus[idx] = false;
        selectVirus(idx + 1, cnt);
    }

    private static void spreadVirus() {
        Queue<Node> queue = new LinkedList<>();
        boolean[][] visited = new boolean[n][n];
        for (int i = 0; i < list.size(); i++) {
            if (selectedVirus[i]) {
                Node virus = list.get(i);
                queue.add(virus);
                visited[virus.r][virus.c] = true;
            }
        }

        int count = queue.size();
        int time = 0;
        while (!queue.isEmpty()) {
            if (count == total) {
                answer = Math.min(answer, time);
                return;
            }

            int len = queue.size();
            for (int i = 0; i < len; i++) {
                Node node = queue.poll();
                for (int k = 0; k < 4; k++) {
                    int nr = node.r + vector[k][0];
                    int nc = node.c + vector[k][1];

                    if (!isInBound(nr, nc) || visited[nr][nc]) {
                        continue;
                    }

                    if (lab[nr][nc] != 1) {
                        visited[nr][nc] = true;
                        count++;
                        queue.add(new Node(nr, nc));
                    }
                }
            }

            time++;
        }

    }

    private static boolean isInBound(int r, int c) {
        if (r < 0 || c < 0 || r >= n || c >= n) {
            return false;
        }
        return true;
    }

}