import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        Map<Double, String> map = new HashMap<>();

        for(int i = 0; i < n; i++) {
            String word = br.readLine();
            double key = (double) word.length();
            for(int j = 0; j < word.length(); j++) {
                key += (word.toUpperCase().charAt(j)-0) * Math.pow(0.01, j+1);
            }
            map.put(key, word);
        }

        double[] arr = new double[n];
        int idx = 0;
        for(Double nKey : map.keySet()) {
            arr[idx++] = nKey;
        }

        Arrays.sort(arr);

        for(int i = 0; i < arr.length; i++) {
            if(map.containsKey(arr[i])) {
                sb.append(map.get(arr[i])).append("\n");
            }
        }
        
        System.out.println(sb.toString());
    }

}