import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int k = Integer.parseInt(br.readLine());

        // 구하는 수가 몇자리인지
        int n = 1;
        while(Math.pow(2, n+1) - 2 < k) {
            n++;
        }

        String ans = "";

        // n자리에 제일 큰 수는 top번째 수이고,
        // 제일 작은 수는 bottom번째 수이다.
        long top = (long)(Math.pow(2, n+1)-2);
        long bottom = (long)(Math.pow(2, n)-2) + 1;

        while(n > 0) {

            // 구하는 수의 인덱스가 top보다 bottom에 더 가까우면 4를 더하고
            // top에 더 가까우면 7을 더한다
            if(top-k > k-bottom) {
                ans += "4";
                top = bottom + (top-bottom)/2;
            }else {
                ans += "7";
                bottom = top - (top-bottom)/2;
            }

            n--;

        }

        System.out.println(ans);
    }

}