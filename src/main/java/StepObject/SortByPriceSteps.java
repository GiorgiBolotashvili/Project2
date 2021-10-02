package StepObject;

import PageObject.SortByPriceObject;
import com.codeborne.selenide.ElementsCollection;
import org.testng.Assert;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SortByPriceSteps extends SortByPriceObject {

    public SortByPriceSteps MoveToLaptopsAndNotebooks() {
        leptopsAndNotebooks.hover();
        return this;
    }

    public SortByPriceSteps ShowAllLeptopsAndNotebooks() {
        showAllNotebooks.hover();
        showAllNotebooks.click();
        return this;
    }

    public SortByPriceSteps SortByPrice() {
        sortBy.click();
        sortByPrice.click();
        return this;
    }

    public SortByPriceSteps CheckSorting() {
        for (int i = 0; i < priceList.size() - 1; i++) {
            int firstElement = Integer.parseInt(priceList.get(i).getText().substring(1,priceList.get(i).getText().indexOf(".") + 3).replaceAll("[,-.]",""));
            int secondElement = Integer.parseInt(priceList.get(i + 1).getText().substring(1,priceList.get(i + 1).getText().indexOf(".") + 3).replaceAll("[,-.]",""));

            Assert.assertTrue(firstElement >= secondElement);
        }
        return this;
    }
}
