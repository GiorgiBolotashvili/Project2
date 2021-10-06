package StepObject;

import PageObject.AddToCartMP3PlayerPage;
import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import org.testng.Assert;

public class AddToCartMP3PlayerSteps extends AddToCartMP3PlayerPage {

    @Step
    public AddToCartMP3PlayerSteps MoveToDesktop(){
        desktop.hover();
        return this;
    }

    @Step
    public AddToCartMP3PlayerSteps ShowAllDesktop(){
        showAllDesktop.click();
        return this;
    }

    @Step
    public AddToCartMP3PlayerSteps ClickMP3Pleyers(){
        mp3Players.click();
        return  this;
    }

    @Step
    public AddToCartMP3PlayerSteps MoveToiPodTouch(){
        iPodTouchImage.hover();
        return this;
    }

    @Step
    public AddToCartMP3PlayerSteps CheckiPodTouchText(String text){
        iPodTouchImage.shouldHave(Condition.attribute("title", text));
        return this;
    }

    @Step
    public AddToCartMP3PlayerSteps ClickiPodTouch(){
        iPodTouch.click();
        return this;
    }

    @Step
    public AddToCartMP3PlayerSteps ClickAddCart(){
        addToCart.click();
        return this;
    }

    @Step
    public AddToCartMP3PlayerSteps CheckCountAndPrice(String count, String price){
        System.out.println("1: - " + CountAndPriceInCart().getText());
        while(true){
            if(CountAndPriceInCart().getText().substring(0,1).equals(count)){
                break;
            }
        }
        System.out.println("2: - " + CountAndPriceInCart().getText());
        String countAndPrice = CountAndPriceInCart().getText();
        Assert.assertEquals(countAndPrice.substring(0,1), count);
        Assert.assertEquals(countAndPrice.substring(countAndPrice.indexOf("$")), price);
        return this;
    }

    @Step
    public String GetiPodTouchPrice(){
        System.out.println(priceIPodTouch.getText());
        return priceIPodTouch.getText();
    }
}
