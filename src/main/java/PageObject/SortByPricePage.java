package PageObject;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class SortByPricePage {

    public SelenideElement leptopsAndNotebooks = $(By.xpath("//*[@id=\"menu\"]/div[2]/ul/li[2]/a")),
                    showAllNotebooks = $("#menu > div.collapse.navbar-collapse.navbar-ex1-collapse > ul > li:nth-child(2) > div > a"),
                    sortBy = $("#input-sort"),
                    sortByPrice = $("#input-sort > option:nth-child(5)");
    public ElementsCollection priceList = $$("#content > div:nth-child(7) > div > div > div:nth-child(2) > div.caption > p.price");


}
