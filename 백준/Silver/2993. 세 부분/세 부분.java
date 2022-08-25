import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();

        ArrayList<String> list = new ArrayList<>();

        for (int i = 1; i < str.length() - 1; i++) {
            for (int j = i + 1; j < str.length(); j++) {
                String result = "";

                result += reverse(0, i, str);
                result += reverse(i, j, str);
                result += reverse(j, str.length(), str);

                list.add(result);
            }

        }
        Collections.sort(list);

        System.out.println(list.get(0));

    }

    public static String reverse(int start, int end, String str) {
        String res = "";

        for (int i = end - 1; i >= start; i--) {
            res += str.charAt(i);
        }

        return res;
    }

}