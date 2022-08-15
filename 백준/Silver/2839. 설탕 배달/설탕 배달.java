import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        // 5킬로그램 봉지 개수
        int five = n / 5;

        // 3킬로그램 봉지 개수
        int three = (n % 5) / 3;


        // n을 5로 나눈 나머지가 3으로 나누어 떨어지면 그게 베스트
        // 3으로 나누어떨어지지 않으면...
        if((n % 5) % 3 != 0) {
            // 5킬로그램 봉지를 최대에서 하나씩 줄여가면서 3으로 나눠본다
            for(int i = n / 5; i >= 0; i--) {
                if((n-5*i) % 3 == 0) {
                    five = i;
                    three = (n-5*i) / 3;
                    break;
                }else {
                    five = 0;
                    three = -1;
                }
            }
        }

        System.out.println(five + three);

    }

}