import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String document = br.readLine();
        String word = br.readLine();

        int answer = 0;
        for (int i = 0; i < document.length() - word.length() + 1; i++) {
            if (document.charAt(i) == word.charAt(0)) {
                String search = document.substring(i, i + word.length());
                if (search.equals(word)) {
                    answer++;
                    i = i + word.length() - 1;
                }
            }
        }

        System.out.println(answer);
    }

}