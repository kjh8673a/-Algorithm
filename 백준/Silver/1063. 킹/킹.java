import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String king = st.nextToken();
        String stone = st.nextToken();
        int n = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            String move = br.readLine();

            String nextKing = makeMove(move, king);
            String nextStone = stone;
            if (nextKing.equals("INVALID")) {
                continue;
            }

            if (nextKing.equals(stone)) {
                nextStone = makeMove(move, stone);
                if (nextStone.equals("INVALID")) {
                    continue;
                }
            }

            king = nextKing;
            stone = nextStone;
        }

        System.out.println(king);
        System.out.println(stone);
    }

    private static String makeMove(String move, String target) {
        int r = target.charAt(0) - 'A' + 1;
        int c = target.charAt(1) - '0';

        switch (move) {
            case "R":
                r++;
                break;
            case "L":
                r--;
                break;
            case "B":
                c--;
                break;
            case "T":
                c++;
                break;
            case "RT":
                r++;
                c++;
                break;
            case "LT":
                r--;
                c++;
                break;
            case "RB":
                r++;
                c--;
                break;
            case "LB":
                r--;
                c--;
                break;
        }

        if (r <= 0 || c <= 0 || r > 8 || c > 8) {
            return "INVALID";
        }

        return String.valueOf((char) (r + 'A' - 1) + "" + c);
    }

}