import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.stage.Stage;
import javafx.util.StringConverter;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;


/**
 * Created by lucia on 11/16/15.
 */
public class ReservationSystemGui extends Application{

    public DatePicker dateSelector;
    public final String pattern = "dd-MM-yyyy";
    Controller controller = new Controller(this);
    Label welcomUser = new Label("");
    Customer customer;
    ComboBox<String> numberOfPeople = new ComboBox();
    ComboBox<String> hour = new ComboBox<>();
    String restaurantName;
    java.sql.Timestamp sq = null;
    public int cvr;
    int numberOfPeople1;
    Label logOut = new Label("log out");
    Label singIn = new Label("sign in");

    public static void main(String[] args) {

        Locale.setDefault(Locale.ENGLISH);
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

        Label text2 = new Label("Welcome to");
        Label text3 = new Label("Table4You");
        Label text4 = new Label("|");
        gridPane.setConstraints(singUp, 4, 0, 1, 1, HPos.LEFT, VPos.TOP);
        gridPane.setConstraints(singIn, 4, 0, 1, 1, HPos.RIGHT, VPos.TOP);
        gridPane.setConstraints(logOut, 4, 0, 1, 1, HPos.RIGHT, VPos.TOP);

        gridPane.setConstraints(text4, 4, 0, 1, 1, HPos.RIGHT, VPos.TOP);
      gridPane.setMargin(singUp, new Insets(60, 0, 0, 45));
       gridPane.setMargin(singIn, new Insets(60, 45, 0, 0));
        gridPane.setMargin(logOut, new Insets(60, 45, 0, 0));

        gridPane.setMargin(text4, new Insets(60, 96, 0, 0));
        GridPane.setConstraints(welcomUser, 3, 0, 2, 1, HPos.LEFT, VPos.TOP);
        gridPane.setMargin(welcomUser, new Insets(60, 0, 0, 0));

        singIn.setId("sign");
        logOut.setId("sign");
        singUp.setId("sign");
        text2.setId("label");

        singUp.setOnMouseClicked(event1 -> {
            controller.signUp();


        });

        text3.setId("label1");

        Label text = new Label("\n" +"Here you can book a tabel in desired restaurant. You won't wait in line anymore.\n" +
                "Choose the date and hour below and click find a tabel. It is that easy!");
        GridPane.setConstraints(text, 0, 0, 1, 1, HPos.LEFT, VPos.BOTTOM);
        GridPane.setConstraints(text2, 0, 0, 1, 1, HPos.LEFT, VPos.CENTER);
        GridPane.setConstraints(text3, 0, 0, 1, 1, HPos.LEFT, VPos.CENTER);
        gridPane.setMargin(text3, new Insets(30, 0, 0, 140));

        gridPane.setMargin(text2, new Insets(30, 0, 0, 45));
        gridPane.setMargin(text, new Insets(0, 0, 40, 45));



        gridPane.setColumnSpan(text, 5);
        gridPane.setColumnSpan(text3, 2);


        text.setId("label");

        numberOfPeople.setVisibleRowCount(5);

        controller.getDatabaseCustomer().numberOfpeopleComboBox();
        numberOfPeople.setItems(controller.getDatabaseCustomer().numberOfpeopleComboBox());
        numberOfPeople.setValue("2 people");

        //DatePicker
        dateSelector = new DatePicker();
        dateSelector.setValue(LocalDate.now());
        dateSelector.setMaxSize(200, 200);
        dateSelector.setId("buttonStyle1");
        // DatePicker converter of date in combobox
        //dateSelector.backgroundProperty(.selector);
        StringConverter converter = new StringConverter<LocalDate>() {
            DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern(pattern);
            @Override
            public String toString(LocalDate date) {
                if (date != null) {
                    return dateFormatter.format(date);
                }else{
                    return " ";
                }
            }
            @Override
            public LocalDate fromString(String string) {
                if (string != null && !string.isEmpty()) {
                    return LocalDate.parse(string, dateFormatter);
                } else {
                    return null;
                }
            }
        };
        dateSelector.setConverter(converter);
        dateSelector.setPromptText(pattern.toLowerCase());
        //dateSelector.applyCss();


        controller.getDatabaseCustomer().hourInCombobox();
        hour.setItems(controller.getDatabaseCustomer().hourInCombobox());

        hour.setVisibleRowCount(5);
        hour.setValue("17:00");
        hour.setId("hour-box-base");
        ComboBox<String> restaurants = new ComboBox<>();
        restaurants.setItems(controller.getDatabaseCustomer().getRetaurants());
        restaurants.setItems(controller.getDatabaseCustomer().getRetaurants());
        restaurants.setPromptText("restaurant");

        Button findTable = new Button();
        findTable.setId("buttonStyle5");
        findTable.setOnAction(event1 -> {


             restaurantName = restaurants.getSelectionModel().getSelectedItem();


             cvr = controller.getDatabaseCustomer().getRestaurant(restaurantName);
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String s = dateSelector.getValue().toString() + " " + hour.getSelectionModel().getSelectedItem() + ":" + "00";
             numberOfPeople1 = 1;
            numberOfPeople1 += numberOfPeople.getSelectionModel().getSelectedIndex();

            try {
                java.util.Date utilDate = format.parse(s);
                sq = new java.sql.Timestamp(utilDate.getTime());

            } catch (ParseException e) {
                e.printStackTrace();
            }

            try {
                controller.displaySearched(this,customer);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        });


        GridPane.setConstraints(numberOfPeople, 0, 1, 1, 1, HPos.RIGHT, VPos.BOTTOM);
        gridPane.setMargin(numberOfPeople,new Insets(0,0,0,45));
        GridPane.setConstraints(dateSelector,1,1,1,1,HPos.RIGHT,VPos.BOTTOM);
        GridPane.setConstraints(hour,2,1,1,1,HPos.RIGHT,VPos.BOTTOM);
        GridPane.setConstraints(restaurants,3,1,1,1,HPos.RIGHT,VPos.BOTTOM);
        GridPane.setConstraints(findTable,4,1,1,1, HPos.RIGHT, VPos.BOTTOM);
        gridPane.setMargin(findTable,new Insets(0,45,0,0));
        logOut.setVisible(false);




        gridPane.setGridLinesVisible(false);


        singIn.setOnMouseClicked(event -> {
            controller.startSignIn(this);

            logOut.setOnMouseClicked(event2 -> {

                setWelcomUser(" ");
                singIn.setVisible(true);
                singIn.setDisable(false);
                logOut.setVisible(false);
                customer = null;
            });



        });
        gridPane.getChildren().addAll(logoView,numberOfPeople,dateSelector,hour,restaurants,findTable, singUp, singIn,
                text,text2,text3,text4,welcomUser, logOut);



            primaryStage.setScene(scene);
            primaryStage.show();


        }

    public void setCustomer(Customer customer){
        this.customer = customer;
    }
    public void setWelcomUser(String string){
        welcomUser.setText(string);
    }
    public void changeToVisible(Label label1){

        label1.setVisible(true);

    }
    public void changeToInvisible(Label label2) {

        label2.setVisible(false);
        label2.setDisable(true);


    }


    }


