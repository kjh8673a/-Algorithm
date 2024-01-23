import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        char[] numbers_of_A = st.nextToken().toCharArray();
        char[] numbers_of_B = st.nextToken().toCharArray();

        long answer = 0;
        for (int i = 0; i < numbers_of_A.length; i++) {
            int a = Character.getNumericValue(numbers_of_A[i]);
            for (int j = 0; j < numbers_of_B.length; j++) {
                int b = Character.getNumericValue(numbers_of_B[j]);
                answer += a * b;
            }
        }

        System.out.println(answer);
    }

}