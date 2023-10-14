import java.util.*;
import java.io.*;

public class Main {
    static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static ArrayList<Node> list;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        list = new ArrayList<>();
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            list.add(new Node(x, y));
        }

        int res = 0;
        for (Node a : list) {
            for (Node b : list) {
                res = Math.max(res, inBound(a.x, b.y, L));
            }
        }

        System.out.println(K - res);
    }

    private static int inBound(int i, int j, int l) {
        int cnt = 0;
        for (Node s : list) {
            if (s.x >= i && s.x <= i + l && s.y >= j && s.y <= j + l) {
                cnt++;
            }
        }

        return cnt;
    }

}
