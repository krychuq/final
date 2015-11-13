import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.*;
import javafx.stage.Stage;


public class ReservationSystem extends Application {
    TableView tableView;
    Stage window;
    SignUpCustomer signUpCustomer = new SignUpCustomer();
    DatabaseCustomer databaseCustomer = new DatabaseCustomer();
    public static void main(String[] args) {
        launch(args);

    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        window = primaryStage;
        window.setTitle("RESERVATION SYSTEM");



        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(8);
        grid.setHgap(10);


        Label userName = new Label("Username:");
        GridPane.setConstraints(userName,0,0);
        TextField nameInput = new TextField();
        GridPane.setConstraints(nameInput,1,0);
        Label password = new Label("Password:");
        GridPane.setConstraints(password,0,1);
        PasswordField passwordInput = new PasswordField();
        GridPane.setConstraints(passwordInput,1,1);

        Button logIn = new Button("Log In");
        GridPane.setConstraints(logIn, 1, 2);

        Button signUp = new Button("Sign Up");
        GridPane.setConstraints(signUp, 1, 3);

        Button showAllCustumer = new Button("show all custumers");
        showAllCustumer.setOnAction(event1 -> {
            showAllTable();
        });
        GridPane.setConstraints(showAllCustumer,1,4);

       signUp.setOnAction(event -> {
               signUpCustomer.signup();
       });

        grid.getChildren().addAll(userName,nameInput,password,passwordInput,logIn,signUp,showAllCustumer);
        Scene scene = new Scene(grid,300,200);
        window.setScene(scene);
        window.show();
    }

    private void closeProgram(){

       // Boolean answer = ConfirmBox.display("Warning","Are you sure, you want to close the program");

       // if(answer){
      //      window.close();
      //  }

    }
    private void showAllTable(){

        Stage window = new Stage();
        VBox vBox = new VBox(10);
        createTableOfAppoitment();
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


    private void createTableOfAppoitment(){
        tableView= new TableView();
        tableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        javafx.scene.control.TableColumn<Customer,String> customerID = new javafx.scene.control.TableColumn<>("name");
        customerID.setCellValueFactory(new PropertyValueFactory<>("customerID"));
        customerID.setMinWidth(100);


        javafx.scene.control.TableColumn<Customer,String> customerName = new javafx.scene.control.TableColumn<>("Time of appointment:");
        customerName.setCellValueFactory(new PropertyValueFactory<>("name"));
        customerName.setMinWidth(100);

        javafx.scene.control.TableColumn<Customer,String> customerSurname = new javafx.scene.control.TableColumn<>("fdaf:");
        customerSurname.setCellValueFactory(new PropertyValueFactory<>("surname"));
        customerSurname.setMinWidth(100);

        javafx.scene.control.TableColumn<Customer,String> customerTelephon = new javafx.scene.control.TableColumn<>("dfa:");
        customerTelephon.setCellValueFactory(new PropertyValueFactory<>("telephone"));
        customerTelephon.setMinWidth(100);

        javafx.scene.control.TableColumn<Customer,String> customerMail = new javafx.scene.control.TableColumn<>("fdasfad:");
        customerMail.setCellValueFactory(new PropertyValueFactory<>("mail"));
        customerMail.setMinWidth(100);

        javafx.scene.control.TableColumn<Customer,String> customerUserName = new javafx.scene.control.TableColumn<>("Reason:");
        customerUserName.setCellValueFactory(new PropertyValueFactory<>("userName"));
        customerUserName.setMinWidth(100);

        javafx.scene.control.TableColumn<Customer,String> customerPassword = new javafx.scene.control.TableColumn<>("Reason:");
        customerPassword.setCellValueFactory(new PropertyValueFactory<>("password"));
        customerPassword.setMinWidth(100);
        tableView.getColumns().addAll(customerID, customerName, customerSurname,customerTelephon,customerMail,customerUserName,customerPassword);

        tableView.setItems(databaseCustomer.getCustomers());

    }

}
