import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        int[] number = new int[n];

        for (int i = 0; i < n; i++) {
            number[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(number);

        int val = number[1] - number[0];

        for(int i = 2; i < n; i++) {
            val = hose(number[i] - number[i-1], val);
        }

        for(int i = 2; i <= val; i++) {

            if(val % i == 0) {
                sb.append(i + " ");
            }
        }

        System.out.println(sb.toString());

    }

    public static int hose(int a, int b) {
        if (a % b != 0) {
            return hose(b, a % b);
        } else {
            return b;
        }
    }

}