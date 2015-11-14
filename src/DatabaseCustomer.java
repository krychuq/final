import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.sql.*;

/**
 * Created by lucia on 11/10/15.
 */
public class DatabaseCustomer {
    private Connection conn=null;
    Customer customer;

    public DatabaseCustomer(){
        System.out.println("***********Welcome to connections**************");
        try {

            // String DB_URL = "jdbc:mysql://luftbike.dk.mysql:3306/luftbike_dk";
            String DB_URL = "jdbc:mysql://sql4.freesqldatabase.com:3306/sql496304";

            String USER = "sql496304";
            String PASS = "JnfWuYHb7F";
            // nameOfDbOnline https://dbadmin.one.com/index.php
            //luftbike.dk
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("conn obj created" + conn + " message: ");


            //deleteFromDB("personse", 4);
            //  updateInDB("persons", 3, "Ragnhild", "goodday");
            // System.out.println(getPerson("anna"));

        }
        catch (SQLException e)
        {
            System.out.println("db error" + e.getMessage());
        }

    }




    public void insertBooking(String name, String surname,int phone,String email,String user, String password) {
        String sql = "INSERT INTO customer VALUES (NULL , ?, ?, ?,?,?,?)";

        try {
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1,name);
            preparedStatement.setString(2, surname);
            preparedStatement.setInt(3, phone);
            preparedStatement.setString(4, email);
            preparedStatement.setString(5, user);
            preparedStatement.setString(6, password);


            int numberOfRows = preparedStatement.executeUpdate();
            System.out.println("Completed insert. Number of rows affected:" + numberOfRows);
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
    public ObservableList<Customer> getCustomers(){
        ObservableList<Customer> observableList = FXCollections.observableArrayList();
        Customer customer;

        String out = "";
        String sql = "SELECT * FROM customer";

        try {
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {

               // String name = resultSet.getString(2)+" "+resultSet.getString(3);
                customer = new Customer(resultSet.getInt(1),resultSet.getString(2),resultSet.getString(3),resultSet.getInt(4),
                        resultSet.getString(5),resultSet.getString(6),resultSet.getString(7));
                        observableList.addAll(customer);


            }
        } catch (SQLException e) {
            e.printStackTrace();

        }
        return  observableList;

    }

    public Customer checkLoginAndPassword(String login, String password){
        try {
            String sql = "SELECT * FROM customer WHERE username= ? AND password= ?";

            //Statement statement=conn.createStatement();
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, login);
            preparedStatement.setString(2, password);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {

                customer =  new Customer(resultSet.getInt(1),resultSet.getString(2),resultSet.getString(3),resultSet.getInt(4),
                        resultSet.getString(5),resultSet.getString(6),resultSet.getString(7));

            } else {
                customer = null;

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return  customer;
    }

    private void updateAppointmentCount(){
        try
        {
            String sql =
                    "SELECT user,password FROM doctorBooking\n" +
                            "INNER JOIN doctor ON \n" +
                            "doctor.iD = doctorBooking.doctorID\n" +
                            "GROUP BY doctorBooking.doctorID;";


            //Statement statement=conn.createStatement();
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            Label label = new Label("Name: \t\t\t\tNumber of appointments:");
            while(resultSet.next()) {
                label = new Label(resultSet.getString(1)+" \t\t\t\t" + resultSet.getInt(2));




            }
        } catch (SQLException e)
        {
            e.printStackTrace();
        }

    }





}
