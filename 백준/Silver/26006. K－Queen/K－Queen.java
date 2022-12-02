import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static class Node {
        int r;
        int c;

        public Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    static int[] dr = { 1, -1, 0, 0, 1, -1, 1, -1 };
    static int[] dc = { 0, 0, 1, -1, 1, -1, -1, 1 };
    static int N, K, R, C;
    static Node[] queen;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 체스판의 크기
        K = Integer.parseInt(st.nextToken()); // 흑색 퀸의 개수

        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken()); // 백색 킹의 위치 R, C

        queen = new Node[K];
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken()); // 흑색 퀸의 위치 r, c를 배열에 저장한다
            queen[i] = new Node(r, c);
        }

        if (isCheck(R, C)) {
            if (isMate()) {
                System.out.println("CHECKMATE");
            } else {
                System.out.println("CHECK");
            }
        } else if (isMate()) {
            System.out.println("STALEMATE");
        } else {
            System.out.println("NONE");
        }

    }

    public static boolean isCheck(int a, int b) {
        for (int i = 0; i < K; i++) {
            int r = queen[i].r;
            int c = queen[i].c;
            if (a - r == 0 || b - c == 0 || Math.abs(a - r) == Math.abs(b - c)) {
                return true;
            }
        }
        return false;
    }

    public static boolean isMate() {
        for (int k = 0; k < 8; k++) {
            int nr = R + dr[k];
            int nc = C + dc[k];
            if (nr < 1 || nc < 1 || nr > N || nc > N) {
                continue;
            } else {
                if (!isCheck(nr, nc)) {
                    return false;
                }
            }
        }
        return true;
    }

}