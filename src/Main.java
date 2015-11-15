import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Hyperlink;
import javafx.scene.layout.VBox;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage stage) {
        stage.setTitle("HTML");
        stage.setWidth(500);
        stage.setHeight(500);
        Scene scene = new Scene(new Group());
        VBox root = new VBox();
        final WebView browser = new WebView();
        final WebEngine webEngine = browser.getEngine();
        Hyperlink hpl = new Hyperlink("https://maps.google.com");
        ObservableList<String> observableList = FXCollections.observableArrayList();
        observableList.addAll("1","2","3");
        ComboBox<String> comboBox = new ComboBox<>();
        comboBox.setItems(observableList);
        hpl.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                webEngine.load("http://www.mapcustomizer.com/map/RVAvYmNXZzZSTEU9cmtPTFgyaGtUWmc9");
            }
        });

        root.getChildren().addAll(comboBox,hpl,browser);
        scene.setRoot(root);

        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
