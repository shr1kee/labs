/**
 * Created by Acer on 17.05.2017.
 */
public class Main {
    public static void main(String[] args) {
        String s1="jdkfls";
        String s2=s1;
        s1+=" heh";
        Integer a=5;
        Integer b=a;
        a+=10;
        System.out.println(mystery("golova"));
    }
    public static String mystery(String s)
    {
        int N=s.length();
        if(N<=1) return s;
        String a=s.substring(0,N/2);
        String b=s.substring(N/2,N);
        return mystery(b)+mystery(a);
    }
}
