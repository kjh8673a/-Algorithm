import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[][] list = new int[10][2];
        StringTokenizer st;
        for (int i = 0; i < 9; i++) {
            st = new StringTokenizer(br.readLine());
            list[i][0] = Integer.parseInt(st.nextToken());
            list[i][1] = Integer.parseInt(st.nextToken());
        }

        int answer = -1;
        for (int i = 1; i < 10; i++) {
            int liars = 0;
            for (int j = 0; j < 9; j++) {
                if (list[j][0] == 1) {
                    if (list[j][1] != i) {
                        liars++;
                    }
                } else {
                    if (list[j][1] == i) {
                        liars++;
                    }
                }
            }

            if (liars == 1) {
                if (answer == -1) {
                    answer = i;
                } else {
                    System.out.println(-1);
                    return;
                }
            }
        }

        System.out.println(answer);
    }
}