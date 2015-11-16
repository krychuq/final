import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;


public class ReservationSystem extends Application {
    TableView tableView;
    Stage window;
    SignUpCustomer signUpCustomer = new SignUpCustomer();
    DatabaseCustomer databaseCustomer = new DatabaseCustomer();
    Customer customer;
    Label wrongLabel = new Label("");
    SignUpRestaurant signUpRestaurantWindow = new SignUpRestaurant();
    public static void main(String[] args) {
        launch(args);

    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        window = primaryStage;
        window.setTitle("RESERVATION SYSTEM");

        primaryStage.setOnCloseRequest(event1 -> {

            event1.consume();
            boolean result = ConfimBox.display("Warning", "Are you sure you want to close?");
            if (result) {
                primaryStage.close();
            }

        });

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(8);
        grid.setHgap(10);


        Label userName = new Label("Username:");
        GridPane.setConstraints(userName, 0, 0, 1, 1, HPos.CENTER, VPos.BOTTOM);
        grid.getRowConstraints().add(new RowConstraints(40));

        TextField nameInput = new TextField();
        GridPane.setConstraints(nameInput, 1, 0,1,1, HPos.CENTER, VPos.BOTTOM);
        Label password = new Label("Password:");
        GridPane.setConstraints(password, 0, 1);
        PasswordField passwordInput = new PasswordField();
        GridPane.setConstraints(passwordInput, 1, 1);
        GridPane.setConstraints(wrongLabel, 0, 0, 1, 1, HPos.CENTER, VPos.TOP);
        GridPane.setColumnSpan(wrongLabel, 2);

        grid.getChildren().addAll(wrongLabel);

        Button logIn = new Button("Log In");

        GridPane.setConstraints(logIn, 1, 2);

        Button signUp = new Button("Sign Up");
        GridPane.setConstraints(signUp, 1, 3);
        Button signUpRestaurant = new Button("Sign Up restaurant");
        signUpRestaurant.setOnAction(event3 -> {
         signUpRestaurantWindow.signup();
        });
        Button showAllCustumer = new Button("show all custumers");
        Button showAllRestaurant = new Button("show all restaurant");
        showAllCustumer.setOnAction(event1 -> {
            showAllCustomers();
        });
        GridPane.setConstraints(showAllCustumer, 1, 4);
        GridPane.setConstraints(signUpRestaurant, 1, 5);
        GridPane.setConstraints(showAllRestaurant,1,6);

       signUp.setOnAction(event -> {
           signUpCustomer.signup();
       });
         grid.setGridLinesVisible(false);
        grid.getChildren().addAll(userName, nameInput, password, passwordInput, logIn, signUp, showAllCustumer, signUpRestaurant,showAllRestaurant);
        logIn.setOnAction(event2 -> {
            customer = databaseCustomer.checkLoginAndPassword(nameInput.getText(), passwordInput.getText());
            if (customer != null) {
                System.out.println("login succesed");
                wrongLabel.setText("");


            } else {
                wrongLabel.setText("wrong user name or password");
                wrongLabel.setTextFill(Color.RED);

                System.out.println("wrong user name or password");
            }
        });
        Scene scene = new Scene(grid,300,400);
        window.setScene(scene);
        window.show();
    }

    private void closeProgram(){

       // Boolean answer = ConfirmBox.display("Warning","Are you sure, you want to close the program");

       // if(answer){
      //      window.close();
      //  }

    }
    private void showAllCustomers(){

        Stage window = new Stage();
        VBox vBox = new VBox(10);
        createTableOfCustomers();
        Button addButton = new Button("add");
        addButton.setOnAction(event1 -> {
            //window.close();


        });
        Button deleteButton = new Button("delete");
        deleteButton.setOnAction(event -> {



        });
        HBox hbox = new HBox(5);
        hbox.getChildren().addAll(addButton,deleteButton);
        hbox.setAlignment(Pos.CENTER);
        vBox.setAlignment(Pos.CENTER);
        vBox.getChildren().addAll(tableView,hbox);
        Scene scene = new Scene(vBox, 300,600);
        window.setScene(scene);
        window.setTitle("DoctorBooking");
        window.show();


    }

