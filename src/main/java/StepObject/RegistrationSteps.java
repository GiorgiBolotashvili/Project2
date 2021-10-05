package StepObject;

import PageObject.RegistrationPage;
import io.qameta.allure.Step;


public class RegistrationSteps extends RegistrationPage {

    @Step
    public RegistrationSteps ClickMyAccaunt() {
        myAccaunt.click();
        return this;
    }

    @Step
    public RegistrationSteps ClickRegistration() {
        registration.click();
        return this;
    }

    @Step("FillFirstName: Registration firstname is: {0}")
    public RegistrationSteps FillFirstName(String name) {
        firstName.sendKeys(name);
        return this;
    }

    @Step("FillLastName: Registration lastname is: {0}")
    public RegistrationSteps FillLastName(String last) {
        lastName.sendKeys(last);
        return this;
    }

    @Step("FillEmail: Registration email is: {0}")
    public RegistrationSteps FillEmail(String email) {
        emailAdress.sendKeys(email);
        return this;
    }

    @Step("FillPhoneNumber: Registration phone number is: {0}")
    public RegistrationSteps FillPhoneNumber(String phone) {
        phoneNumber.sendKeys(phone);
        return this;
    }

    @Step
    public RegistrationSteps FillPassword(String pass) {
        password.sendKeys(pass);
        confirmPassword.sendKeys(pass);
        return this;
    }

    @Step
    public RegistrationSteps AgreeToThePrivacyPolicy() {
        privacyPolicy.scrollTo();
        privacyPolicy.click();
        return this;
    }
    @Step
    public RegistrationSteps ContinueButton() {
        continueButton.scrollTo();
        continueButton.click();
        return this;
    }

    @Step
    public RegistrationSteps ContinueRegistration() {
        continueRegistration.click();
        return this;
    }

}
