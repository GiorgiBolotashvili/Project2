package StepObject;

import PageObject.AddToCartMP3PlayerObject;
import com.codeborne.selenide.Condition;
import org.testng.Assert;

public class AddToCartMP3PlayerSteps extends AddToCartMP3PlayerObject {

    public AddToCartMP3PlayerSteps MoveToDesktop(){
        desktop.hover();
        return this;
    }

    public AddToCartMP3PlayerSteps ShowAllDesktop(){
        showAllDesktop.click();
        return this;
    }

    public AddToCartMP3PlayerSteps ClickMP3Pleyers(){
        mp3Players.click();
        return  this;
    }

    public AddToCartMP3PlayerSteps MoveToiPodShuffle(){
        iPodShuffleImage.hover();
        return this;
    }
    public AddToCartMP3PlayerSteps CheckiPodShuffleText(String text){
        iPodShuffleImage.shouldHave(Condition.attribute("title", text));
        return this;
    }
    public AddToCartMP3PlayerSteps ClickiPodShuffle(){
        iPodShuffle.click();
        return this;
    }

    public AddToCartMP3PlayerSteps ClickAddCart(){
        addToCart.click();
        return this;
    }

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

    public String GetiPodShufflePrice(){
        System.out.println(priceIPodShuffle.getText());
        return priceIPodShuffle.getText();
    }
}
