import java.io.*;
import java.util.*;

public class Main {
    static int lose;
    static boolean[] base;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        lose = 0;
        base = new boolean[3];
        int ball = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int th = Integer.parseInt(st.nextToken());
            if (th == 1) {
                ball++;
            }

            if (th == 3) {
                wildPitch();
                ball++;
            }

            if (th == 2 || ball == 4) {
                moveRunner();
                ball = 0;
            }
        }

        System.out.println(lose);
    }

    private static void wildPitch() {
        if (base[2]) {
            lose++;
            base[2] = false;
        }

        if (base[1]) {
            base[2] = true;
            base[1] = false;
        }

        if (base[0]) {
            base[1] = true;
            base[0] = false;
        }
    }

    private static void moveRunner() {
        if (base[0]) {
            if (base[1]) {
                if (base[2]) {
                    lose++;
                } else {
                    base[2] = true;
                }
            } else {
                base[1] = true;
            }
        } else {
            base[0] = true;
        }
    }

}