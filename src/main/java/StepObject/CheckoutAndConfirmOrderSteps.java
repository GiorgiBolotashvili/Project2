package StepObject;

import PageObject.CheckoutAndConfirmOrderObject;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

public class CheckoutAndConfirmOrderSteps extends CheckoutAndConfirmOrderObject {
    private String _subTotal;
    private String _flatShippingRate;
    private String _totalAmount;

    @Step
    public CheckoutAndConfirmOrderSteps ClickToTotalCart(){
        totalCart.click();
        return this;
    }

    @Step
    public CheckoutAndConfirmOrderSteps SavePriceInfoFromViewCart(){
        _subTotal = saveSubTotal.getText();
        _flatShippingRate = saveFlatShippingRate.getText();
        _totalAmount = saveTotalAmount.getText();
        return this;
    }

    @Step
    public CheckoutAndConfirmOrderSteps ClickToCheckout(){
        checkout.click();
        return this;
    }

    @Step("FillFirstName: Fill in the order details")
    public CheckoutAndConfirmOrderSteps FillFirstName(String fName){
        firstName.sendKeys(fName);
        return this;
    }

    @Step("FillLastName: Fill in the order details")
    public CheckoutAndConfirmOrderSteps FillLastName(String lName){
        lastName.sendKeys(lName);
        return this;
    }

    @Step("FillAddress: Fill in the order details")
    public CheckoutAndConfirmOrderSteps FillAddress(String streetAddress){
        address.sendKeys(streetAddress);
        return this;
    }

    @Step("FillCity: Fill in the order details")
    public CheckoutAndConfirmOrderSteps FillCity(String cityAddress){
        city.sendKeys(cityAddress);
        return this;
    }

    @Step("FillPostCode: Fill in the order details")
    public CheckoutAndConfirmOrderSteps FillPostCode(String zipCode){
        postCode.sendKeys(zipCode);
        return this;
    }

    @Step("FillCountryAndState: Fill in the order details")
    public CheckoutAndConfirmOrderSteps FillCountryAndState(String country, String state){
        for (SelenideElement countryElement : countries ) {
                if(countryElement.getText().equals(country))
                    countryElement.click();
        }
        for (SelenideElement stateElement : states) {
            if (stateElement.getText().equals(state))
                stateElement.click();
        }
        return this;
    }

    @Step
    public CheckoutAndConfirmOrderSteps ClickToContinueBillingDetails(){
        continueBillingDetails.click();
        return this;
    }

    @Step
    public CheckoutAndConfirmOrderSteps ClickToContinueDeliveryDetails(){
        continueDeliveryDetails.click();
        return this;
    }

    @Step
    public CheckoutAndConfirmOrderSteps ClickToContinueDeliveryMethod(){
        continueDeliveryMethod.click();
        return this;
    }

    @Step
    public CheckoutAndConfirmOrderSteps ClickToTermsAndConditions(){
        termsAndConditions.click();
        return this;
    }

    @Step
    public CheckoutAndConfirmOrderSteps ClickToContinuePaymentMethod(){
        continuePaymentMethod.click();
        return this;
    }

    @Step
    public CheckoutAndConfirmOrderSteps CheckConfirmOrder(){
        System.out.println("Starting price: " + _subTotal + ", Shiping: " + _flatShippingRate + ", Total:  " + _totalAmount);
        System.out.println("Confirm Order:  " + subToTal.getText() + ", Shiping: " + flatShippingRate.getText() + ", Total: " + totalAmount.getText());

        subToTal.shouldHave(Condition.text(_subTotal));
        flatShippingRate.shouldHave(Condition.text(_flatShippingRate));
        totalAmount.shouldHave(Condition.text(_totalAmount));
        return this;
    }
}
