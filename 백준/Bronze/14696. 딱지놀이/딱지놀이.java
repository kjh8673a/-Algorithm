import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        Map<Integer, Integer> mapA = new HashMap<>();
        Map<Integer, Integer> mapB = new HashMap<>();
        int idxA = 1;
        int idxB = 1;
        for (int i = 1; i <= n * 2; i++) {
            String card = br.readLine();
            String[] split = card.split(" ");

            int value = 0;
            for (int j = 1; j < split.length; j++) {
                switch (Integer.parseInt(split[j])) {
                    case 4:
                        value += 4000000;
                        break;
                    case 3:
                        value += 30000;
                        break;
                    case 2:
                        value += 200;
                        break;
                    case 1:
                        value += 1;
                        break;
                }
            }
            if (i % 2 != 0) {
                mapA.put(idxA++, value);
            } else {
                mapB.put(idxB++, value);
            }
        }

        for (int i = 1; i <= n; i++) {
            if (mapA.get(i) > mapB.get(i)) {
                sb.append("A");
            } else if (mapA.get(i) < mapB.get(i)) {
                sb.append("B");
            } else {
                sb.append("D");
            }
            sb.append("\n");
        }

        System.out.println(sb.toString());

    }

}