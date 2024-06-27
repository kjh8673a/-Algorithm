import java.io.*;
import java.util.*;

public class Main {
    static boolean[][] star;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        star = new boolean[3000][3000];
        if (n % 2 == 0) {
            drawStar(n, 0, 0);
        } else {
            drawStar(n, (int) Math.pow(2, n) - 2, 0);
        }

        printStar(n);
    }

    private static void printStar(int len) {
        int height = (int) Math.pow(2, len) - 1;
        int width = 2 * height - 1;

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < height; i++) {
            String tmp = "";
            for (int j = 0; j < width; j++) {
                if (star[i][j]) {
                    tmp += "*";
                } else {
                    tmp += " ";
                }
            }
            sb.append(tmp.stripTrailing()).append("\n");
        }

        System.out.println(sb);
    }

    private static void drawStar(int len, int r, int c) {
        if (len == 1) {
            star[r][c] = true;
            return;
        }

        if (len % 2 == 0) {
            int height = (int) Math.pow(2, len) - 1;
            int width = 0;
            for (int i = r; i <= r + (height - 1); i++) {
                star[i][c + width++] = true;
            }
            for (int i = r + (height - 1) - 1; i > r; i--) {
                star[i][c + width++] = true;
            }
            for (int i = c + width; i >= c; i--) {
                star[r][i] = true;
            }
            drawStar(len - 1, r + (height - 1) / 2, c + height / 2 + 1);
        } else {
            int height = (int) Math.pow(2, len) - 1;
            int width = 0;
            for (int i = r; i >= r - (height - 1); i--) {
                star[i][c + width++] = true;
            }
            for (int i = r - (height - 1) + 1; i < r; i++) {
                star[i][c + width++] = true;
            }
            for (int i = c + width; i >= c; i--) {
                star[r][i] = true;
            }

            drawStar(len - 1, r - (height - 1) / 2, c + height / 2 + 1);
        }
    }

}