import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());

        for(int tc = 0; tc < t; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            double x1 = Integer.parseInt(st.nextToken());
            double y1 = Integer.parseInt(st.nextToken());
            double x2 = Integer.parseInt(st.nextToken());
            double y2 = Integer.parseInt(st.nextToken());

            int n = Integer.parseInt(br.readLine());

            Map<Integer, Integer> map1 = new HashMap<>();
            Map<Integer, Integer> map2 = new HashMap<>();

            for(int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                double Cx = Integer.parseInt(st.nextToken());
                double Cy = Integer.parseInt(st.nextToken());
                double r = Integer.parseInt(st.nextToken());

                if(Math.pow(Cx-x1, 2) + Math.pow(Cy-y1, 2) < Math.pow(r, 2)) {
                    map1.put(i, i);
                }
                
                if(Math.pow(Cx-x2, 2) + Math.pow(Cy-y2, 2) < Math.pow(r, 2)) {
                    map2.put(i, i);
                }
            }

            int cntX = 0;
            for(int nKey : map1.keySet()) {
                if(!map2.containsKey(nKey)) {
                    cntX++;
                }
            }

            int cntY = 0;
            for(int nKey : map2.keySet()) {
                if(!map1.containsKey(nKey)) {
                    cntY++;
                }
            }

            sb.append(cntX+cntY).append("\n");
        }

        System.out.println(sb.toString());

    }

}