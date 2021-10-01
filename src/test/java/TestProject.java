import DataObject.DataConnection;
import DataObject.GenerateDataObject;
import StepObject.RegistrationSteps;
import StepObject.SortByPriceSteps;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.sql.*;

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
        RegistrationSteps stepsObject = new RegistrationSteps();
        generateData.InsertNewRowInSqsTable(connect);
        ResultSet result = generateData.ReturnLastRowFromDataTable(connect);
        GetResultData(result);
        stepsObject.
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
        SortByPriceSteps stepsObject = new SortByPriceSteps();
        stepsObject.
                MoveToLaptopsAndNotebooks().
                ShowAllLeptopsAndNotebooks().
                SortByPrice().
                CheckSorting();
    }
}
