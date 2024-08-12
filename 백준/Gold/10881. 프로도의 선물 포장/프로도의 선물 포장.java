import java.io.*;
import java.util.*;

public class Main {
    static class Present {
        int width;
        int height;

        public Present(int w, int h) {
            this.width = w;
            this.height = h;
        }
    }

    static Present[] list;
    static int result;
    static boolean[] visited, pos;
    static int[] sel;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        for (int tc = 0; tc < t; tc++) {
            list = new Present[3];
            for (int i = 0; i < 3; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                list[i] = new Present(a, b);
            }

            result = Integer.MAX_VALUE;

            visited = new boolean[3];
            pos = new boolean[3];
            sel = new int[3];
            permutation(0);

            sb.append(result).append("\n");
        }

        System.out.println(sb.toString());
    }

    private static void permutation(int cnt) {
        if (cnt == 3) {
            calculation1();
            calculation2();
            return;
        }

        for (int i = 0; i < 3; i++) {
            if (visited[i]) {
                continue;
            }
            sel[cnt] = i;
            visited[i] = true;
            pos[cnt] = true;
            permutation(cnt + 1);
            pos[cnt] = false;
            permutation(cnt + 1);
            visited[i] = false;
        }
    }

    private static void calculation2() {
        int width = 0;
        int height = 0;

        for (int i = 0; i < 2; i++) {
            int idx = sel[i];
            if (pos[i]) {
                width = Math.max(width, list[idx].width);
                height += list[idx].height;
            } else {
                width = Math.max(width, list[idx].height);
                height += list[idx].width;
            }
        }

        if (pos[2]) {
            width += list[sel[2]].width;
            height = Math.max(height, list[sel[2]].height);
        } else {
            width += list[sel[2]].height;
            height = Math.max(height, list[sel[2]].width);
        }

        result = Math.min(result, width * height);
    }

    private static void calculation1() {
        int width = 0;
        int height = 0;

        for (int i = 0; i < 3; i++) {
            int idx = sel[i];
            if (pos[i]) {
                width += list[idx].width;
                height = Math.max(height, list[idx].height);
            } else {
                width += list[idx].height;
                height = Math.max(height, list[idx].width);
            }
        }

        result = Math.min(result, width * height);
    }

}