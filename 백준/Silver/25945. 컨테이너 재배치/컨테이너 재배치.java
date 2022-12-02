import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        long sum = 0;
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            sum += arr[i];
        }

        int h = (int) (sum / n);

        int plus = 0;
        int minus = 0;
        for(int i = 0; i < n; i++) {
            if(arr[i] - h > 1) {
                plus += arr[i] - h - 1;
            }else if(arr[i] - h < 0) {
                minus += arr[i] - h;
            }
        }

        System.out.println(Math.max(plus, Math.abs(minus)));

    }

}