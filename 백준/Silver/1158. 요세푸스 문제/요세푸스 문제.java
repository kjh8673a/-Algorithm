import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] yose = new int[n];

        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = i+1;
        }

        int arrIdx = 0;
        int yoseIdx = 0;
        int cnt = 0;
        while(yoseIdx != n) {
            if(arr[arrIdx] != 0) {
                cnt++;
            }
            if(cnt == k) {
                yose[yoseIdx] = arr[arrIdx];
                arr[arrIdx] = 0;
                yoseIdx++;
                cnt = 0;
                
            }
            arrIdx++;
            if(arrIdx == n) arrIdx = 0;
        }

        sb.append("<");
        for(int i = 0; i < yose.length; i++) {
            sb.append(yose[i]);
            if(i != yose.length-1) {
                sb.append(", ");
            }
        }
        sb.append(">");

        System.out.println(sb.toString());

    }

}