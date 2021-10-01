package PageObject;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;

public class RegistrationPage {

    public SelenideElement myAccaunt = $(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/a/span[1]")),
            registration = $(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/ul/li[1]/a")),
            firstName = $("input#input-firstname"),
            lastName = $("input#input-lastname"),
            emailAdress = $("input#input-email"),
            phoneNumber = $("input#input-telephone"),
            password = $("input#input-password"),
            confirmPassword = $("input#input-confirm"),
            privacyPolicy = $("input[type='checkbox']"),
            continueButton = $(By.className("btn-primary")),
            continueRegistration = $(By.className("pull-right"));
}
