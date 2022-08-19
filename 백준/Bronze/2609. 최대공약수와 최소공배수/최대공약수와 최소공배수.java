import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        Map<Integer, Integer> mapA = new HashMap<>();
        while(a > 1) {
            for(int i = 2; i <= a; i++) {
                if(a % i == 0) {
                    mapA.put(i, mapA.getOrDefault(i, 0) + 1);
                    a /= i;
                    break;
                }
            }
        }

        Map<Integer, Integer> mapB = new HashMap<>();
        while(b > 1) {
            for(int i = 2; i <= b; i++) {
                if(b % i == 0) {
                    mapB.put(i, mapB.getOrDefault(i, 0) + 1);
                    b /= i;
                    break;
                }
            }
        }

        int small = 1;
        int big = 1;

        for(int nKey : mapA.keySet()) {
            if(mapB.containsKey(nKey)) {
                small *= Math.pow(nKey, Math.min(mapA.get(nKey), mapB.get(nKey)));
                big *= Math.pow(nKey, Math.max(mapA.get(nKey), mapB.get(nKey)));
            }else {
                big *= Math.pow(nKey, mapA.get(nKey));
            }
        }

        for(int nKey : mapB.keySet()) {
            if(!mapA.containsKey(nKey)) {
                big *= Math.pow(nKey, mapB.get(nKey));
            }
        }

        System.out.println(small);
        System.out.println(big);

    }

}