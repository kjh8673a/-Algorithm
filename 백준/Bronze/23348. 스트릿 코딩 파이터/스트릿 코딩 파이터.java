import java.io.*;
import java.util.*;

public class Main {
    static class Contest {
        int[] difficulty;
        int winner;

        public Contest(int a, int b, int c) {
            difficulty = new int[3];
            difficulty[0] = a;
            difficulty[1] = b;
            difficulty[2] = c;
            winner = 0;
        }

        public void markScore(int[][] arr) {
            int sum = 0;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    sum += arr[i][j] * difficulty[j];
                }
            }

            winner = Math.max(sum, winner);
        }

        public int printWinner() {
            return winner;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        Contest contest = new Contest(a, b, c);

        int n = Integer.parseInt(br.readLine());
        for (int team = 0; team < n; team++) {
            int[][] arr = new int[3][3];
            for (int i = 0; i < 3; i++) {
                st = new StringTokenizer(br.readLine());
                arr[i][0] = Integer.parseInt(st.nextToken());
                arr[i][1] = Integer.parseInt(st.nextToken());
                arr[i][2] = Integer.parseInt(st.nextToken());
            }

            contest.markScore(arr);
        }

        System.out.println(contest.printWinner());
    }

}
