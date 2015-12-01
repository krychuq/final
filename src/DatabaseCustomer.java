import com.sun.org.apache.xpath.internal.SourceTree;
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
    Restaurant restaurant;
    public DatabaseCustomer(){


    }

    public void conectToDb(){
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




    public void insertCustomer(Customer insertCustomer1) {
        Customer insertCustomer = insertCustomer1;
        String sql = "INSERT INTO customer VALUES ( ?, ?, ?,?,?,?)";


        try {
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1,insertCustomer.getMail());
            preparedStatement.setString(2, insertCustomer.getUser());
            preparedStatement.setString(3, insertCustomer.getName());
            preparedStatement.setString(4, insertCustomer.getSurname());
            preparedStatement.setInt(5, insertCustomer.getTelephone());
            preparedStatement.setString(6, insertCustomer.getPassword());


            int numberOfRows = preparedStatement.executeUpdate();
            System.out.println("Completed insert. Number of rows affected:" + numberOfRows);
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
    public void insertCustomerWithoutReservation(Customer customer2) {
        Customer insertCustomerWithoutReservation = customer2;
        String sql = "INSERT INTO customer VALUES ( ?, NULL , ?,?,?,NULL )";


        try {
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1,insertCustomerWithoutReservation.getMail());
            preparedStatement.setString(2, insertCustomerWithoutReservation.getName());
            preparedStatement.setString(3, insertCustomerWithoutReservation.getSurname());
            preparedStatement.setInt(4, insertCustomerWithoutReservation.getTelephone());


            int numberOfRows = preparedStatement.executeUpdate();
            System.out.println("Completed insert. Number of rows affected:" + numberOfRows);
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
    public void insertBooking(Booking booking){
        String sql = "INSERT INTO booking VALUES (null, ?, ?,?,?)";
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(sql);

            preparedStatement.setInt(2, booking.getCvr());
            preparedStatement.setString(1, booking.getUserName());
            preparedStatement.setTimestamp(3, booking.getDate());
            preparedStatement.setInt(4, booking.getNumberOfPeople());


            int numberOfRows = preparedStatement.executeUpdate();
            System.out.println("Completed insert. Number of rows affected:" + numberOfRows);
        } catch (SQLException e) {
            e.printStackTrace();
        }



    }
    public void insertRestaurant(int cvr, String nameOfRestaurant, String companyName, String address, int phone,String mail, String password) {
        String sql = "INSERT INTO restaurant VALUES (?, ?,?,?,?,?,?)";

        try {
            PreparedStatement preparedStatement = conn.prepareStatement(sql);

            preparedStatement.setInt(1, cvr);
            preparedStatement.setString(2, nameOfRestaurant);
            preparedStatement.setString(3, companyName);
            preparedStatement.setString(4, address);
            preparedStatement.setInt(5, phone);
            preparedStatement.setString(6, mail);
            preparedStatement.setString(7, password);


            int numberOfRows = preparedStatement.executeUpdate();
            System.out.println("Completed insert. Number of rows affected:" + numberOfRows);
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    public String getDescriptionOfRestaurant(int cvr) throws SQLException {
        String description ="";
        String sql = "SELECT description FROM restaurant WHERE cvr =?";
        PreparedStatement preparedStatement = conn.prepareStatement(sql);
        preparedStatement.setInt(1, cvr);
        ResultSet resultSet = preparedStatement.executeQuery();

        if (resultSet.next()) {


            description = resultSet.getString(1);


        }
        return  description;

    }


    public ObservableList<String> getRetaurants(){
        ObservableList<String> observableList = FXCollections.observableArrayList();
        Customer customer;

        String out = "";
        String sql = "SELECT nameOfRestaurant FROM restaurant";

        try {
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {



                observableList.add(resultSet.getString(1));


            }
        } catch (SQLException e) {
            e.printStackTrace();

        }
        return  observableList;

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


                customer = new Customer(resultSet.getString(1),resultSet.getString(2),resultSet.getString(3),resultSet.getString(4),
                        resultSet.getInt(5),resultSet.getString(6));

                observableList.add(customer);


            }
        } catch (SQLException e) {
            e.printStackTrace();

        }
        return  observableList;

    }

    public Customer checkLoginAndPassword(String login, String password){
        try {
            String sql = "SELECT * FROM customer WHERE user= ? AND password= ?";

            //Statement statement=conn.createStatement();
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, login);
            preparedStatement.setString(2, password);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {

                customer = new Customer(resultSet.getString(1),resultSet.getString(2),resultSet.getString(3),resultSet.getString(4),
                        resultSet.getInt(5),resultSet.getString(6));


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
    public int getRestaurant(String name){
        String sql ="SELECT cvr FROM restaurant WHERE nameOfRestaurant = ?";
        int cvr = 0;
        try
        {
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, name);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                cvr = resultSet.getInt(1);

            }
        } catch (SQLException e)
        {
            e.printStackTrace();
        }
       return  cvr;
    }
    public void deleteFromDB(String username)
    {
        String sql="DELETE FROM customer WHERE user = ?";
        try
        {
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, username);
            int numberOfRows= preparedStatement.executeUpdate();
            System.out.println("Completed delete. Number of rows affected:"+numberOfRows);
        } catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    public ObservableList<String> numberOfpeopleComboBox(){
        ObservableList<String> observableList = FXCollections.observableArrayList();
        observableList.add("1 person");
        observableList.add("2 people");
        observableList.add("3 people");
        observableList.add("4 people");
        observableList.add("5 people");
        observableList.add("6 people");
        observableList.add("7 people");
        observableList.add("8 people");

        return observableList;
    }


    public ObservableList<String> hourInCombobox(){
        ObservableList<String> observableList1 = FXCollections.observableArrayList();
        observableList1.addAll("15:00", "15:30", "16:00", "16:30", "17:00", "17:30", "18:00", "18:30",
                "19:00", "19:30");

        return  observableList1;

    }








}
