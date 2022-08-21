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
            int[] arr = new int[11]; // 수의 범위 : 0 ~ 10

            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i = 0; i < 5; i++) {
                int score = Integer.parseInt(st.nextToken());
                arr[score]++;
            }

            int cnt = 0;
            int sum = 0;
            int min = 0;
            int max = 0;
            for(int i = 0; i < arr.length; i++) {
                while(arr[i]-- > 0) {
                    cnt++;
                    
                    if(cnt != 1 && cnt != 5) sum += i;

                    if(cnt == 2) min = i;
                    else if(cnt == 4) max = i;
                }
            }

            if(max - min >= 4) {
                sb.append("KIN").append("\n");
            }else {
                sb.append(sum).append("\n");
            }

        }

        System.out.println(sb.toString());

    }

}
