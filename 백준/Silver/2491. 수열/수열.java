import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int max = 0;
        int cntUp = 0;
        int cntDown = 0;

        int num = 0;
        int tmpUp = Integer.MAX_VALUE;
        int tmpDown = Integer.MIN_VALUE;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            num = Integer.parseInt(st.nextToken());
            if (num >= tmpUp) {
                cntUp++;
            } else {
                max = Math.max(max, cntUp+1);
                cntUp = 0;
            }

            if(num <= tmpDown) {
                cntDown++;
            }else {
                max = Math.max(max, cntDown+1);
                cntDown = 0;
            }

            if (i == n - 1) {
                max = Math.max(max, cntUp+1);
                max = Math.max(max, cntDown+1);
            }

            tmpUp = num;
            tmpDown = num;
        }

        System.out.println(max);

    }

}
