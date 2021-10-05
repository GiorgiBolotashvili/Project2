import DataObject.DataConnection;
import DataObject.GenerateDataObject;
import StepObject.AddToCartMP3PlayerSteps;
import StepObject.CheckoutAndConfirmOrderSteps;
import StepObject.RegistrationSteps;
import StepObject.SortByPriceSteps;
import com.codeborne.selenide.testng.SoftAsserts;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.sql.*;

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

    @Test(priority = 1)
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

    @Test(priority = 2)
    public void SecondTest() {
        System.out.println("Second Test");
        SortByPriceSteps stepObjects = new SortByPriceSteps();
        stepObjects.
                MoveToLaptopsAndNotebooks().
                ShowAllLeptopsAndNotebooks().
                SortByPrice().
                CheckSorting();
    }

    @Test(priority = 3, dependsOnMethods = {"FirstTest"})
    public void ThirdTest() {
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

    }

    @Test(priority = 4, dependsOnMethods = {"SecondTest"} )
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
