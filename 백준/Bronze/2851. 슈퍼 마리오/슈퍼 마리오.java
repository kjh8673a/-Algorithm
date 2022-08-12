import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int min = Integer.MAX_VALUE;
        int ans = 0;
        int n = 0;
        for(int i = 0; i < 10; i++) {
            int num =  Integer.parseInt(br.readLine());
            n += num;
            if(Math.abs(100-n) <= min) {
                ans = n;
            }
            min = Math.min(min, Math.min(min, Math.abs(100-n)));
        }

        sb.append(ans);

        System.out.println(sb.toString());       

    }

}