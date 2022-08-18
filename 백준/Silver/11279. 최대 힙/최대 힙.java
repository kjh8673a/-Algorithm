import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[] arr;
    static int top;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        arr = new int[n+1];
        top = -1;

        for(int i = 0; i < n; i++) {
            int now = Integer.parseInt(br.readLine());
            if(top == -1 && now == 0) {
                sb.append(0).append("\n");
            }else if(now == 0) {
                sb.append(arr[top--]).append("\n");
            }else {
                add(now);
            }
        }

        System.out.println(sb.toString());
    }

    public static void add(int now) {
        if(top == -1) {
            arr[++top] = now;
        }else {
            top += 1;
            int i = top-1;
            while(i >= 0 && now < arr[i]) {
                arr[i+1] = arr[i];
                i--;
            }
            arr[i+1] = now;
        }
    }

}