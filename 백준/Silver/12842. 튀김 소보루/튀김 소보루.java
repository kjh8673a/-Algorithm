import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());

        int m = Integer.parseInt(br.readLine());
        int[] arr = new int[m];
        for(int i = 0; i < m; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        
        int cnt = n - s;
        int time = 0;
        int ans = 0;
        while(cnt > 0) {
            for(int i = 0; i < m; i++) {
                if(time % arr[i] == 0) {
                    ans = i + 1;
                    cnt--;
                }
                if(cnt == 0) {
                    break;
                }
            }
            time++;
        }

        System.out.println(ans);

    }

}