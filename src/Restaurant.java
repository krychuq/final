import javafx.scene.image.Image;

/**
 * Created by krystian on 2015-11-14.
 */
public class Restaurant {

    String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getAddres() {
        return addres;
    }

    public void setAddres(String addres) {
        this.addres = addres;
    }

    public int getCvr() {
        return cvr;
    }

    public void setCvr(int cvr) {
        this.cvr = cvr;
    }





    public int getTelephone() {
        return telephone;
    }

    public void setTelephone(int telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    String companyName;

    public Restaurant(int restaurantId, String name, String addres, String companyName, int cvr, int telephone, String email,String login, String password) {
        this.restaurantId = restaurantId;
        this.name = name;
        this.addres = addres;
        this.companyName = companyName;
        this.cvr = cvr;

        this.telephone = telephone;
        this.email = email;
        this.login = login;

    }

    String addres;



    int cvr;

    int telephone;
    String email;
    String password;
    String login;

    public int getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(int restaurantId) {
        this.restaurantId = restaurantId;
    }

    int restaurantId;


}
