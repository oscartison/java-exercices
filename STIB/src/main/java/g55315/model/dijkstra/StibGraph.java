package g55315.model.dijkstra;

import g55315.model.config.ConfigManager;
import g55315.model.dto.LineDto;
import g55315.model.dto.StationDto;
import g55315.model.exception.RepositoryException;
import g55315.model.repository.LineRepository;
import g55315.model.repository.StationRepository;

import java.io.IOException;
import java.util.*;

/**
 * The graph representing the metro network
 */
public class StibGraph {
    private Graph graph;
    private List<String> path;

    /**
     * a constructor for the class
     */
    public StibGraph() {
        graph = new Graph();
        path = new ArrayList<>();
    }

    /**
     * a getter for the path for a certain traject
     * @return
     */
    public List<String> getPath() {
        return path;
    }

    /**
     * populates the graph with the information in the database
     * @throws RepositoryException exception is thrown when error on database
     */
    public void populateGraph() throws RepositoryException {
        try {
            ConfigManager.getInstance().load();

            StationRepository rep = new StationRepository();
            LineRepository lineRepository = new LineRepository();
            List<StationDto> dtoNames = rep.getAll();
            List<LineDto> lines;
            HashMap<String, Node> nodes = new HashMap<String, Node>();
            for (StationDto dto : dtoNames) {
                Node n = new Node(dto.getKey());
                nodes.put(dto.getKey(), n);
            }

            lines = lineRepository.getAll();
            for(LineDto line : lines) {
                for (int i = 0; i < line.getStops().size() - 1; i++) {
                    String dep = line.getStops().get(i).getKey();
                    String dest = line.getStops().get(i + 1).getKey();
                    Node depNode = nodes.get(dep);
                    Node destNode = nodes.get(dest);
                    depNode.addDestination(destNode, 1);
                    destNode.addDestination(depNode, 1);
                }
            }
            for (Map.Entry<String, Node> entry : nodes.entrySet()) {
                graph.addNode(entry.getValue());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * calculates the shortest path from a begin to an end
     * @param begin the start station
     * @param end the end station
     */
    public void  shortestPath(String begin, String end) {
        List<String> liste = new ArrayList<>();
        try {
            graph = new Graph();
            populateGraph();
        } catch (RepositoryException e) {
            e.printStackTrace();
        }
        graph = ShortestPath.calculateShortestPathFromSource(graph, graph.getNode(begin));
        List<Node> l = graph.getNode(end).getShortestPath();
        for(Node e: l ) {
            liste.add(e.getName());
        }
        liste.add(end);
        path = liste;
    }
}

