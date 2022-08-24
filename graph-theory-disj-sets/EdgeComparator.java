import java.util.*;

public class EdgeComparator implements Comparator<Edge> {
    
    public int compare(Edge e1, Edge e2){
        if (e1.getWeight() == e2.getWeight()){
            return 0;
        }
        else if (e1.getWeight() > e2.getWeight()){
            return 1;
        }
        else return -1;
    }
}
