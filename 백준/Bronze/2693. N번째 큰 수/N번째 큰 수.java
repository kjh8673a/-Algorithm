import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());

        for(int tc = 0; tc < t; tc++) {
            int[] arr = new int[1001];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i = 0; i < 10; i++) {
                int num = Integer.parseInt(st.nextToken());
                arr[num]++;
            }

            int cnt = 0;
            loop : 
            for(int i = arr.length-1; i >= 0; i--) {
                while(arr[i]-- > 0) {
                    cnt++;
                    if(cnt == 3) {
                        sb.append(i).append("\n");
                        break loop;
                    }
                }
            }

        }

        System.out.println(sb.toString());

    }

}
