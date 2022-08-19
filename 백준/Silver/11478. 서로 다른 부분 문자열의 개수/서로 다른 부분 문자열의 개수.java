import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Map<String, Integer> map = new HashMap<>();

        String str = br.readLine();

        for(int i = 0; i < str.length(); i++) {
            for(int j = 1; j <= str.length(); j++) {
                if(i+j <= str.length()) {
                    map.put(str.substring(i, i+j), i);
                }else {
                    break;
                }
            }
        }

        System.out.println(map.size());
        
    }

}