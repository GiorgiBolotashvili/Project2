package PageObject;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class AddToCartMP3PlayerObject {

    public SelenideElement desktop = $(By.xpath("//*[@id=\"menu\"]/div[2]/ul/li[1]/a")),
                            showAllDesktop = $(By.xpath("//*[@id=\"menu\"]/div[2]/ul/li[1]/div/a")),
                            mp3Players = $("#column-left > div.list-group > a:nth-child(10)"),
                            iPodShuffleImage = $(By.xpath("//*[@id=\"content\"]/div[4]/div[3]/div/div[1]/a/img")),
                            iPodShuffle = $("#content > div:nth-child(8) > div:nth-child(3) > div > div:nth-child(2) > div.caption > h4 > a"),
                            addToCart = $("#button-cart"),
                            priceIPodShuffle = $("#content > div > div.col-sm-4 > ul:nth-child(4) > li:nth-child(1) > h2  ");


    public SelenideElement CountAndPriceInCart(){
        System.out.println("Call CountAndPriceInCart");
        return $("#cart-total");
    }

}
