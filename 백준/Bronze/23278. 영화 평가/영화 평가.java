import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());

        int[] arr = new int[101];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            arr[Integer.parseInt(st.nextToken())]++;
        }

        int cnt = 0;
        double sum = 0;

        loop :
        for(int i = 0; i < arr.length; i++) {
            while(arr[i]-- > 0) {
                cnt++;
                if(cnt > L && cnt <= N-H) {
                    sum += i;
                }
                if(cnt == N-H) {
                    break loop;
                }
            }
        }

        System.out.println(sum / (N-L-H));
        
    }

}
