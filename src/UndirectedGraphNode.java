import java.util.ArrayList;
import java.util.List;

/**
 * Created by Larry Liu on 10/25/2017.
 */
public class UndirectedGraphNode {
    int label;
    List<UndirectedGraphNode> neighbors;
    UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
}
