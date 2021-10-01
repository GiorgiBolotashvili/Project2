package StepObject;

import PageObject.RegistrationPage;
import io.qameta.allure.*;

public class RegistrationSteps extends RegistrationPage {

    public RegistrationSteps() {
        System.out.println("RegistrationSteps");
    }


    public RegistrationSteps ClickMyAccaunt() {
        myAccaunt.click();
        return this;
    }


    public RegistrationSteps ClickRegistration() {
        registration.click();
        return this;
    }


    public RegistrationSteps FillFirstName(String name) {
        firstName.sendKeys(name);
        return this;
    }


    public RegistrationSteps FillLastName(String last) {
        lastName.sendKeys(last);
        return this;
    }


    public RegistrationSteps FillEmail(String email) {
        emailAdress.sendKeys(email);
        return this;
    }


    public RegistrationSteps FillPhoneNumber(String phone) {
        phoneNumber.sendKeys(phone);
        return this;
    }


    public RegistrationSteps FillPassword(String pass) {
        password.sendKeys(pass);
        confirmPassword.sendKeys(pass);
        return this;
    }


    public RegistrationSteps AgreeToThePrivacyPolicy() {
        privacyPolicy.scrollTo();
        privacyPolicy.click();
        return this;
    }

    public RegistrationSteps ContinueButton() {
        continueButton.scrollTo();
        continueButton.click();
        return this;
    }

    public RegistrationSteps ContinueRegistration() {
        continueRegistration.click();
        return this;
    }

}
