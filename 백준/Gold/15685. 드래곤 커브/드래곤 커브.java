import java.io.*;
import java.util.*;

public class Main {
    static boolean[][] board = new boolean[101][101];
    static int[][] vector = { { 0, 1 }, { -1, 0 }, { 0, -1 }, { 1, 0 } };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int g = Integer.parseInt(st.nextToken());
            markPointOnBoard(x, y, makeDirectionList(d, g));
        }

        int answer = countSquare();

        System.out.println(answer);
    }

    private static int countSquare() {
        int count = 0;
        for (int i = 1; i < 101; i++) {
            for (int j = 1; j < 101; j++) {
                if (board[i][j] && board[i - 1][j] && board[i][j - 1] && board[i - 1][j - 1]) {
                    count++;
                }
            }
        }

        return count;
    }

    private static void markPointOnBoard(int x, int y, List<Integer> directionList) {
        board[y][x] = true;

        for (int direction : directionList) {
            y += vector[direction][0];
            x += vector[direction][1];
            board[y][x] = true;
        }
    }

    private static List<Integer> makeDirectionList(int d, int g) {
        List<Integer> directionList = new ArrayList<>();
        directionList.add(d);

        for (int i = 0; i < g; i++) {
            for (int j = directionList.size() - 1; j >= 0; j--) {
                directionList.add((directionList.get(j) + 1) % 4);
            }
        }

        return directionList;
    }
}
