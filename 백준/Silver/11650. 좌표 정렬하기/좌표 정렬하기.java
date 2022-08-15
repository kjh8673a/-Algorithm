import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        double[] arr = new double[T];

        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            double a = Integer.parseInt(st.nextToken());
            double b = Integer.parseInt(st.nextToken());

            arr[i] = a+100000 + (b+100000)/1000000;
        }

        Arrays.sort(arr);

        for(int i = 0; i < T; i++) {
            int d = (int) arr[i];
            int ansA = d - 100000;
            int ansB = (int) (Math.round((arr[i] - d) * 1000000) - 100000);
            sb.append(ansA + " " + ansB + "\n");
        }

        System.out.println(sb.toString());

    }

}