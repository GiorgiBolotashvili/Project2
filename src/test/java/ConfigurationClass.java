import DataObject.GenerateDataObject;
import com.codeborne.selenide.AssertionMode;
import com.codeborne.selenide.Selenide;
import org.openqa.selenium.WebDriver;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import static com.codeborne.selenide.Selenide.open;

public class ConfigurationClass {
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

    public ConfigurationClass() {
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

    public WebDriver GetDriver() {
        return Selenide.webdriver().object();
    }

}
