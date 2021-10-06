package PageObject;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class AddToCartMP3PlayerPage {

    public SelenideElement desktop = $(By.xpath("//*[@id=\"menu\"]/div[2]/ul/li[1]/a")),
                            showAllDesktop = $(By.xpath("//*[@id=\"menu\"]/div[2]/ul/li[1]/div/a")),
                            mp3Players = $("#column-left > div.list-group > a:nth-child(10)"),
                            iPodTouchImage = $(By.xpath("//*[@id=\"content\"]/div[4]/div[4]/div/div[1]/a/img")),
                            iPodTouch = $("#content > div:nth-child(8) > div:nth-child(4) > div > div:nth-child(2) > div.caption > h4 > a"),
                            addToCart = $("#button-cart"),
                            priceIPodTouch = $("#content > div > div.col-sm-4 > ul:nth-child(4) > li:nth-child(1) > h2");

    @Step
    public SelenideElement CountAndPriceInCart(){
        return $("#cart-total");
    }

}
