package g55315.view;

import java.net.URL;
import java.util.ArrayList;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import g55315.model.MyThread;
import g55315.model.Observable;
import g55315.model.Observer;
import g55315.model.StateSort;

/**
 *
 * @author oscar
 */
public class FxmlController implements Initializable, Observer {

    @FXML
    private Spinner<Integer> threadSpinner;

    @FXML
    private TableView table;

    @FXML
    private TableColumn nameCol;

    @FXML
    private TableColumn sizeCol;

    @FXML
    private TableColumn swapCol;

    @FXML
    private TableColumn durationCol;

    @FXML
    private LineChart<Number,Number> chart;
    

    @FXML
    private ChoiceBox<String> sortChoice;

    @FXML
    private ChoiceBox<String> configurationChoice;

    @FXML
    private ProgressBar progressBar;

    @FXML
    private Button start;

    @FXML
    private Label leftStatus;

    @FXML
    private Label rightStatus;
    
    private XYChart.Series series = new XYChart.Series();
    
    private double progress;


    public FxmlController() {
    }

    @FXML
    public void handleButton(ActionEvent e) throws InterruptedException {
        int nbThreads = threadSpinner.getValue();
        String sort = sortChoice.getValue();
        String config = configurationChoice.getValue();
        ArrayList<int[]> all = new ArrayList<>();
        series = new XYChart.Series();
        progress = 0;

        int val = 10000;

        if (config.equals("Very easy: 0-100 by 10")) {
            val = 100;
        } else if (config.equals("Easy: 0-1.000 by 100")) {
            val = 1000;
        } else if (config.equals("Medium: 0-10.000 by 1.000")) {
            val = 10000;
        } else {
            val = 100000;
        }
        for (int tai = 0; tai <= val; tai += (val / 10)) {
            Random rd = new Random();
            int[] arr = new int[tai];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = rd.nextInt();
            }
            all.add(arr);
        }
        ExecutorService threadPool = Executors.newFixedThreadPool(nbThreads);

        for (int i = 0; i <= 10; i++) {
            MyThread th = new MyThread(all.get(i), sort, sort, this);
            threadPool.submit(th);
        }
        threadPool.shutdown();

    }

    @Override
    public void initialize(URL url, ResourceBundle rb
    ) {
        threadSpinner.setValueFactory(
                new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 10));
        sortChoice.getItems().add("Bubble sort");
        sortChoice.getItems().add("Merge sort");
        sortChoice.getSelectionModel().selectLast();

        configurationChoice.getItems().add("Very easy: 0-100 by 10");
        configurationChoice.getItems().add("Easy: 0-1.000 by 100");
        configurationChoice.getItems().add("Medium: 0-10.000 by 1.000");
        configurationChoice.getItems().add("Hard: 0-100.000 by 10.000");
        configurationChoice.getSelectionModel().select(0);
        leftStatus.setText("Nombre de threads actifs: " + Thread.activeCount());

        init();
    }

    public void init() {
        nameCol.setCellValueFactory(new PropertyValueFactory<>("sort"));
        sizeCol.setCellValueFactory(new PropertyValueFactory<>("size"));
        swapCol.setCellValueFactory(new PropertyValueFactory("nbOperations"));
        durationCol.setCellValueFactory(new PropertyValueFactory<>("dur"));


       // chart = new LineChart<>(taille, operations);
    }

    @Override
    public void update(Observable observable, Object arg) {
        StateSort s = (StateSort) arg;
        new Thread(new Runnable() {
            @Override
            public void run() {
                Platform.runLater(() -> {
                    table.getItems().add(arg);
                    series.getData().add(new XYChart.Data<>(s.getSize(),s.getNbOperations()));
                    if (!chart.getData().contains(series)) {
                    chart.getData().add(series);
                    }
                    leftStatus.setText("Nombre de threads actifs: " + Thread.activeCount());
                    progress += 0.1;
                    progressBar.setProgress(progress);
                });
            }
        }
        ).start();

    }
}
