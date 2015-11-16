import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.ObservableMap;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

/**
 * Created by lucia on 11/16/15.
 */
public class ReservationSystemGui extends Application{


    public static void main(String[] args) {

        launch(args);
    }
    @Override
    public void start(Stage primaryStage) throws Exception {

        GridPane gridPane = new GridPane();
        Scene scene = new Scene(gridPane, 734, 406);
        gridPane.setId("reservationSystemGui");
        Image logo = new Image("logo.png");
        ImageView logoView = new ImageView(logo);


        scene.getStylesheets().addAll(this.getClass().getResource("Style.css").toExternalForm());
        GridPane.setConstraints(logoView, 0, 0, 1, 1, HPos.LEFT, VPos.TOP);
        gridPane.getRowConstraints().add(new RowConstraints(230));
        gridPane.getColumnConstraints().add(new ColumnConstraints(173));
        gridPane.getColumnConstraints().add(new ColumnConstraints(109));
        gridPane.getColumnConstraints().add(new ColumnConstraints(109));
        gridPane.getColumnConstraints().add(new ColumnConstraints(145));
        gridPane.getColumnConstraints().add(new ColumnConstraints(200));


        gridPane.setMargin(logoView, new Insets(17, 0, 0, 45));
        Label singUp = new Label("sign up");
        Label singIn = new Label("sign in");
        Label text2 = new Label("Welcome to");
        Label text3 = new Label("Tabel4You");
        Label text4 = new Label("|");
        gridPane.setConstraints(singUp,4,0,1,1,HPos.LEFT,VPos.TOP);
        gridPane.setConstraints(singIn,4,0,1,1,HPos.RIGHT,VPos. TOP);
        gridPane.setConstraints(text4,4,0,1,1, HPos.RIGHT, VPos.TOP);
      gridPane.setMargin(singUp,new Insets(60,0,0,45));
       gridPane.setMargin(singIn,new Insets(60,45,0,0));
       gridPane.setMargin(text4, new Insets( 60,96,0,0));
        singIn.setId("sign");
        singUp.setId("sign");
        text2.setId("label");

        text3.setId("label1");

        Label text = new Label("\n" +"Here you can book a tabel in desired restaurant. You won't wait in line anymore.\n" +
                "Choose the date and hour below and click find a tabel. It is that easy!");
        GridPane.setConstraints(text,0,0,1,1, HPos.LEFT,VPos.BOTTOM);
        GridPane.setConstraints(text2,0,0,1,1, HPos.LEFT,VPos.CENTER);
        GridPane.setConstraints(text3,0,0,1,1, HPos.LEFT,VPos.CENTER);
        gridPane.setMargin(text3, new Insets(30,0,0,140));

        gridPane.setMargin(text2, new Insets(30,0,0,45));
        gridPane.setMargin(text, new Insets(0,0,40,45));



        gridPane.setColumnSpan(text, 5);
        gridPane.setColumnSpan(text3,2);


        text.setId("label");
        ComboBox<String> combo = new ComboBox();
        combo.setVisibleRowCount(5);
        combo.;
        ObservableList<String> observableList = FXCollections.observableArrayList();
        observableList.add("1 person");
        observableList.add("2 people");
        observableList.add("3 people");
        observableList.add("4 people");
        observableList.add("5 people");
        observableList.add("6 people");
        observableList.add("7 people");
        observableList.add("8 people");
        combo.setItems(observableList);


        combo.setId("buttonStyle");
        Button date = new Button("         ");
        date.setId("buttonStyle1");
        Button hour = new Button("      ");
        hour.setId("buttonStyle2");
        Button findTable = new Button("       ");
        findTable.setId("buttonStyle5");
        Button restaurants = new Button("        ");
        restaurants.setId("buttonStyle3");
        GridPane.setConstraints(combo,0,1,1,1, HPos.RIGHT,VPos.BOTTOM);
        gridPane.setMargin(combo,new Insets(0,0,0,45));
        GridPane.setConstraints(date,1,1,1,1,HPos.RIGHT,VPos.BOTTOM);
        GridPane.setConstraints(hour,2,1,1,1,HPos.RIGHT,VPos.BOTTOM);
        GridPane.setConstraints(restaurants,3,1,1,1,HPos.RIGHT,VPos.BOTTOM);
        GridPane.setConstraints(findTable,4,1,1,1, HPos.RIGHT, VPos.BOTTOM);
        gridPane.setMargin(findTable,new Insets(0,45,0,0));



        singUp.setOnMouseClicked(event -> {
                 System.out.println("Working");}
           );


        gridPane.setGridLinesVisible(false);


        singIn.setOnMouseClicked(event -> {
            System.out.println("Sign IN");
        });
        gridPane.getChildren().addAll(logoView,combo,date,hour,restaurants,findTable, singUp, singIn,text,text2,text3,text4);


            primaryStage.setScene(scene);
            primaryStage.show();


        }
    }
