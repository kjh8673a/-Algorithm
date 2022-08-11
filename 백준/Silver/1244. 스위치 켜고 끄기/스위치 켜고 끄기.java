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

        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());

        
        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int mf = Integer.parseInt(st.nextToken());
            int loc = Integer.parseInt(st.nextToken());

            switch(mf) {
                case 1:
                    for(int j = 0; j < n; j++) {
                        if((j+1) % loc == 0) {
                            arr[j] = (arr[j] == 0) ? 1 : 0;
                        }
                    }
                    break;
                case 2:
                    arr[loc-1] = (arr[loc-1] == 0) ? 1 : 0;
                    for(int j = 1; j <= Math.min(n-loc, loc-1); j++) {
                        if(arr[loc-1+j] == arr[loc-1-j]) {
                            arr[loc-1+j] = (arr[loc-1+j] == 0) ? 1 : 0;
                            arr[loc-1-j] = (arr[loc-1-j] == 0) ? 1 : 0;
                        }else {
                            break;
                        }
                    }
            }
        }

        int cnt = 0;
        for(int i = 0; i < n; i++) {
            sb.append(arr[i] + " ");
            cnt++;
            if(cnt % 20 == 0 && i != 0) {
                sb.append("\n");
            }
        }

        System.out.println(sb.toString());
        
    }

}