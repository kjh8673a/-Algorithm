import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution {
    static class Node {
        int r, c;

        Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
    
    static int[][] map;
    static ArrayList<Node> list;
    static int N, coreMax, lenMin;
    static int[] dr = {1, 0, -1, 0};
    static int[] dc = {0, 1, 0, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for(int tc = 1; tc <= T; tc++) {
            N = Integer.parseInt(br.readLine());

            map = new int[N][N];
            list = new ArrayList<>();
            for(int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                    if(i != 0 && i != N-1 && j != 0 && j != N-1 && map[i][j] == 1) {
                        list.add(new Node(i, j));
                    }
                }
            }

            coreMax = Integer.MIN_VALUE;
            lenMin = Integer.MAX_VALUE;

            dfs(0, 0, 0);

            sb.append("#" + tc + " " + lenMin).append("\n");

        }

        System.out.println(sb.toString());

    }

    public static void dfs(int idx, int cnt, int len) {
        if(cnt + list.size() - idx < coreMax) {
            return;
        }
        
        if(idx == list.size()) {
            if(cnt > coreMax) {
                coreMax = cnt;
                lenMin = len;
            }else if(cnt == coreMax) {
                if(len < lenMin) {
                    lenMin = len;
                }
            }
            return;
        }

        int r = list.get(idx).r;
        int c = list.get(idx).c;

        for(int k = 0; k < 4; k++) {
            int nr = r + dr[k];
            int nc = c + dc[k];

            int nlen = 1;
            if(map[nr][nc] == 1) {
                nlen = 0;
            }else {
                while(nr > 0 && nr < N-1 && nc > 0 && nc < N-1) {
                    nr += dr[k];
                    nc += dc[k];
                    if(map[nr][nc] == 1) {
                        nlen = 0;
                        break;
                    }
                    nlen++;    
                }
            }

            if(nlen == 0) {
                // 연결할 수 없으면 선택안하고 다음 포인트로
                dfs(idx + 1, cnt, len);
            }else {
                // 연결한 선 1로 바꿔주기
                for(int i = 1; i <= nlen; i++) {
                    map[r + dr[k] * i][c + dc[k] * i] = 1;
                }
                // 선택하고 길이 더해주고 다음 포인트로
                dfs(idx + 1, cnt + 1, len + nlen);
                // 1로 바꿔줬던 선 다시 돌려놓기
                for(int i = 1; i <= nlen; i++) {
                    map[r + dr[k] * i][c + dc[k] * i] = 0;
                }
            }

        }
    }
}