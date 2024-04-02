import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        boolean answer = true;

        int idx = 0;
        int dir = 1;
        st = new StringTokenizer(br.readLine());
        if (n > 1) {
            for (int i = 0; i < n; i++) {
                int num = Integer.parseInt(st.nextToken());
                if (i == 0) {
                    idx = findStartPoint(num);
                } else if (i == 1) {
                    dir = findDirection(idx, num);
                    if (arr[(idx + n + dir) % n] != num) {
                        answer = false;
                        break;
                    }
                } else {
                    if (arr[(idx + n + dir * i) % n] != num) {
                        answer = false;
                        break;
                    }
                }
            }
        }

        System.out.println(answer ? "good puzzle" : "bad puzzle");
    }

    private static int findDirection(int idx, int num) {
        if (arr[(idx + 1) % n] == num) {
            return 1;
        }

        return -1;
    }

    private static int findStartPoint(int num) {
        for (int i = 0; i < n; i++) {
            if (arr[i] == num) {
                return i;
            }
        }

        return 0;
    }

}