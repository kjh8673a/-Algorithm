import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static Long[][] arr;
    static long a;
    
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());

        arr = new Long[n][10];

        // 한자리 수는 1로 설정
        for(int i = 0; i < 10; i++) {
            arr[0][i] = 1l;
        }

        long ans = 0;
        a = 1000000000;

        // 맨 앞 숫자는 1~9만 나올수있다
        for(int i = 1; i <= 9; i++) {
            ans += solve(n-1, i);
        }

        System.out.println(ans % a);
    }

    public static long solve(int num, int val) {

        if(num == 0) {
            return arr[num][val];
        }else if(arr[num][val] == null) {
            // 0일경우 다음 자리에는 1밖에 못온다
            if(val == 0) {
                arr[num][val] = solve(num-1, 1);
            }
            // 9일경우 다음 자리에는 8만 올수있다
            else if(val == 9) {
                arr[num][val] = solve(num-1, 8);
            }
            // 그 외 경우에는 앞자리수 +-1씩 한 것들의 합
            else {
                arr[num][val] = solve(num-1, val+1) + solve(num-1, val-1);
            }
        }

        return arr[num][val] % a;
    }

    
}