import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static class Node {
        int rR, cR, rB, cB;

        public Node(int rR, int cR, int rB, int cB) {
            this.rR = rR;
            this.cR = cR;
            this.rB = rB;
            this.cB = cB;
        }
    }

    static int N, M, ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int rR = 0;
        int cR = 0;
        int rB = 0;
        int cB = 0;
        Character[][] map = new Character[N][M];
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = str.charAt(j);
                if (map[i][j] == 'R') {
                    rR = i;
                    cR = j;
                }
                if (map[i][j] == 'B') {
                    rB = i;
                    cB = j;
                }
            }
        }

        ans = Integer.MAX_VALUE;
        solve(map, new Node(rR, cR, rB, cB), 0);

        if (ans == Integer.MAX_VALUE) {
            ans = -1;
        }

        System.out.println(ans);

    }

    public static void solve(Character[][] arr, Node node, int cnt) {
        if (cnt >= 10) {
            return;
        }

        goUp(arr, node, cnt);
        goDown(arr, node, cnt);
        goLeft(arr, node, cnt);
        goRight(arr, node, cnt);
    }

    public static void goUp(Character[][] arr, Node node, int cnt) {
        int rR = node.rR;
        int cR = node.cR;
        int rB = node.rB;
        int cB = node.cB;

        int new_rR = 0;
        int new_rB = 0;

        Character[][] tmp = new Character[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                tmp[i][j] = arr[i][j];
            }
        }
        tmp[rR][cR] = '.';
        tmp[rB][cB] = '.';

        // 공이 홀에 들어갔는지 체크
        boolean goal = false;

        // B가 R보다 더 위에 있다 -> B부터 옮긴다
        if (rR > rB) {
            for (int i = rB; i >= 0; i--) {
                if (tmp[i][cB] == '#') {
                    new_rB = i + 1;
                    tmp[new_rB][cB] = 'B';
                    break;
                }
                if (tmp[i][cB] == 'O') {
                    return;
                }
            }

            for (int i = rR; i >= 0; i--) {
                if (tmp[i][cR] == '#' || tmp[i][cR] == 'B') {
                    new_rR = i + 1;
                    tmp[new_rR][cR] = 'R';
                    break;
                }
                if (tmp[i][cR] == 'O') {
                    goal = true;
                    break;
                }
            }
        }

        // R이 B보다 더 위에 있다 -> R부터 옮긴다
        else {
            for (int i = rR; i >= 0; i--) {
                if (tmp[i][cR] == '#') {
                    new_rR = i + 1;
                    tmp[new_rR][cR] = 'R';
                    break;
                }
                if (tmp[i][cR] == 'O') {
                    goal = true;
                    break;
                }
            }

            for (int i = rB; i >= 0; i--) {
                if (tmp[i][cB] == '#' || tmp[i][cB] == 'R') {
                    new_rB = i + 1;
                    tmp[new_rB][cB] = 'B';
                    break;
                }
                if (tmp[i][cB] == 'O') {
                    return;
                }
            }
        }

        if (goal) {
            ans = Math.min(ans, cnt + 1);
            return;
        }

        if (rR != new_rR || rB != new_rB) {
            solve(tmp, new Node(new_rR, cR, new_rB, cB), cnt + 1);
        }

    }

    public static void goDown(Character[][] arr, Node node, int cnt) {
        int rR = node.rR;
        int cR = node.cR;
        int rB = node.rB;
        int cB = node.cB;

        int new_rR = 0;
        int new_rB = 0;

        Character[][] tmp = new Character[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                tmp[i][j] = arr[i][j];
            }
        }
        tmp[rR][cR] = '.';
        tmp[rB][cB] = '.';

        // 공이 홀에 들어갔는지 체크
        boolean goal = false;

        // B가 R보다 더 위에 있다 -> R부터 옮긴다
        if (rR > rB) {
            for (int i = rR; i < N; i++) {
                if (tmp[i][cR] == '#') {
                    new_rR = i - 1;
                    tmp[new_rR][cR] = 'R';
                    break;
                }
                if (tmp[i][cR] == 'O') {
                    goal = true;
                    break;
                }
            }

            for (int i = rB; i < N; i++) {
                if (tmp[i][cB] == '#' || tmp[i][cB] == 'R') {
                    new_rB = i - 1;
                    tmp[new_rB][cB] = 'B';
                    break;
                }
                if (tmp[i][cB] == 'O') {
                    return;
                }
            }

        }

        // R이 B보다 더 위에 있다 -> B부터 옮긴다
        else {
            for (int i = rB; i < N; i++) {
                if (tmp[i][cB] == '#') {
                    new_rB = i - 1;
                    tmp[new_rB][cB] = 'B';
                    break;
                }
                if (tmp[i][cB] == 'O') {
                    return;
                }
            }

            for (int i = rR; i < N; i++) {
                if (tmp[i][cR] == '#' || tmp[i][cR] == 'B') {
                    new_rR = i - 1;
                    tmp[new_rR][cR] = 'R';
                    break;
                }
                if (tmp[i][cR] == 'O') {
                    goal = true;
                    break;
                }
            }

        }

        if (goal) {
            ans = Math.min(ans, cnt + 1);
            return;
        }

        if (rR != new_rR || rB != new_rB) {
            solve(tmp, new Node(new_rR, cR, new_rB, cB), cnt + 1);
        }

    }

    public static void goLeft(Character[][] arr, Node node, int cnt) {
        int rR = node.rR;
        int cR = node.cR;
        int rB = node.rB;
        int cB = node.cB;

        int new_cR = 0;
        int new_cB = 0;

        Character[][] tmp = new Character[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                tmp[i][j] = arr[i][j];
            }
        }
        tmp[rR][cR] = '.';
        tmp[rB][cB] = '.';

        // 공이 홀에 들어갔는지 체크
        boolean goal = false;

        // B가 R보다 더 왼쪽에 있다 -> B부터 옮긴다
        if (cR > cB) {
            for (int i = cB; i >= 0; i--) {
                if (tmp[rB][i] == '#') {
                    new_cB = i + 1;
                    tmp[rB][new_cB] = 'B';
                    break;
                }
                if (tmp[rB][i] == 'O') {
                    return;
                }
            }

            for (int i = cR; i >= 0; i--) {
                if (tmp[rR][i] == '#' || tmp[rR][i] == 'B') {
                    new_cR = i + 1;
                    tmp[rR][new_cR] = 'R';
                    break;
                }
                if (tmp[rR][i] == 'O') {
                    goal = true;
                    break;
                }
            }

        }

        // R이 B보다 더 왼쪽에 있다 -> R부터 옮긴다
        else {
            for (int i = cR; i >= 0; i--) {
                if (tmp[rR][i] == '#') {
                    new_cR = i + 1;
                    tmp[rR][new_cR] = 'R';
                    break;
                }
                if (tmp[rR][i] == 'O') {
                    goal = true;
                    break;
                }
            }

            for (int i = cB; i >= 0; i--) {
                if (tmp[rB][i] == '#' || tmp[rB][i] == 'R') {
                    new_cB = i + 1;
                    tmp[rB][new_cB] = 'B';
                    break;
                }
                if (tmp[rB][i] == 'O') {
                    return;
                }
            }

        }

        if (goal) {
            ans = Math.min(ans, cnt + 1);
            return;
        }

        if (cR != new_cR || cB != new_cB) {
            solve(tmp, new Node(rR, new_cR, rB, new_cB), cnt + 1);
        }

    }

    public static void goRight(Character[][] arr, Node node, int cnt) {
        int rR = node.rR;
        int cR = node.cR;
        int rB = node.rB;
        int cB = node.cB;

        int new_cR = 0;
        int new_cB = 0;

        Character[][] tmp = new Character[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                tmp[i][j] = arr[i][j];
            }
        }
        tmp[rR][cR] = '.';
        tmp[rB][cB] = '.';

        // 공이 홀에 들어갔는지 체크
        boolean goal = false;

        // B가 R보다 더 오른쪽에 있다 -> B부터 옮긴다
        if (cB > cR) {
            for (int i = cB; i < M; i++) {
                if (tmp[rB][i] == '#') {
                    new_cB = i - 1;
                    tmp[rB][new_cB] = 'B';
                    break;
                }
                if (tmp[rB][i] == 'O') {
                    return;
                }
            }

            for (int i = cR; i < M; i++) {
                if (tmp[rR][i] == '#' || tmp[rR][i] == 'B') {
                    new_cR = i - 1;
                    tmp[rR][new_cR] = 'R';
                    break;
                }
                if (tmp[rR][i] == 'O') {
                    goal = true;
                    break;
                }
            }

        }

        // R이 B보다 더 오른쪽에 있다 -> R부터 옮긴다
        else {
            for (int i = cR; i < M; i++) {
                if (tmp[rR][i] == '#') {
                    new_cR = i - 1;
                    tmp[rR][new_cR] = 'R';
                    break;
                }
                if (tmp[rR][i] == 'O') {
                    goal = true;
                    break;
                }
            }

            for (int i = cB; i < M; i++) {
                if (tmp[rB][i] == '#' || tmp[rB][i] == 'R') {
                    new_cB = i - 1;
                    tmp[rB][new_cB] = 'B';
                    break;
                }
                if (tmp[rB][i] == 'O') {
                    return;
                }
            }

        }

        if (goal) {
            ans = Math.min(ans, cnt + 1);
            return;
        }

        if (cR != new_cR || cB != new_cB) {
            solve(tmp, new Node(rR, new_cR, rB, new_cB), cnt + 1);
        }

    }

}