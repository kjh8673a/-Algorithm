import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();

        HashMap<Integer, Integer> two = new HashMap<>() {
            {
                put(1, 2);
                put(2, 4);
                put(3, 8);
                put(0, 6);
            }
        };

        HashMap<Integer, Integer> three = new HashMap<>() {
            {
                put(1, 3);
                put(2, 9);
                put(3, 7);
                put(0, 1);
            }
        };

        HashMap<Integer, Integer> four = new HashMap<>() {
            {
                put(1, 4);
                put(0, 6);
            }
        };

        HashMap<Integer, Integer> seven = new HashMap<>() {
            {
                put(1, 7);
                put(2, 9);
                put(3, 3);
                put(0, 1);
            }
        };

        HashMap<Integer, Integer> eight = new HashMap<>() {
            {
                put(1, 8);
                put(2, 4);
                put(3, 2);
                put(0, 6);
            }
        };

        HashMap<Integer, Integer> nine = new HashMap<>() {
            {
                put(1, 9);
                put(0, 1);
            }
        };

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            switch (a % 10) {
                case 0:
                    sb.append(10);
                    break;
                case 1:
                    sb.append(1);
                    break;
                case 2:
                    sb.append(two.get(b % 4));
                    break;
                case 3:
                    sb.append(three.get(b % 4));
                    break;
                case 4:
                    sb.append(four.get(b % 2));
                    break;
                case 5:
                    sb.append(5);
                    break;
                case 6:
                    sb.append(6);
                    break;
                case 7:
                    sb.append(seven.get(b % 4));
                    break;
                case 8:
                    sb.append(eight.get(b % 4));
                    break;
                case 9:
                    sb.append(nine.get(b % 2));
                    break;
            }
            sb.append("\n");
        }

        System.out.println(sb.toString());

    }

}