import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String str = br.readLine();

        int[] numbers = new int[10]; // 각 자리수(0~9) 카운트할 배열

        for(int i = 0; i < str.length(); i++) {
            int num = str.charAt(i) - '0';
            numbers[num]++;
        }
        
        // 9부터 내려오면서 numbers배열의 개수만큼 해당 번호 출력
        for(int i = 9; i >= 0; i--) {
            while(numbers[i]-- > 0) {
                sb.append(i);
            }
        }

        System.out.println(sb);
    }

}