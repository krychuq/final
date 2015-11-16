import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.stage.Stage;

/**
 * Created by lucia on 11/16/15.
 */
public class WelcomeWindow {


public static void start() {


    Stage welcomeWindow = new Stage();
    GridPane grid = new GridPane();
    Button profile = new Button("PROFILE");
    Label welcome = new Label("Welcome!Book your table");
    Scene scene = new Scene(grid,400,200);
    GridPane.setConstraints(welcome,0,0,1,1, HPos.LEFT, VPos.TOP);
    GridPane.setConstraints(profile,0,0,1,1, HPos.RIGHT, VPos.TOP);
    grid.getRowConstraints().add(new RowConstraints(20));
    grid.getColumnConstraints().add(new ColumnConstraints(400));
    grid.setGridLinesVisible(true);




    grid.getChildren().addAll(welcome,profile);
    welcomeWindow.setScene(scene);
    welcomeWindow.show();



}


}