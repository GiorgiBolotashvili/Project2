import com.codeborne.selenide.AssertionMode;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.openqa.selenium.WebDriver;

import java.util.Random;

import static com.codeborne.selenide.Selenide.open;

public class ConfigurationClass {

    public ConfigurationClass(){
        Configuration.assertionMode = AssertionMode.SOFT;
        Configuration.savePageSource = false;
        Configuration.screenshots = false;
        Configuration.timeout = 5000; //Long.parseLong(System.getProperty("selenide.timeout", "5000"));

        System.out.println("Configuration");
    }

    public void OpenUrl(String url){
        Configuration.startMaximized = true;
        Configuration.browser = "chrome";
        open(url);
    }

    public WebDriver GetDriver(){
        return Selenide.webdriver().object();
    }

    public String GenerateEmail(){
        Random r = new Random();
        String email = "";
        for (int i = 0; i < 10; i++) {
            email += (char) ('a' + r.nextInt(26));
        }
        return email + "@Gmail.com";
    }
}
