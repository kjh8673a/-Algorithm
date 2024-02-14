import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        line = line.replace("apa", "_a_");
        line = line.replace("epe", "_e_");
        line = line.replace("ipi", "_i_");
        line = line.replace("opo", "_o_");
        line = line.replace("upu", "_u_");
        line = line.replace("_", "");

        System.out.println(line);
    }

}