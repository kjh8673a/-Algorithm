import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        int happy = 0;
        int sad = 0;
        for (int i = 0; i < s.length() - 2; i++) {
            String emo = s.substring(i, i + 3);
            if (emo.equals(":-)")) {
                happy++;
            } else if (emo.equals(":-(")) {
                sad++;
            }
        }

        if (happy == 0 && sad == 0) {
            System.out.println("none");
        } else if (happy == sad) {
            System.out.println("unsure");
        } else if (happy > sad) {
            System.out.println("happy");
        } else {
            System.out.println("sad");
        }
    }

}