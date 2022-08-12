import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        Map<String, String> keyboard = new HashMap<String, String>() {
            {
                put("1", "`");
                put("2", "1");
                put("3", "2");
                put("4", "3");
                put("5", "4");
                put("6", "5");
                put("7", "6");
                put("8", "7");
                put("9", "8");
                put("0", "9");
                put("-", "0");
                put("=", "-");

                put("W", "Q");
                put("E", "W");
                put("R", "E");
                put("T", "R");
                put("Y", "T");
                put("U", "Y");
                put("I", "U");
                put("O", "I");
                put("P", "O");
                put("[", "P");
                put("]", "[");
                put("\\", "]");

                put("S", "A");
                put("D", "S");
                put("F", "D");
                put("G", "F");
                put("H", "G");
                put("J", "H");
                put("K", "J");
                put("L", "K");
                put(";", "L");
                put("'", ";");

                put("X", "Z");
                put("C", "X");
                put("V", "C");
                put("B", "V");
                put("N", "B");
                put("M", "N");
                put(",", "M");
                put(".", ",");
                put("/", ".");
            }
        };
        String str = "";
        while((str = br.readLine()) != null) {
            sb.setLength(0);
            for(int i = 0; i < str.length(); i++){
                if(keyboard.containsKey(String.valueOf(str.charAt(i)))) {
                    sb.append(keyboard.get(String.valueOf(str.charAt(i))));
                }else {
                    sb.append(String.valueOf(str.charAt(i)));
                }
            }
            System.out.println(sb.toString());
        }
        
    }

}