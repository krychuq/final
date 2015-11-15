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
public class SignUpCustomer {
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

        Label surname = new Label("Surname:");
        GridPane.setConstraints(surname, 0, 1);
        TextField surnameTextField = new TextField();
        GridPane.setConstraints(surnameTextField, 1, 1);
        GridPane.setConstraints(wrongLabel, 0, 0,1,1, HPos.CENTER, VPos.TOP);
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

        Label user = new Label("User name:");
        GridPane.setConstraints(user, 0, 4);

        TextField userTextField = new TextField();
        GridPane.setConstraints(userTextField, 1, 4);

        Label password = new Label("Password:");
        GridPane.setConstraints(password, 0, 5);

        PasswordField passwordTextField = new PasswordField();
        GridPane.setConstraints(passwordTextField, 1, 5);

        gridPane.setGridLinesVisible(false);
        Button save = new Button("Save");
        GridPane.setConstraints(save, 1, 7);
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
        GridPane.setConstraints(cancel, 1, 8);


        save.setOnAction(event -> {

            if ((nameTextField.getText().equals("")) || (surnameTextField.getText().equals("")) || (telephoneTextField.getText().equals(""))
                    || (mailTextField.getText().equals("")) && (userTextField.getText().equals("")) || (nameTextField.getText().equals("")) ||
                    (passwordTextField.getText().equals(""))) {
                //  int phoneNumber = Integer.parseInt(telephoneTextField.getText());
                System.out.println("empty textFields");
                wrongLabel.setText("Please fill all of textFields");
                wrongLabel.setTextFill(Color.RED);

            } else {
                int phoneNumber = 13232;

                databaseCustomer.insertCustomer(nameTextField.getText(), surnameTextField.getText(), phoneNumber,
                        mailTextField.getText(), userTextField.getText(), passwordTextField.getText());
                primaryStage.close();

            }

        });


        gridPane.getChildren().addAll(name, nameTextField, surname, surnameTextField, telephone, telephoneTextField, mail, mailTextField, user, userTextField, password, passwordTextField, save, cancel);


        Scene scene = new Scene(gridPane, 400, 300);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

}










