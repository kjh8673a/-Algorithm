import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int[] w_arr = new int[101]; // 수의 범위 : 0 ~ 100
        int[] k_arr = new int[101];

        int w_sum = 0;
        int k_sum = 0;        

        for(int i = 0; i < 10; i++) { // 주어진 수열의 크기 : 10
            int score = Integer.parseInt(br.readLine());
            w_arr[score]++;
        }

        int cnt = 0;
        loop1 : 
        for(int i = w_arr.length-1; i >= 0; i--) {
            while(w_arr[i]-- > 0) { // arr 값이 0보다 클 경우
                cnt++;
                w_sum += i;
                if(cnt == 3) break loop1;
            }
        }

        for(int i = 0; i < 10; i++) {
            int score = Integer.parseInt(br.readLine());
            k_arr[score]++;
        }

        cnt = 0;
        loop2 :
        for(int i = k_arr.length-1; i >= 0; i--) {
            while(k_arr[i]-- > 0) {
                cnt++;
                k_sum += i;
                if(cnt == 3) break loop2;
            }
        }

        System.out.println(w_sum + " " + k_sum);

    }

}
