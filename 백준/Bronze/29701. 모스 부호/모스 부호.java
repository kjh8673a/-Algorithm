import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Map<String, String> map = new HashMap<>() {
            {
                put(".-", "A");
                put("-...", "B");
                put("-.-.", "C");
                put("-..", "D");
                put(".", "E");
                put("..-.", "F");
                put("--.", "G");
                put("....", "H");
                put("..", "I");
                put(".---", "J");
                put("-.-", "K");
                put(".-..", "L");
                put("--", "M");
                put("-.", "N");
                put("---", "O");
                put(".--.", "P");
                put("--.-", "Q");
                put(".-.", "R");
                put("...", "S");
                put("-", "T");
                put("..-", "U");
                put("...-", "V");
                put(".--", "W");
                put("-..-", "X");
                put("-.--", "Y");
                put("--..", "Z");
                put(".----", "1");
                put("..---", "2");
                put("...--", "3");
                put("....-", "4");
                put(".....", "5");
                put("-....", "6");
                put("--...", "7");
                put("---..", "8");
                put("----.", "9");
                put("-----", "0");
                put("--..--", ",");
                put(".-.-.-", ".");
                put("..--..", "?");
                put("---...", ":");
                put("-....-", "-");
                put(".--.-.", "@");
            }
        };

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] codes = br.readLine().split(" ");

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(map.get(codes[i]));
        }

        System.out.println(sb.toString());
    }

}