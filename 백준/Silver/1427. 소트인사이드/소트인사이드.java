import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String str = br.readLine();

        int[] num = new int[str.length()];

        for(int i = 0; i < str.length(); i++) {
            num[i] = Character.getNumericValue(str.charAt(i));
        }

        Arrays.sort(num);

        for(int i = num.length-1; i >= 0; i--) {
            sb.append(num[i]);
        }

        System.out.println(sb.toString());

    }

}