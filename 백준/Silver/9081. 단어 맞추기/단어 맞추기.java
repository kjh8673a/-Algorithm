import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int tc = 0; tc < T; tc++) {
            String word = br.readLine();
            int[] arr = new int[word.length()];
            for (int i = 0; i < word.length(); i++) {
                arr[i] = word.charAt(i) - 65;
            }

            ArrayList<Integer> list = new ArrayList<>();
            int idx = -1;
            for (int i = arr.length - 1; i > 0; i--) {
                list.add(arr[i]);
                if (arr[i] > arr[i - 1]) {
                    idx = i - 1;
                    break;
                }
            }

            if (idx == -1) {
                sb.append(word).append("\n");
            } else {
                for (int i = 0; i < list.size(); i++) {
                    if (list.get(i) > arr[idx]) {
                        list.add(arr[idx]);
                        arr[idx] = list.get(i);
                        list.remove(i);
                        break;
                    }
                }

                Collections.sort(list);

                for (int i = 0; i <= idx; i++) {
                    sb.append((char) (arr[i] + 65));
                }
                for (Integer i : list) {
                    sb.append((char) (i + 65));
                }
                sb.append("\n");
            }
        }

        System.out.println(sb.toString());
    }

}