import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * Created by lucia on 11/10/15.
 */
public class SignUpRestaurant {
    Stage primaryStage;
    Label wrongLabel = new Label("");


    public void signup()

    {
        primaryStage = new Stage();
        primaryStage.setTitle("SIGN IN");
        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(10, 10, 10, 10));
        gridPane.setVgap(8);
        gridPane.setHgap(10);
        DatabaseCustomer databaseCustomer = new DatabaseCustomer();


        Label name = new Label("Name:");
        GridPane.setConstraints(name, 0, 0, 1, 1, HPos.LEFT, VPos.BOTTOM);
        gridPane.getRowConstraints().add(new RowConstraints(40));
        TextField nameTextField = new TextField();

        GridPane.setConstraints(nameTextField, 1, 0, 1, 1, HPos.CENTER, VPos.BOTTOM);

        Label companyNameLabel = new Label("Company name:");
        GridPane.setConstraints(companyNameLabel, 0, 1);
        TextField companyTextField = new TextField();
        GridPane.setConstraints(companyTextField, 1, 1);
        GridPane.setConstraints(wrongLabel, 0, 0, 1, 1, HPos.CENTER, VPos.TOP);
        GridPane.setColumnSpan(wrongLabel, 2);

        gridPane.getChildren().addAll(wrongLabel);
        Label telephone = new Label("Phone number:");
        GridPane.setConstraints(telephone, 0, 2);
        AttributeTextField telephoneTextField = new AttributeTextField();
        telephoneTextField.setMaxWidth(150);
        GridPane.setConstraints(telephoneTextField, 1, 2);
        Label mail = new Label("Mail");
        GridPane.setConstraints(mail, 0, 3);
        TextField mailTextField = new TextField();
        GridPane.setConstraints(mailTextField, 1, 3);

        Label cvrLabel = new Label("CVR: ");
        TextField cvrTextField = new TextField();
        GridPane.setConstraints(cvrLabel, 0 ,4) ;
        GridPane.setConstraints(cvrTextField, 1,4);


        Label address= new Label("Address:");
        GridPane.setConstraints( address, 0, 5);

        TextField addressTextField = new TextField();
        GridPane.setConstraints(addressTextField, 1, 5);
        Label loginLabel = new Label("Login: ");
        GridPane.setConstraints(loginLabel, 0,6);
        TextField loginTextField = new TextField();
        GridPane.setConstraints(loginTextField, 1,6);

        Label password = new Label("Password:");
        GridPane.setConstraints(password, 0, 7);

        PasswordField passwordTextField = new PasswordField();
        GridPane.setConstraints(passwordTextField, 1, 7);

        gridPane.setGridLinesVisible(false);
        Button save = new Button("Save");
        GridPane.setConstraints(save, 1, 8);
        primaryStage.setOnCloseRequest(event1 -> {

            event1.consume();
            boolean result = ConfimBox.display("Warning", "Are you sure you want to close?");
            if (result) {
                primaryStage.close();
            }

        });
        Button cancel = new Button("Cancel");
        cancel.setOnAction(event1 -> {
            cancel.setOnAction(event -> {

                boolean result = ConfimBox.display("Warning", "You sure you want to cancel now?");
                if (result) {

                    primaryStage.close();
                }
            });
        });
        GridPane.setConstraints(cancel, 1, 9);


        save.setOnAction(event -> {

            if ((nameTextField.getText().equals("")) || (companyTextField.getText().equals("")) || (telephoneTextField.getText().equals(""))
                    || (mailTextField.getText().equals("")) && (addressTextField.getText().equals("")) || (nameTextField.getText().equals("")) ||
                    (passwordTextField.getText().equals(""))) {
                //  int phoneNumber = Integer.parseInt(telephoneTextField.getText());
                System.out.println("empty textFields");
                wrongLabel.setText("Please fill all of textFields");
                wrongLabel.setTextFill(Color.RED);

            } else {
                int cvr = Integer.parseInt(cvrTextField.getText());
                int phone = Integer.parseInt(telephoneTextField.getText());


                databaseCustomer.insertRestaurant(nameTextField.getText(), companyTextField.getText(), cvr,addressTextField.getText(),
                       phone, mailTextField.getText(),loginTextField.getText(),passwordTextField.getText());
                primaryStage.close();

            }

        });


        gridPane.getChildren().addAll(name, nameTextField, companyNameLabel,companyTextField, telephone, telephoneTextField, mail, mailTextField, cvrLabel,cvrTextField, address, addressTextField, password,
                passwordTextField, loginLabel,loginTextField, save, cancel);


        Scene scene = new Scene(gridPane, 400, 300);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

}










