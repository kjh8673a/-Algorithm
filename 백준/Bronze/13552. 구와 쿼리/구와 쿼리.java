import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int[][] dot = new int[N][3];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            dot[i][0] = Integer.parseInt(st.nextToken());
            dot[i][1] = Integer.parseInt(st.nextToken());
            dot[i][2] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());

        for (int i = 0; i < M; i++) {
            int ans = 0;
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            long rPow = 1l * r * r;

            for (int j = 0; j < N; j++) {
                if (getDistance(dot[j], x, y, z) <= rPow) {
                    ans++;
                }
            }
            sb.append(ans).append("\n");
        }

        System.out.println(sb.toString());

    }

    public static long getDistance(int[] arr, int x, int y, int z) {
        int a = arr[0] - x;
        int b = arr[1] - y;
        int c = arr[2] - z;
        return 1l * a * a + 1l * b * b + 1l * c * c;
    }

}