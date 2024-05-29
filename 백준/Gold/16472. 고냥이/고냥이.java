import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String input = br.readLine();

        int[] alphabet = new int[26];

        int left = 0;
        int right = 0;
        int cnt = 0;
        int answer = 0;

        alphabet[input.charAt(0) - 97]++;
        cnt++;
        while (right < input.length() - 1) {

            if (cnt <= n) {
                right++;
                if (alphabet[input.charAt(right) - 97] == 0) {
                    cnt++;
                }
                alphabet[input.charAt(right) - 97]++;
            } else {
                alphabet[input.charAt(left) - 97]--;
                if (alphabet[input.charAt(left) - 97] == 0) {
                    cnt--;
                }
                left++;
            }

            if (cnt <= n) {
                answer = Math.max(answer, right - left + 1);
            }
        }

        System.out.println(answer);
    }
}