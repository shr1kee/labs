import java.util.Scanner;

/**
 * Created by Acer on 09.06.2017.
 */
public class Main4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int q = in.nextInt();
        int[] x = new int[n + 1];
        x[0] = 0;
        x[1] = 1;
        if (n == 1)
            System.out.println(1);
        else {
            for (int i = 2; i <= n; i++) {
                x[i] = in.nextInt();
            }

            for (int i = 0; i < q; i++) {
                int v = in.nextInt();
                int k = in.nextInt();
                int nach = x[v];
                for (int j = 2; j <= k; j++) {
                    nach = x[nach];
                }
                System.out.println(nach);

            }

        }
    }
}
