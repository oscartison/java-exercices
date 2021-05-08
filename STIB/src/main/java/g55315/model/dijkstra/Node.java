package g55315.model.dijkstra;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Class respresenting a node of a graph
 */
public class Node {

    private String name;

    private List<Node> shortestPath = new LinkedList<>();

    private Integer distance = Integer.MAX_VALUE;

    Map<Node, Integer> adjacentNodes = new HashMap<>();

    /**
     * adds a destination to the node
     * @param destination the destination
     * @param distance the distance to the destination
     */
    public void addDestination(Node destination, int distance) {
        adjacentNodes.put(destination, distance);
    }

    /**
     * a setter for the name of the node
     * @param name the new name for the node
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * a getter for the name of the node
     * @return the name of the node
     */
    public String getName() {
        return name;
    }

    /**
     * a getter for the shortest path to this node
     * @return a list with the shortest path to this node
     */
    public List<Node> getShortestPath() {
        return shortestPath;
    }

    /**
     * gets the distance to this node from the source of the graoh
     * @return the distance to this node
     */
    public Integer getDistance() {
        return distance;
    }

    /**
     * a getter for the adjacent nodes to this node
     * @return the adjacant nodes
     */
    public Map<Node, Integer> getAdjacentNodes() {
        return adjacentNodes;
    }

    /**
     * a setter for the shortest path
     * @param shortestPath list of nodes with shortest path to this node
     */
    public void setShortestPath(List<Node> shortestPath) {
        this.shortestPath = shortestPath;
    }

    /**
     * setter for the distance to this node
     * @param distance distance to this node
     */
    public void setDistance(Integer distance) {
        this.distance = distance;
    }

    /**
     * a setter for the adjacent nodes
     * @param adjacentNodes adjacent nodes to this node
     */
    public void setAdjacentNodes(Map<Node, Integer> adjacentNodes) {
        this.adjacentNodes = adjacentNodes;
    }

    /**
     * constructor for the class Node
     * @param name name of the node
     */
    public Node(String name) {
        this.name = name;
    }

    // getters and setters
}