    private void showAllRestaurants(){
        Stage window = new Stage();
        VBox vBox = new VBox(10);
        createTableOfCustomers();
        Button addButton = new Button("add");
        addButton.setOnAction(event1 -> {
            //window.close();


        });
        Button deleteButton = new Button("delete");
        deleteButton.setOnAction(event -> {



        });
        HBox hbox = new HBox(5);
        hbox.getChildren().addAll(addButton,deleteButton);
        hbox.setAlignment(Pos.CENTER);
        vBox.setAlignment(Pos.CENTER);
        vBox.getChildren().addAll(tableView,hbox);
        Scene scene = new Scene(vBox, 300,600);
        window.setScene(scene);
        window.setTitle("DoctorBooking");
        window.show();
    }


    private void createTableOfCustomers(){
        tableView= new TableView();
        tableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        javafx.scene.control.TableColumn<Customer,String> customerID = new javafx.scene.control.TableColumn<>("customerId");
        customerID.setCellValueFactory(new PropertyValueFactory<>("customerID"));
        customerID.setMinWidth(100);


        javafx.scene.control.TableColumn<Customer,String> customerName = new javafx.scene.control.TableColumn<>("name:");
        customerName.setCellValueFactory(new PropertyValueFactory<>("name"));
        customerName.setMinWidth(100);

        javafx.scene.control.TableColumn<Customer,String> customerSurname = new javafx.scene.control.TableColumn<>("surname:");
        customerSurname.setCellValueFactory(new PropertyValueFactory<>("surname"));
        customerSurname.setMinWidth(100);

        javafx.scene.control.TableColumn<Customer,String> customerTelephon = new javafx.scene.control.TableColumn<>("telephone:");
        customerTelephon.setCellValueFactory(new PropertyValueFactory<>("telephone"));
        customerTelephon.setMinWidth(100);

        javafx.scene.control.TableColumn<Customer,String> customerMail = new javafx.scene.control.TableColumn<>("mail:");
        customerMail.setCellValueFactory(new PropertyValueFactory<>("mail"));
        customerMail.setMinWidth(100);

        javafx.scene.control.TableColumn<Customer,String> customerUserName = new javafx.scene.control.TableColumn<>("user name:");
        customerUserName.setCellValueFactory(new PropertyValueFactory<>("userName"));
        customerUserName.setMinWidth(100);

        javafx.scene.control.TableColumn<Customer,String> customerPassword = new javafx.scene.control.TableColumn<>("password:");
        customerPassword.setCellValueFactory(new PropertyValueFactory<>("password"));
        customerPassword.setMinWidth(100);
        tableView.getColumns().addAll(customerID, customerName, customerSurname, customerTelephon, customerMail, customerUserName, customerPassword);

        tableView.setItems(databaseCustomer.getCustomers());

    }

    private  void createTableOfRestaurants(){
        tableView= new TableView();
        tableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        javafx.scene.control.TableColumn<Customer,String> customerID = new javafx.scene.control.TableColumn<>("restaurant id");
        customerID.setCellValueFactory(new PropertyValueFactory<>("restaurant ID"));
        customerID.setMinWidth(100);


        javafx.scene.control.TableColumn<Customer,String> customerName = new javafx.scene.control.TableColumn<>("name:");
        customerName.setCellValueFactory(new PropertyValueFactory<>("name"));
        customerName.setMinWidth(100);

        javafx.scene.control.TableColumn<Customer,String> customerSurname = new javafx.scene.control.TableColumn<>("surname:");
        customerSurname.setCellValueFactory(new PropertyValueFactory<>("company name"));
        customerSurname.setMinWidth(100);

        javafx.scene.control.TableColumn<Customer,String> customerTelephon = new javafx.scene.control.TableColumn<>("telephone:");
        customerTelephon.setCellValueFactory(new PropertyValueFactory<>("cvr"));
        customerTelephon.setMinWidth(100);

        javafx.scene.control.TableColumn<Customer,String> customerMail = new javafx.scene.control.TableColumn<>("mail:");
        customerMail.setCellValueFactory(new PropertyValueFactory<>("mail"));
        customerMail.setMinWidth(100);

        javafx.scene.control.TableColumn<Customer,String> customerUserName = new javafx.scene.control.TableColumn<>("user name:");
        customerUserName.setCellValueFactory(new PropertyValueFactory<>("userName"));
        customerUserName.setMinWidth(100);

        javafx.scene.control.TableColumn<Customer,String> customerPassword = new javafx.scene.control.TableColumn<>("password:");
        customerPassword.setCellValueFactory(new PropertyValueFactory<>("password"));
        customerPassword.setMinWidth(100);
        tableView.getColumns().addAll(customerID, customerName, customerSurname,customerTelephon,customerMail,customerUserName,customerPassword);

        tableView.setItems(databaseCustomer.getCustomers());
    }

}
