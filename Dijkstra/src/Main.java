import java.io.FileNotFoundException;

/**
 * Created by Acer on 27.04.2017.
 */
public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        Conteiner gr=new Conteiner("test2.txt");
        int sum=gr.dijkstra(0);
     //   System.out.println(sum);
       /* int num=0;
        for(int i=1;i<gr.n;i++)
        {
            if (sum>gr.dijkstra(i))
            {
                sum=gr.dijkstra(i);
                num=i;
            }
        }
        System.out.print(num);*/


    }
}