import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static long max = Integer.MIN_VALUE;
    static int[] honey;
    static long[] leftsum;
    static long[] rightsum;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        honey = new int[n];
        leftsum = new long[n];
        rightsum = new long[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        long tmp = 0;
        for (int i = 0; i < n; i++) {
            honey[i] = Integer.parseInt(st.nextToken());
            tmp += honey[i];
            leftsum[i] = tmp;
        }

        tmp = 0;
        for(int i = n-1; i >= 0; i--) {
            tmp += honey[i];
            rightsum[i] = tmp;
        }

        // 벌 벌 꿀통
        for (int i = 1; i < n - 1; i++) {
            bee1(0, i, n-1);
        }

        // 꿀통 벌벌
        for(int i = n-2; i > 0; i--) {
            bee2(i, n-1, 0);
        }

        // 벌 꿀통 벌
        for(int i = 1; i < n-1; i++) {
            bee3(0, n-1, i);
        }

        System.out.println(max);

    }

    public static void bee1(int x, int y, int goal) {
        long bee1 = leftsum[goal] - honey[x] - honey[y];
        long bee2 = leftsum[goal] - leftsum[y];
        
        max = Math.max(max, bee1+bee2);
    }

    public static void bee2(int x, int y, int goal) {
        long bee1 = leftsum[y] - rightsum[x];
        long bee2 = leftsum[y] - honey[y] - honey[x];
        
        max = Math.max(max, bee1+bee2);
    }

    public static void bee3(int x, int y, int goal) {
        long bee1 = leftsum[goal] - honey[x];
        long bee2 = rightsum[goal] - honey[y];
        
        max = Math.max(max, bee1+bee2);
    }

}