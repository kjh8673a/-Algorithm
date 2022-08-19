import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());

        int[] circle = new int[n];

        for(int i = 0; i < n; i++) {
            circle[i] = 0;
        }

        int now = 0;
        int cnt = 0;
        while(true) {
            circle[now]++;
            if(circle[now] == m) break;
            
            if(circle[now] % 2 != 0) {
                now = (now + l) % n;
            }else {
                now = (n + now - l) % n;
            }
            cnt++;
        }

        System.out.println(cnt);

    }

}