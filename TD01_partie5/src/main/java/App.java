
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import view.MyTableView;

public class App extends Application {
    
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader =new FXMLLoader(getClass().getResource("/FXML/MainView.fxml"));
        
        AnchorPane root = loader.load();
   //     MyTableView view = new MyTableView();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    
}
