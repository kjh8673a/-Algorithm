import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        int[] number = new int[N];

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            number[i] = num;
            max = Math.max(max, num);
            min = Math.min(min, num);
        }

        int[] arr = new int[max + 1 - min];
        for (int i = 0; i < N; i++) {
            arr[number[i] - min]++;
        }

        for (int i = 0; i < arr.length; i++) {
            while (arr[i]-- > 0) {
                sb.append((i + min) + " ");
            }
        }

        System.out.println(sb.toString());

    }

}