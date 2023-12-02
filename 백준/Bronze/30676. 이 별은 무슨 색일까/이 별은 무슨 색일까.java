import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int wavelength = Integer.parseInt(br.readLine());

        int[] range = { 425, 450, 495, 570, 590, 620, 781 };
        String[] color = { "Violet", "Indigo", "Blue", "Green", "Yellow", "Orange", "Red" };

        for (int i = 0; i < 7; i++) {
            if (wavelength < range[i]) {
                System.out.println(color[i]);
                break;
            }
        }
    }
}