import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        
        int[] arr = new int[101];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < 3; i++) {
            int num = Integer.parseInt(st.nextToken());
            arr[num]++;
        }

        int cnt = 0;
        for(int i = 0; i < arr.length; i++) {
            while(arr[i]-- > 0) {
                cnt++;
                if(cnt == 2) {
                    System.out.println(i);
                }
            }
        }
        
    }

}
