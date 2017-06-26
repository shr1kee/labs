import java.io.FileNotFoundException;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        // write your code here
        graph g=new graph();
        g.read("test2.txt");
      //  g.showG();
       // g.addD(0,3);
      //  g.showG();
//        //g.showG();

        g.Tree(0,2,3);
        g.update(0,2,3);
       // g.write();
        g.showTr();
        // g.write();

    }
}
