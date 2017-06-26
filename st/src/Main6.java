import java.util.Scanner;

/**
 * Created by Acer on 09.06.2017.
 */
public class Main6 {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int n=in.nextInt();
        int q=in.nextInt();
        int[] m=new int[n];
        for (int i = 0; i <n ; i++) {
            m[i]=in.nextInt();
        }
        for (int i = 0; i <q ; i++) {
            int l=in.nextInt()-1;
            int r=in.nextInt()-1;
            if(r<l)
            {
                int x=l;
                l=r;
                r=x;
            }
            if(l==r)
                System.out.println(m[l]);
            else
            {
                int xor=m[l]^m[l+1];
                for (int j = l+2; j <=r ; j++) {
                    xor=xor^m[j];
                }
                System.out.println(xor);
            }
        }
    }
}
