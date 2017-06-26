import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Acer on 09.06.2017.
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner in =new Scanner(System.in);
        int n=in.nextInt();
        int [] x = new int[n];
        for (int k = 0; k <n ; k++) {
            x[k] = in.nextInt();
        }
        int [] an = new int[n];
        int sum =0;
        if (n == 1)
            sum=x[0];
        else {
            an[0] = x[0];
            an[1] = x[1];
            for (int i = 2; i < n; i++) {
                int min = an[i - 1] + x[i];
                if (an[i - 2] + x[i] < min)
                    min = an[i - 2] + x[i];
                an[i] = min;
            }
            sum = an[n-1];
        }
        System.out.println(sum);
    }
}
