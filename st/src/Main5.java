import java.math.BigInteger;
import java.util.Scanner;

/**
 * Created by Acer on 09.06.2017.
 */
public class Main5 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        long n=in.nextLong();
        int k=in.nextInt();
        BigInteger[] mask=new BigInteger[k];
        BigInteger sum= BigInteger.ONE;
        mask[0]=sum;
        for (int i = 1; i <k ; i++) {
            BigInteger x=BigInteger.ONE;
            x=x.add(sum);
            mask[i]=x;
            sum.add(x);
        }
        for (int i = k; i <n ; i++)
        {
            sum=BigInteger.ZERO;
            for (int j = 0; j <k ; j++) {
                sum=sum.add(mask[j]);
               // sum+=mask[j];
            }
            for (int j = 0; j <k-1 ; j++) {
               mask[j] =mask[j+1];
            }
            mask[k-1]=sum;
        }
        long d= (long) (Math.pow(10,9)+9);
        BigInteger c= BigInteger.valueOf(d);
        System.out.println(mask[k-1].mod(c));

    }
}
