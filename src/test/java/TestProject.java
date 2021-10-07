import DataObject.DataConnection;
import DataObject.GenerateDataObject;
import StepObject.AddToCartMP3PlayerSteps;
import StepObject.CheckoutAndConfirmOrderSteps;
import StepObject.RegistrationSteps;
import StepObject.SortByPriceSteps;
import com.codeborne.selenide.testng.SoftAsserts;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.sql.*;

@Epic("Regression Tests")
@Feature("Registration and Price Check Test")
@Listeners({SoftAsserts.class, TestListener.class})
public class TestProject extends BaseClass {


    @BeforeTest
    public void Start(){
        DataConnection conn = new DataConnection();
        try {
            connect = conn.CreateConnection();
        } catch (SQLException throwables) {
            System.out.println("Error cennecting to the database");
            throwables.printStackTrace();
        }
        generateData = new GenerateDataObject();
        OpenUrl();
    }

    @Description("Test Description: Registering a new user with the latest data taken from the database.")
    @Severity(SeverityLevel.BLOCKER)
    @Story("Test verify registration in page")
    @Test(priority = 1, groups = {"Regression1"})
    public void FirstTest(){
        RegistrationSteps stepObjects = new RegistrationSteps();
        generateData.InsertNewRowInSqsTable(connect);
        ResultSet result = generateData.ReturnLastRowFromDataTable(connect);
        GetResultData(result);
        stepObjects.
                ClickMyAccaunt().
                ClickRegistration().
                FillFirstName(firstName).
                FillLastName(lastName).
                FillEmail(email).
                FillPhoneNumber(phone).
                FillPassword(password).
                AgreeToThePrivacyPolicy().
                ContinueButton().
                ContinueRegistration();
    }

    @Description("Test Description: Sorting the prices of laptops from high to low")
    @Severity(SeverityLevel.MINOR)
    @Story("Test verify sorting by price Laptops & Notebooks")
    @Test(priority = 2, groups = {"Regression1"} )
    public void SecondTest() {
        SortByPriceSteps stepObjects = new SortByPriceSteps();
        stepObjects.
                MoveToLaptopsAndNotebooks().
                ShowAllLeptopsAndNotebooks().
                SortByPrice().
                CheckSorting();
    }

    @Description("Test Description: Move to 'Show all Desktops' and add to cart iPod touch")
    @Severity(SeverityLevel.CRITICAL)
    @Story("Test verify add to cart iPod")
    @Test(priority = 3, dependsOnMethods = {"FirstTest"}, groups = {"Regression2"})
    public void ThirdTest(){
        AddToCartMP3PlayerSteps stepObjects = new AddToCartMP3PlayerSteps();
        String iPodShuffle = "iPod Touch";
        stepObjects.
                MoveToDesktop().
                ShowAllDesktop().
                ClickMP3Pleyers().
                MoveToiPodTouch().
                CheckiPodTouchText(iPodShuffle).
                ClickiPodTouch().
                ClickAddCart().
                CheckCountAndPrice("1",  stepObjects.GetiPodTouchPrice());
    }

    @Description("Test Description: Fill billind and delivery information and check price info")
    @Severity(SeverityLevel.CRITICAL)
    @Story("Check starting price and confirm order price")
    @Test(priority = 4, dependsOnMethods = {"ThirdTest"}, retryAnalyzer = RetryClass.class, groups = {"Regression2"})
    public void FourthTest(){
        CheckoutAndConfirmOrderSteps stepObjects = new CheckoutAndConfirmOrderSteps();
        stepObjects.
                ClickToTotalCart().
                SavePriceInfoFromViewCart().
                ClickToCheckout().
                FillFirstName(firstName).
                FillLastName(lastName).
                FillAddress(address).
                FillCity(city).
                FillPostCode(zip.toString()).
                FillCountryAndState(country, state).
                ClickToContinueBillingDetails().
                ClickToContinueDeliveryDetails().
                ClickToContinueDeliveryMethod().
                ClickToTermsAndConditions().
                ClickToContinuePaymentMethod().
                CheckConfirmOrder().
                ClickToConfirmOrder();
    }
}
