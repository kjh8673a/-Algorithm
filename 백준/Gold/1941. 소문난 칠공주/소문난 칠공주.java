import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static class Node {
        int r, c, val;

        public Node(int r, int c, int val) {
            this.r = r;
            this.c = c;
            this.val = val;
        }

        public Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    static int[] dr = { 1, -1, 0, 0 };
    static int[] dc = { 0, 0, 1, -1 };
    static int[] pick = new int[7];
    static boolean[][] sel = new boolean[5][5];
    static Node[] list;
    static int ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        list = new Node[25];

        int idx = 0;
        for (int i = 0; i < 5; i++) {
            String str = br.readLine();
            for (int j = 0; j < 5; j++) {
                if (str.charAt(j) == 'S') {
                    list[idx++] = new Node(i, j, 1);
                } else {
                    list[idx++] = new Node(i, j, 0);
                }
                
            }
        }

        ans = 0;
        comb(0, 0, 0);

        System.out.println(ans);
        
    }

    public static void comb(int cnt, int idx, int sum) {
        if(cnt == 7) {
            if(sum >= 4) {
                check(sel, pick);
            }
            return;
        }

        for (int i = idx; i < 25; i++) {
            pick[cnt] = i;
            sel[list[i].r][list[i].c] = true;
            comb(cnt + 1, i + 1, sum + list[i].val);
            sel[list[i].r][list[i].c] = false;
        }
    }

    public static void check(boolean[][] map, int[] mem) {
        boolean[][] visit = new boolean[5][5];

        Queue<Node> queue = new LinkedList<>();

        int r = list[mem[0]].r;
        int c = list[mem[0]].c;

        visit[r][c] = true;
        queue.add(new Node(r, c));

        int cnt = 1;
        while(!queue.isEmpty()) {
            Node node = queue.poll();

            for(int k = 0; k < 4; k++) {
                int nr = node.r + dr[k];
                int nc = node.c + dc[k];

                if(nr < 0 || nc < 0 || nr >= 5 || nc >= 5) {
                    continue;
                }

                if(!visit[nr][nc] && map[nr][nc]) {
                    visit[nr][nc] = true;
                    queue.add(new Node(nr, nc));
                    cnt++;
                }
            }
        }

        if(cnt == 7) {
            ans++;
        }
        
    }

}