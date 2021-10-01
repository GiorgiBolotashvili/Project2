import DataObject.GenerateDataObject;
import com.codeborne.selenide.AssertionMode;
import com.codeborne.selenide.Selenide;
import org.openqa.selenium.WebDriver;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static com.codeborne.selenide.Selenide.open;

public class BaseClass {
    protected String firstName;
    protected String lastName;
    protected String phone;
    protected String password;
    protected String address;
    protected String email;
    protected String country;
    protected String state;
    protected String city;
    protected Integer zip;
    protected GenerateDataObject generateData;
    protected Connection connect;
    protected PreparedStatement pst;
    protected ResultSet result;
    protected String url = "http://tutorialsninja.com/demo/";

    public BaseClass() {
        com.codeborne.selenide.Configuration.assertionMode = AssertionMode.SOFT;
        com.codeborne.selenide.Configuration.savePageSource = false;
        com.codeborne.selenide.Configuration.screenshots = false;
        com.codeborne.selenide.Configuration.timeout = Long.parseLong(System.getProperty("selenide.timeout", "8000"));

        System.out.println("Configuration");
    }

    public void OpenUrl() {
        com.codeborne.selenide.Configuration.startMaximized = true;
        com.codeborne.selenide.Configuration.browser = "chrome";
        open(url);
    }

    public void GetResultData(ResultSet result){
        try {
            while (result.next()) {
                firstName = result.getString(2);
                lastName = result.getString(3);
                phone = result.getString(4);
                password = result.getString(5);
                address = result.getString(6);
                email = result.getString(7);
                country = result.getString(8);
                state = result.getString(9);
                city = result.getString(10);
                zip = Integer.parseInt(result.getString(11));
            }
        }catch (SQLException throwables) {
            System.out.println("Error cennecting to the database");
            throwables.printStackTrace();
        }
    }

    public WebDriver GetDriver() {
        return Selenide.webdriver().object();
    }

}
