/**
 * Created by Acer on 03.05.2017.
 */
public class Main {
    public static void main(String[] args) {
        Integer[] a= {2,50,18,4,23,19,20,11};
        Integer[] b={4,53,1,56,3,18,21};
        Heap h=new Heap(a);
        Heap h1=new Heap(b);
       h1.HEAPIFY();
        //b=h1.SORT_TREE();
        for (int i:b
             ) {
            System.out.print(i+" ");

        }
       // h.REM_N(1);
      //  h.HEAPIFY();
     //   h1.write();

    }
}
