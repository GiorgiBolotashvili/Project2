package PageObject;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class CheckoutAndConfirmOrdePage {

        public SelenideElement totalCart = $("#cart-total"),
                        checkout = $("#cart > ul > li:nth-child(2) > div > p > a:nth-child(2) > strong"),
                        saveSubTotal = $("#cart > ul > li:nth-child(2) > div > table > tbody > tr:nth-child(1) > td:nth-child(2)"),
                        saveFlatShippingRate = $("#cart > ul > li:nth-child(2) > div > table > tbody > tr:nth-child(2) > td:nth-child(2)"),
                        saveTotalAmount = $("#cart > ul > li:nth-child(2) > div > table > tbody > tr:nth-child(4) > td:nth-child(2)"),
                        saveTotalAmount2 = $("#cart > ul > li:nth-child(2) > div > table > tbody > tr:nth-child(3) > td:nth-child(2)"),
                        firstName = $("#input-payment-firstname"),
                        lastName = $("#input-payment-lastname"),
                        address = $("#input-payment-address-1"),
                        city = $("#input-payment-city"),
                        postCode = $("#input-payment-postcode"),
                        continueBillingDetails = $("#button-payment-address"),
                        continueDeliveryDetails = $("#button-shipping-address"),
                        continueDeliveryMethod = $("#button-shipping-method"),
                        termsAndConditions = $(By.xpath(("//*[@id=\"collapse-payment-method\"]/div/div[2]/div/input[1]"))),
                        continuePaymentMethod = $("#button-payment-method"),
                        subToTal = $(By.xpath("//*[@id=\"collapse-checkout-confirm\"]/div/div[1]/table/tfoot/tr[1]/td[2]")),
                        flatShippingRate = $(By.xpath("//*[@id=\"collapse-checkout-confirm\"]/div/div[1]/table/tfoot/tr[2]/td[2]")),
                        totalAmount = $(By.xpath("//*[@id=\"collapse-checkout-confirm\"]/div/div[1]/table/tfoot/tr[3]/td[2]")),
                        confirmOrder = $("#buttonConfirm"),
                        checkStateText = $("#input-payment-zone > option:nth-child(2)"),
                existingAddress = $("#collapse-payment-address > div > form > div:nth-child(3) > label > input[type=radio]");

        public ElementsCollection countries = $$("#input-payment-country > option"),
                                states = $$("#input-payment-zone > option");

}
