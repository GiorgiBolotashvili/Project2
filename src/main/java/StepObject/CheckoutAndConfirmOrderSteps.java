package StepObject;

import PageObject.CheckoutAndConfirmOrderObject;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

public class CheckoutAndConfirmOrderSteps extends CheckoutAndConfirmOrderObject {
    private String _subTotal;
    private String _flatShippingRate;
    private String _totalAmount;

    public CheckoutAndConfirmOrderSteps ClickToTotalCart(){
        totalCart.click();
        return this;
    }
    public CheckoutAndConfirmOrderSteps SavePriceInfoFromViewCart(){
        _subTotal = saveSubTotal.getText();
        _flatShippingRate = saveFlatShippingRate.getText();
        _totalAmount = saveTotalAmount.getText();
        return this;
    }

    public CheckoutAndConfirmOrderSteps ClickToCheckout(){
        checkout.click();
        return this;
    }
    public CheckoutAndConfirmOrderSteps FillFirstName(String fName){
        firstName.sendKeys(fName);
        return this;
    }
    public CheckoutAndConfirmOrderSteps FillLastName(String lName){
        lastName.sendKeys(lName);
        return this;
    }
    public CheckoutAndConfirmOrderSteps FillAddress(String streetAddress){
        address.sendKeys(streetAddress);
        return this;
    }
    public CheckoutAndConfirmOrderSteps FillCity(String cityAddress){
        city.sendKeys(cityAddress);
        return this;
    }
    public CheckoutAndConfirmOrderSteps FillPostCode(String zipCode){
        postCode.sendKeys(zipCode);
        return this;
    }
    public CheckoutAndConfirmOrderSteps FillCountryAndState(String country, String state){
        System.out.println("Country count: " + countries.size());
        System.out.println("State count: " + states.size());

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

    public CheckoutAndConfirmOrderSteps ClickToContinueBillingDetails(){
        continueBillingDetails.click();
        return this;
    }
    public CheckoutAndConfirmOrderSteps ClickToContinueDeliveryDetails(){
        continueDeliveryDetails.click();
        return this;
    }
    public CheckoutAndConfirmOrderSteps ClickToContinueDeliveryMethod(){
        continueDeliveryMethod.click();
        return this;
    }
    public CheckoutAndConfirmOrderSteps ClickToTermsAndConditions(){
        termsAndConditions.click();
        return this;
    }
    public CheckoutAndConfirmOrderSteps ClickToContinuePaymentMethod(){
        continuePaymentMethod.click();
        return this;
    }
    public CheckoutAndConfirmOrderSteps CheckConfirmOrder(){
        System.out.println("Save price: " + _subTotal +", " + _flatShippingRate + ", " + _totalAmount);
        System.out.println("Payment table: " + subToTal.getText() +", " + flatShippingRate.getText() + ", " + totalAmount.getText());

        subToTal.shouldHave(Condition.text(_subTotal));
        flatShippingRate.shouldHave(Condition.text(_flatShippingRate));
        totalAmount.shouldHave(Condition.text(_totalAmount));
        return this;
    }
}
