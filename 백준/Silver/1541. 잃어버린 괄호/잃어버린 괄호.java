import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();

        int sum = 0;
        String plus = "";
        String minus = "";
        boolean inMinus = false;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '-' && !inMinus) {
                sum += Integer.parseInt(plus);
                plus = "";
                inMinus = true;
            } else if (str.charAt(i) == '-' && inMinus) {
                sum -= Integer.parseInt(minus);
                minus = "";
            } else if (str.charAt(i) == '+' && !inMinus) {
                sum += Integer.parseInt(plus);
                plus = "";
            } else if (str.charAt(i) == '+' && inMinus) {
                sum -= Integer.parseInt(minus);
                minus = "";
            } else if (i == str.length() - 1 && !inMinus) {
                plus += str.charAt(i);
                sum += Integer.parseInt(plus);
            } else if (i == str.length() - 1 && inMinus) {
                minus += str.charAt(i);
                sum -= Integer.parseInt(minus);
            } else if (inMinus) {
                minus += str.charAt(i);
            } else {
                plus += str.charAt(i);
            }
        }

        System.out.println(sum);
    }

}