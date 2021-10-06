package StepObject;

import PageObject.SortByPricePage;
import io.qameta.allure.Step;
import org.testng.Assert;


public class SortByPriceSteps extends SortByPricePage {

    @Step
    public SortByPriceSteps MoveToLaptopsAndNotebooks() {
        leptopsAndNotebooks.hover();
        return this;
    }
    @Step
    public SortByPriceSteps ShowAllLeptopsAndNotebooks() {
        showAllNotebooks.hover();
        showAllNotebooks.click();
        return this;
    }
    @Step
    public SortByPriceSteps SortByPrice() {
        sortBy.click();
        sortByPrice.click();
        return this;
    }
    @Step
    public SortByPriceSteps CheckSorting() {
        for (int i = 0; i < priceList.size() - 1; i++) {
            int firstElement = Integer.parseInt(priceList.get(i).getText().substring(1,priceList.get(i).getText().indexOf(".") + 3).replaceAll("[,-.]",""));
            int secondElement = Integer.parseInt(priceList.get(i + 1).getText().substring(1,priceList.get(i + 1).getText().indexOf(".") + 3).replaceAll("[,-.]",""));

            Assert.assertTrue(firstElement >= secondElement);
        }
        return this;
    }
}
