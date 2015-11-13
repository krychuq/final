/**
 * Created by krystian on 2015-11-12.
 */
public class Customer {
    int customerID;

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getTelephone() {
        return telephone;
    }

    public void setTelephone(int telephone) {
        this.telephone = telephone;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
    public  String getPassword(){
        return  password;
    }
    public void setPassword(String password){
        this.password = password;
    }

    String name;
    String surname;
    int telephone;
    String mail;
    String userName;
    String password;

    public Customer(int customerID, String name,String surname, int telephone,String mail,String userName,String password){
        this.customerID = customerID;
        this.name = name;
        this.surname = surname;
        this.telephone = telephone;
        this.mail = mail;
        this.userName = userName;
        this.password = password;
    }

}
