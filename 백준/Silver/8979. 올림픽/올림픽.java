import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        Map<Integer, Double> map = new HashMap<>();
        double[] count = new double[n];
        
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            int gold = Integer.parseInt(st.nextToken());
            int silver = Integer.parseInt(st.nextToken());
            int bronze = Integer.parseInt(st.nextToken());

            double score = gold * Math.pow(10, 6) + silver + bronze * Math.pow(10, -6);

            map.put(num, score);
            count[i] = score;
        }

        Double[] tmp = Arrays.stream(count).boxed().toArray(Double[]::new);
        Arrays.sort(tmp, Comparator.reverseOrder());

        if(map.get(k).equals(tmp[0])) {
            System.out.println(1);
        }else {
            int rank = 1;
            int keep = 1;
            for(int i = 1; i < n; i++) {
                if(!tmp[i].equals(tmp[i-1])) {
                    rank += keep;
                    keep = 0;
                    keep++;
                }else {
                    keep++;
                }
                if(map.get(k).equals(tmp[i])) {
                    System.out.println(rank);
                    break;
                }
            }
        }

    }

}
