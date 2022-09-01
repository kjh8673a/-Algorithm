import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            Deque<Integer> deque = new LinkedList<>();

            String func = br.readLine();
            char[] function = new char[func.length()];

            for (int j = 0; j < func.length(); j++) {
                function[j] = func.charAt(j);
            }

            int n = Integer.parseInt(br.readLine());

            String str = br.readLine();

            if (n != 0) {
                str = str.replace("[", "");
                str = str.replace("]", "");
                for (String val : str.split(",")) {
                    deque.add(Integer.parseInt(val));
                }
            }

            boolean isReverse = false;
            boolean isError = false;
            for (int j = 0; j < function.length; j++) {
                if (function[j] == 'R') {
                    isReverse = !isReverse;
                } else if (deque.isEmpty() && function[j] == 'D') {
                    isError = true;
                    break;
                } else if (function[j] == 'D' && isReverse) {
                    deque.pollLast();
                }

                else if (function[j] == 'D' && !isReverse) {
                    deque.pollFirst();
                }

            }

            if (isError) {
                sb.append("error").append("\n");
            } else {
                if (!isReverse) {
                    String ans = deque.toString();
                    ans = ans.replaceAll(" ", "");
                    sb.append(ans).append("\n");
                }

                else if (isReverse) {
                    sb.append("[");
                    int len = deque.size();

                    for (int j = 0; j < len; j++) {
                        if (j == len - 1) {
                            sb.append(deque.pollLast());
                            break;
                        }
                        sb.append(deque.pollLast()).append(",");
                    }
                    sb.append("]").append("\n");
                }

            }

        }

        System.out.println(sb.toString());

    }

}