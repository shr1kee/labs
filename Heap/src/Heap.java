/**
 * Created by Acer on 03.05.2017.
 */
public class Heap {
    int n;
    Integer[] A;
    public Heap(Integer[] a)
    {
        A=a;
        n=a.length;
    }
    public void REM_N(int k0)
    {
        int k1=0;
        int k2=0;
        n=A.length;
        for( int k=k0; k<=(n-1)/2; k=k1)
        {
            k1=2*k+1;
            k2=k1+1;
            if(k1>=n)
                break;
            if( k2 < n && A[k2]<A[k1])
                k1=k2;

            if( A[k]<A[k1]) break;
            else
            {
                int sw=A[k];
                A[k]=A[k1];
                A[k1]=sw;
            }

        }
    }
    public void REM_V (int k0)
    {
        int k1=0;
        for (int k = k0; k >0 ; k=k1) {
            k1=(k-1)/2;
            if(A[k1]<A[k]) break;
            else
            {
                int sw=A[k];
                A[k]=A[k1];
                A[k1]=sw;
            }
        }
    }
    public int GET_MIN()
    {
        int min=A[0];
        A[0]=A[n-1];
        Integer[] B=new Integer[n-1];
        for (int i = 0; i <n-1 ; i++) {
            B[i]=A[i];
        }
        A=B;
        n--;
        REM_N(0);
        return (min);
    }
    public void ADD( int a)
    {
        Integer[] B=new Integer[n+1];
        for (int i = 0; i <n ; i++) {
            B[i]=A[i];
        }
        B[n]=a;
        n++;
        A=B;
        REM_V(n-1);
    }
    public void REMOVE(int k0)
    {
        int a=A[k0];
        A[k0]=A[n-1];
        Integer[] B=new Integer[n-1];
        for (int i = 0; i <A.length ; i++) {
            B[i]=A[i];
        }
        A=B;
        n--;
        if(A[k0]> a)
            REM_N(k0);
        else
            REM_V(k0);
    }
    public void HEAPIFY()
    {
        for(int k=(n-1)/2;k>=0;k--)
            REM_N(k);
    }
    public Integer[] SORT_TREE()
    {
        HEAPIFY();
        Integer[] b=new Integer[n];
        for (int i = 0; i <n ; i++) {
            b[i]=0;
        }
        for (int i=n; i>0; ) {
            int sw=A[0];
            b[i-1]=sw;
            A[0]=A[i-1];
            i--;
            Integer[] B=new Integer[i];
            for (int j = 0; j <B.length ; j++) {
                B[j]=0;
            }
            for (int j = 0; j <i ; j++) {
                B[j]=A[j];
            }

            A=B;
            REM_N(0);
        }
        return b;
    }
    public void write()
    {
        for (int i = 0; i <A.length ; i++) {
            System.out.print(A[i]+" ");
        }
    }

}
