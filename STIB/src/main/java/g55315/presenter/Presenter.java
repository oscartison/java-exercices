package g55315.presenter;

import g55315.model.config.ConfigManager;
import g55315.model.dijkstra.StibGraph;
import g55315.model.dto.StationDto;
import g55315.model.dto.StopDto;
import g55315.model.exception.RepositoryException;
import g55315.model.repository.StopRepository;
import g55315.view.FxmlController;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Presenter {
    private List<StationDto> liste = new ArrayList<>();
    private StopRepository stopRepository;
    private FxmlController controller;

    public void init() throws RepositoryException {
        List<StopDto> dtos = stopRepository.getAll();
        List<String> stationNames = new ArrayList<>();
        for(StopDto station:dtos) {
            stationNames.add(station.getName());
        }
        controller.setCombo(stationNames);
    }

    public void calculatePath(String begin, String end) {
        System.out.println("SAAALLLUUUT");
        StibGraph stib = new StibGraph();
        List<String> path = stib.shortestPath(begin,end);
        for(String station:path){
            controller.getStations().getColumns().add(station);
        }
    }

    public Presenter(FxmlController view) {

        try {
            ConfigManager.getInstance().load();
            stopRepository = new StopRepository();
            controller = view;
//            controller.getLignes().setCellValueFactory(new PropertyValueFactory<>("sort"));
//            controller.getStations().setCellValueFactory(new PropertyValueFactory<>("sort"));
        } catch (RepositoryException | IOException e) {
            e.printStackTrace();
        }
    }
}
