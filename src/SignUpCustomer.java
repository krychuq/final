import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import javax.xml.soap.Text;

/**
 * Created by lucia on 11/10/15.
 */
public class SignUpCustomer {
    Stage primaryStage;

    public void signup()

    {
        primaryStage = new Stage();
        primaryStage.setTitle("SIGN IN");
        GridPane signUp = new GridPane();
        signUp.setPadding(new Insets(10, 10, 10, 10));
        signUp.setVgap(8);
        signUp.setHgap(10);
        DatabaseCustomer databaseCustomer = new DatabaseCustomer();


        Label name = new Label("Name:");
        GridPane.setConstraints(name, 0, 0);
        TextField nameTextField = new TextField();
        GridPane.setConstraints(nameTextField, 1, 0);
        Label surname = new Label("Surname:");
        GridPane.setConstraints(surname, 0, 1);
        TextField surnameTextField = new TextField();
        GridPane.setConstraints(surnameTextField, 1, 1);
        Label telephone = new Label("Phone number:");
        GridPane.setConstraints(telephone, 0, 2);
        TextField telephoneTextField = new TextField();
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

        Button save = new Button("Save");
        GridPane.setConstraints(save, 1, 7);

        Button cancel = new Button("Cancel");
        GridPane.setConstraints(cancel, 1, 8);


        save.setOnAction(event -> {
            int phoneNumber = Integer.parseInt(telephoneTextField.getText());

            databaseCustomer.insertBooking(nameTextField.getText(), surnameTextField.getText(), phoneNumber, mailTextField.getText(), userTextField.getText(), passwordTextField.getText());
            //primaryStage.close();

        });


        signUp.getChildren().addAll(name, nameTextField, surname, surnameTextField, telephone, telephoneTextField, mail, mailTextField, user, userTextField, password, passwordTextField, save, cancel);


        Scene scene = new Scene(signUp, 400, 300);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

}










