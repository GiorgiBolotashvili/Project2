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
@Listeners({SoftAsserts.class})
public class TestProject extends BaseClass {

    @BeforeTest
    public void Start() throws SQLException {
        System.out.println("Start methot");
        DataConnection conn = new DataConnection();
        connect = conn.CreateConnection();
        generateData = new GenerateDataObject();
        OpenUrl();
    }


    @Description("Test Description: Registering a new user with the latest data taken from the database.")
    @Severity(SeverityLevel.BLOCKER)
    @Story("Test verify registration in page")
    @Test(priority = 1)
    @DisplayName("Registration Test")
    public void FirstTest(){
        System.out.println("First Test");
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
    @Test(priority = 2)
    @DisplayName("Sorting Test")
    public void SecondTest() {
        System.out.println("Second Test");
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
    @Test(priority = 3, dependsOnMethods = {"FirstTest"})
    @DisplayName("Add to cart Test")
    public void ThirdTest() throws InterruptedException {
        System.out.println("Third Test");
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

        Thread.sleep(8000);
    }

    @Description("Test Description: Fill billind and delivery information and check price info")
    @Severity(SeverityLevel.CRITICAL)
    @Story("Check starting price and confirm order price")
    @Test(priority = 4, dependsOnMethods = {"SecondTest"}, retryAnalyzer = RetryClass.class )
    @DisplayName("Checking price Test")
    public void FourthTest(){
        System.out.println("Fourth Test");
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
                CheckConfirmOrder();
    }
}
