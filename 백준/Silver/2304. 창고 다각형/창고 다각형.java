import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] high = new int[1001];

        int start = Integer.MAX_VALUE;
        int end = Integer.MIN_VALUE;
        int top = 0;

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            start = Math.min(start, a);
            end = Math.max(end, a);

            high[a] = b;

            if(high[top] < high[a]) {
                top = a;
            }
        }

        int sum = 0;
        int height = 0;
        for(int i = start; i < top; i++) {
            height = Math.max(height, high[i]);
            sum+= height;
        }

        height = 0;
        for(int i = end; i > top; i--) {
            height = Math.max(height, high[i]);
            sum += height;
        }

        System.out.println(sum + high[top]);

    }

}
