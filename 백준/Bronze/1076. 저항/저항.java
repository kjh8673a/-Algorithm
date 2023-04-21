import java.io.*;
import java.util.*;

public class Main {
    static class Node {
        int val;
        long mul;

        public Node(int val, long mul) {
            this.val = val;
            this.mul = mul;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String first = br.readLine();
        String second = br.readLine();
        String third = br.readLine();

        Map<String, Node> map = new HashMap<>() {
            {
                put("black", new Node(0, 1));
                put("brown", new Node(1, 10));
                put("red", new Node(2, 100));
                put("orange", new Node(3, 1000));
                put("yellow", new Node(4, 10_000));
                put("green", new Node(5, 100_000));
                put("blue", new Node(6, 1_000_000));
                put("violet", new Node(7, 10_000_000));
                put("grey", new Node(8, 100_000_000));
                put("white", new Node(9, 1_000_000_000));
            }
        };

        System.out.println((map.get(first).val * 10 + map.get(second).val) * map.get(third).mul);

    }

}