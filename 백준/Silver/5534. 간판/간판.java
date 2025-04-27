import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        char[] name = br.readLine().toCharArray();

        int answer = 0;
        for (int i = 0; i < n; i++) {
            String s = br.readLine();

            loop: for (int j = 0; j < s.length(); j++) {

                if (s.charAt(j) == name[0]) {
                    for (int k = j + 1; k < s.length(); k++) {

                        if (s.charAt(k) == name[1]) {
                            int jump = k - j;
                            int idx = k + jump;
                            for (int l = 2; l < name.length; l++) {
                                if (idx < s.length() && s.charAt(idx) == name[l]) {
                                    idx += jump;
                                    if (l == name.length - 1) {
                                        answer++;
                                        break loop;
                                    }
                                } else {
                                    break;
                                }
                            }
                        }
                    }
                }
            }
        }

        System.out.println(answer);
    }

}