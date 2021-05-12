package g55315.Main;

import g55315.presenter.Presenter;
import g55315.view.FxmlController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/view.fxml"));
        VBox root = loader.load();
        Scene scene = new Scene(root);
        FxmlController view = loader.getController();
        Presenter presenter = new Presenter(view);
        presenter.init();
        view.setPresenter(presenter);
        stage.setScene(scene);
        stage.show();
    }
}
