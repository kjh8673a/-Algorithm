import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        for (int tc = 0; tc < t; tc++) {
            st = new StringTokenizer(br.readLine());

            int scoreA = calculateScore(st);
            int scoreB = calculateScore(st);

            sb.append("SCORE: " + scoreA + " to " + scoreB + ", ");
            if (scoreA > scoreB) {
                sb.append("PLAYER 1 WINS.");
            } else if (scoreA < scoreB) {
                sb.append("PLAYER 2 WINS.");
            } else {
                sb.append("TIE.");
            }
            sb.append("\n");
        }

        System.out.println(sb.toString());
    }

    private static int calculateScore(StringTokenizer st) {
        int result = 0;

        for (int i = 0; i < 3; i++) {
            double x = Double.parseDouble(st.nextToken());
            double y = Double.parseDouble(st.nextToken());

            double distSquare = x * x + y * y;
            if (distSquare <= 3 * 3) {
                result += 100;
            } else if (distSquare <= 6 * 6) {
                result += 80;
            } else if (distSquare <= 9 * 9) {
                result += 60;
            } else if (distSquare <= 12 * 12) {
                result += 40;
            } else if (distSquare <= 15 * 15) {
                result += 20;
            }
        }

        return result;
    }

}