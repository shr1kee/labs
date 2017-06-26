import java.util.Scanner;

/**
 * Created by Acer on 09.06.2017.
 */
public class Main7 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int w = in.nextInt();
        int h = in.nextInt();
        int n = in.nextInt();
        //int[] result = new int[4];
        int bestF = Integer.MAX_VALUE;
        for (int A1 = 1; A1 <= n; A1++)
            for (int A2 = 1; A2 <= n; A2++)
                for (int B1 = 0; B1 <= n; B1++)
                    for (int B2 = 0; B2 <= n; B2++) {
                        if (A1 * A2 + B1 * B2 < n)
                            continue;

                        int fitness = Math.max(A1 * w + B1 * h, Math.max(A2 * h, B2 * w));
                        if (fitness < bestF) {
                            bestF = fitness;
                        }
                    }

        System.out.println(bestF);
    }

}
