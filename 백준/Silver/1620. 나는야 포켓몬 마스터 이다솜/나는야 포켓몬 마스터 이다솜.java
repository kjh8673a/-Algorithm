import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        HashMap<Integer, String> pokemon = new HashMap<>();
        HashMap<String, Integer> pokenum = new HashMap<>();

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        for(int i = 1; i < n+1; i++) {
            String name = br.readLine();
            pokemon.put(i, name);
            pokenum.put(name, i);
        }
        
        for(int i = 0; i < m; i++) {
            String str = br.readLine();

            if(isNumeric(str)) {
                sb.append(pokemon.get(Integer.parseInt(str)) + "\n");
            }else {
                
                sb.append(pokenum.get(str) + "\n");
            }
        }

        System.out.println(sb.toString());

    }

    public static boolean isNumeric(String str) {
        for(int i = 0; i < str.length(); i++) {
            if(!Character.isDigit(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }
}