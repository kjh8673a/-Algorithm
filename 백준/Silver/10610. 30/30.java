import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = Arrays.stream(br.readLine().split(""))
                .mapToInt(Integer::parseInt)
                .toArray();

        int sum = 0;
        boolean zero = false;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (arr[i] == 0) {
                zero = true;
            }
        }

        if (sum % 3 == 0 && zero) {
            Arrays.sort(arr);
            String answer = "";
            for (int i = arr.length - 1; i >= 0; i--) {
                answer += String.valueOf(arr[i]);
            }

            System.out.println(answer);
        } else {
            System.out.println(-1);
        }
    }

}