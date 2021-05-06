package g55315.model.dijkstra;

import g55315.model.config.ConfigManager;
import g55315.model.dto.StationDto;
import g55315.model.dto.StopDto;
import g55315.model.exception.RepositoryException;
import g55315.model.repository.StationRepository;
import g55315.model.repository.StopRepository;

import java.io.IOException;
import java.util.*;

public class StibGraph {
    private Graph graph;

    public void populateGraph() throws RepositoryException {
        try {
            ConfigManager.getInstance().load();
            String dbUrl = ConfigManager.getInstance().getProperties("db.url");

            StopRepository repository = new StopRepository();
            StationRepository rep = new StationRepository();
            List<StationDto> dtoNames = rep.getAll();
            List<StopDto> dtos;
            HashMap<String, Node> nodes = new HashMap<String, Node>();
            for (StationDto dto : dtoNames) {
                Node n = new Node(dto.getKey());
                nodes.put(dto.getKey(), n);
            }

            for (int n = 1; n < 7; n++) {
                dtos = repository.get(n);
                for (int i = 0; i < dtos.size() - 1; i++) {
                    String dep = dtos.get(i).getName();
                    String dest = dtos.get(i + 1).getName();
                    Node depNode = nodes.get(dep);
                    Node destNode = nodes.get(dest);
                    depNode.addDestination(destNode, 1);
                    destNode.addDestination(depNode, 1);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<String>  shortestPath(String begin, String end) {
        List<String> liste = new ArrayList<>();
        Graph start = ShortestPath.calculateShortestPathFromSource(graph, graph.getNode(begin));
        List<Node> l = start.getNode(end).getShortestPath();
        for(Node e: l ) {
            liste.add(e.getName());
            System.out.println(e.getName());
        }
        liste.add(end);
        return liste;
    }
}

