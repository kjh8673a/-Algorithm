import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        double[] height = new double[N + 1];
        for (int i = 0; i < N + 1; i++) {
            height[i] = Double.parseDouble(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        double[] width = new double[N];
        for (int i = 0; i < N; i++) {
            width[i] = Double.parseDouble(st.nextToken());
        }

        double sum = 0;
        for (int i = 0; i < N; i++) {
            sum += width[i] * (height[i] + height[i + 1]) / 2;
        }
        System.out.println(sum);
    }

}
