package g55315.model.dijkstra;

import g55315.model.config.ConfigManager;
import g55315.model.dto.StationDto;
import g55315.model.dto.StopDto;
import g55315.model.exception.RepositoryException;
import g55315.model.jdbc.StationDao;
import g55315.model.repository.StationRepository;
import g55315.model.repository.StopRepository;

import java.io.IOException;
import java.util.*;


public class Test {
    public static void main(String[] args) {
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
            Graph g = new Graph();

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



            for (Map.Entry<String, Node> entry : nodes.entrySet()) {
                g.addNode(entry.getValue());
            }
            Graph f = ShortestPath.calculateShortestPathFromSource(g, g.getNode("BELGICA"));
            Set<Node> value = f.getNodes();

//            for (Node s : value) {
//                System.out.println(s.getAdjacentNodes().entrySet());
//            }
            List<Node> l = f.getNode("ETANGS NOIRS").getShortestPath();
            for(Node e: l ) {
                System.out.println(e.getName());
            }
        } catch (IOException ex) {
            System.out.println("Erreur IO " + ex.getMessage());
        } catch (RepositoryException ex) {
            System.out.println("Erreur Repository " + ex.getMessage());
        }
    }
}
