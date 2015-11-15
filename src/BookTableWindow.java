import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 * Created by krystian on 2015-11-15.
 */
public class BookTableWindow extends Application{
    Label welcomLabel = new Label("Find restaurant!");
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage = new Stage();
        GridPane gridPane = new GridPane();
        gridPane.getChildren().add(welcomLabel);
        Scene scene = new Scene(gridPane,500,600);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
