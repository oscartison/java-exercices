package g55315.model.dijkstra;



import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Graph {

    private Set<Node> nodes = new HashSet<>();

    public void addNode(Node nodeA) {
        nodes.add(nodeA);
    }

    public Set<Node> getNodes() {
        return nodes;
    }

    public void setNodes(Set<Node> nodes) {
        this.nodes = nodes;
    }

    public Node getNode(String name) {
        for (Iterator<Node> it = nodes.iterator(); it.hasNext(); ) {
            Node f = it.next();
            if (f.getName().equals(name))
               return f;
        }
        return null;
    }
}