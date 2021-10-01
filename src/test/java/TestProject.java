import DataObject.DataConnection;
import DataObject.GenerateDataObject;
import StepObject.RegistrationSteps;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.sql.*;

public class TestProject extends ConfigurationClass {

    @BeforeTest
    public void Start() throws SQLException {
        System.out.println("Start methot");
        DataConnection conn = new DataConnection();
        connect = conn.CreateConnection();
        generateData = new GenerateDataObject();
        OpenUrl();
    }

    @Test
    public void FirstTest() throws InterruptedException, SQLException {
        RegistrationSteps stepsObject = new RegistrationSteps();

        String query = "INSERT INTO users (firstName, lastName, phone, password, address, email, country, state, city, zip)\n" +
                "VALUES (" + generateData.GenerateFirstName() + "," + generateData.GenerateLastName() + "," + generateData.GeneratePhoneNumber() + ","
                + generateData.GeneratePassword() + "," + generateData.GenerateAddress() + "," + generateData.GenerateEmail() + "," + generateData.GenerateCountry()
                + "," + generateData.GenerateState() + "," + generateData.GenerateCity() + "," + generateData.GenerateZipCode() + ");";


        System.out.println(query);

        generateData.InsertNewRowInSqsTable(connect);
        System.out.println("Finish");

        ResultSet result = generateData.ReturnLastRowFromDataTable(connect);

        while (result.next()) {
            firstName = result.getString(2);
            lastName = result.getString(3);
            phone = result.getString(4);
            password = result.getString(5);
            address = result.getString(6);
            email = result.getString(7);
            country = result.getString(8);
            state = result.getString(9);
            city = result.getString(10);
            zip = Integer.parseInt(result.getString(11));
        }

        //  stepsObject.ClickMyAccaunt();
        // stepsObject.ClickRegistration();

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

        Thread.sleep(25000);
    }

}
