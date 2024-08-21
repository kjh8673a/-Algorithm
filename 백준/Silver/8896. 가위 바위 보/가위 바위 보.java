import java.io.*;
import java.util.*;

public class Main {
    static int n, round;
    static String[] arr;
    static boolean[] defeated;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int tc = 0; tc < t; tc++) {
            n = Integer.parseInt(br.readLine());

            arr = new String[n];
            for (int i = 0; i < n; i++) {
                arr[i] = br.readLine();
            }

            round = arr[0].length();
            defeated = new boolean[n];
            doGame(0);

            int answer = 0;
            for (int i = 0; i < n; i++) {
                if (!defeated[i]) {
                    if (answer == 0) {
                        answer = i + 1;
                    } else {
                        answer = 0;
                        break;
                    }
                }
            }

            sb.append(answer).append("\n");
        }

        System.out.println(sb);
    }

    private static void doGame(int idx) {
        if (idx == round) {
            return;
        }

        int s = 0;
        int r = 0;
        int p = 0;
        for (int i = 0; i < n; i++) {
            if (!defeated[i]) {
                if (arr[i].charAt(idx) == 'S') {
                    s++;
                } else if (arr[i].charAt(idx) == 'R') {
                    r++;
                } else {
                    p++;
                }
            }
        }

        char win = 0;
        if (s > 0 && r > 0 && p == 0) {
            win = 'R';
        } else if (s > 0 && r == 0 && p > 0) {
            win = 'S';
        } else if (s == 0 && r > 0 && p > 0) {
            win = 'P';
        }

        if (win != 0) {
            int count = 0;
            for (int i = 0; i < n; i++) {
                if (!defeated[i]) {
                    if (arr[i].charAt(idx) != win) {
                        defeated[i] = true;
                    } else {
                        count++;
                    }
                }
            }
            if (count > 1) {
                doGame(idx + 1);
            }
        } else {
            doGame(idx + 1);
        }
    }

}
