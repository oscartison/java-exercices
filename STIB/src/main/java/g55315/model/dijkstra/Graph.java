package g55315.model.dijkstra;



import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * Class representing a Graph
 */
public class Graph {

    private Set<Node> nodes = new HashSet<>();

    /**
     * adds a node to the graph
     * @param nodeA
     */
    public void addNode(Node nodeA) {
        nodes.add(nodeA);
    }

    /**
     * a getter for the set of nodes of the graph
     * @return the nodes of the graph
     */
    public Set<Node> getNodes() {
        return nodes;
    }

    /**
     * sets the nodes of the graph to a certain set
     * @param nodes
     */
    public void setNodes(Set<Node> nodes) {
        this.nodes = nodes;
    }

    /**
     *  gets a node in the graph with a certain name
     * @param name the name of the node to search
     * @return the found node or null if the node is not found
     */
    public Node getNode(String name) {
        for (Iterator<Node> it = nodes.iterator(); it.hasNext(); ) {
            Node f = it.next();
            if (f.getName().equals(name))
               return f;
        }
        return null;
    }
}