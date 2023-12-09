import java.io.*;
import java.util.*;

public class Main {
    static class Shark {
        int row;
        int col;
        int speed;
        int direction;
        int size;

        public Shark(int row, int col, int speed, int direction, int size) {
            this.row = row;
            this.col = col;
            this.speed = speed;
            this.direction = direction;
            this.size = size;
        }
    }

    static int R, C, answer;
    static Shark[][] board;
    static int[][] vector = { { 0, 0 }, { -1, 0 }, { 1, 0 }, { 0, 1 }, { 0, -1 } };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        board = new Shark[R + 1][C + 1];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());
            board[r][c] = new Shark(r, c, s, d, z);
        }

        answer = 0;
        if (M > 0) {
            playFishing(1);
        }

        System.out.println(answer);
    }

    private static void playFishing(int idx) {
        if (idx > C) {
            return;
        }

        catchShark(idx);
        moveShark();
        playFishing(idx + 1);
    }

    private static void moveShark() {
        List<Shark> movingSharks = new ArrayList<>();
        for (int i = 1; i < R + 1; i++) {
            for (int j = 1; j < C + 1; j++) {
                if (board[i][j] != null) {
                    movingSharks.add(board[i][j]);
                    board[i][j] = null;
                }
            }
        }

        for (Shark shark : movingSharks) {
            int r = shark.row;
            int c = shark.col;
            int d = shark.direction;
            int s = shark.speed;

            if (d == 1 || d == 2) {
                s %= (R - 1) * 2;
            } else {
                s %= (C - 1) * 2;
            }

            while (s-- > 0) {
                if (checkIsEnd(r, c, d)) {
                    d = changeDirection(d);
                }
                r += vector[d][0];
                c += vector[d][1];
            }

            if (board[r][c] != null && shark.size < board[r][c].size) {
                continue;
            }

            board[r][c] = new Shark(r, c, shark.speed, d, shark.size);
        }
    }

    private static int changeDirection(int d) {
        int tmp = 0;
        switch (d) {
            case 1:
                tmp = 2;
                break;
            case 2:
                tmp = 1;
                break;
            case 3:
                tmp = 4;
                break;
            case 4:
                tmp = 3;
                break;
        }

        return tmp;
    }

    private static boolean checkIsEnd(int r, int c, int d) {
        if (d == 1 && r == 1) {
            return true;
        } else if (d == 2 && r == R) {
            return true;
        } else if (d == 3 && c == C) {
            return true;
        } else if (d == 4 && c == 1) {
            return true;
        }

        return false;
    }

    private static void catchShark(int idx) {
        for (int i = 1; i < R + 1; i++) {
            if (board[i][idx] != null) {
                answer += board[i][idx].size;
                board[i][idx] = null;
                return;
            }
        }
    }
}