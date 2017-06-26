import java.util.Scanner;

/**
 * Created by Acer on 09.06.2017.
 */
public class Main3 {
    public static void main(String[] args) {
        Scanner in =new Scanner(System.in);
        long w=in.nextInt();
        long h=in.nextInt();
        long n =in.nextInt();
        long x =(long)(Math.sqrt(w)*Math.sqrt(h)*Math.sqrt(n));
        System.out.println(x);
    }
}
