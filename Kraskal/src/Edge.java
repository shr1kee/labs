/**
 * Created by Acer on 04.05.2017.
 */
public class Edge implements Comparable {
    int i;
    int j;
    int w;
    public Edge(int i,int j, int w)
    {
        this.i=i;
        this.j=j;
        this.w=w;
    }

    @Override
    public int compareTo(Object o) {
        Edge e=(Edge)o;
        if(this.w<e.w)
        {
            return -1;
        }
        else if(this.w>e.w)
        {
            return 1;
        }

        return 0;
    }
}
