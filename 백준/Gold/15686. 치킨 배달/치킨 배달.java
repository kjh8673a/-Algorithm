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

    static ArrayList<Node> chicken, home;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] city = new int[N][N];
        chicken = new ArrayList<>();
        home = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                city[i][j] = Integer.parseInt(st.nextToken());
                if (city[i][j] == 1) {
                    home.add(new Node(i, j));
                } else if (city[i][j] == 2) {
                    chicken.add(new Node(i, j));
                }
            }
        }

        int ans = Integer.MAX_VALUE;
        // 폐업시키지 않을 치킨집 M개 고르기
        for (int i = 0; i < 1 << chicken.size(); i++) {
            if (Integer.bitCount(i) == M) {
                // 거리 계산해서 최솟값 찾기
                ans = Math.min(caculate(i), ans);
            }
        }

        System.out.println(ans);
    }

    private static int caculate(int list) {
        int sum = 0;
        for (Node h : home) {
            int distance = Integer.MAX_VALUE;
            for (int i = 0; i < chicken.size(); i++) {
                // 해당 번호 치킨집이 list에 선택된 치킨집일때만 계산
                if ((list & (1 << i)) != 0) {
                    Node c = chicken.get(i);
                    distance = Math.min(Math.abs(h.r - c.r) + Math.abs(h.c - c.c), distance);
                }
            }
            // 집마다 거리의 최솟값을 더함
            sum += distance;
        }
        return sum;
    }

}
