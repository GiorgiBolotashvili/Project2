import DataObject.DataConnection;
import DataObject.GenerateDataObject;
import StepObject.AddToCartMP3PlayerSteps;
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

    @Test
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

    @Test
    public void SecondTest() {
        SortByPriceSteps stepObjects = new SortByPriceSteps();
        stepObjects.
                MoveToLaptopsAndNotebooks().
                ShowAllLeptopsAndNotebooks().
                SortByPrice().
                CheckSorting();
    }

    @Test
    public void ThirdTest() {
        AddToCartMP3PlayerSteps stepObjects = new AddToCartMP3PlayerSteps();
        String iPodShuffle = "iPod Shuffle";

        stepObjects.
                MoveToDesktop().
                ShowAllDesktop().
                ClickMP3Pleyers().
                MoveToiPodShuffle().
                CheckiPodShuffleText(iPodShuffle).
                ClickiPodShuffle().
                ClickAddCart().
                CheckCountAndPrice("1",  stepObjects.GetiPodShufflePrice());

    }
}
