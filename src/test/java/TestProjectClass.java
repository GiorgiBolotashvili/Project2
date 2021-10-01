import Data.DataConnection;
import Data.GenerateDataObjectClass;
import org.apache.commons.lang3.builder.ToStringExclude;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.sql.*;

public class TestProjectClass extends ConfigurationClass{
    GenerateDataObjectClass generateData;
    private Connection _connect;
    private Statement _statement;
    private ResultSet _result;
  //  private String _sqlQuery = " ";
    private String _url = "http://tutorialsninja.com/demo/";

    @BeforeMethod
    public void Start() throws SQLException {
        System.out.println("Start methot");
        DataConnection conn = new DataConnection();
        _connect = conn.CreateConnection();
        _statement = _connect.createStatement();;
        //_result = _statement.executeQuery(_sqlQuery);

        generateData = new GenerateDataObjectClass();

        OpenUrl(_url);
    }

    @Test
    public void FirstTest(){

        String query = "INSERT INTO users (id, firstName, lastName, phone, password, address, email, country, state, city, zip)\n" +
                "VALUES (" + generateData.GenerateFirstName() +"," + generateData.GenerateLastName() +"," + generateData.GeneratePhoneNumber() +","
                + generateData.GeneratePassword() +"," + generateData.GenerateAddress() +"," + generateData.GenerateEmail() +"," + generateData.GenerateCountry()
                +"," + generateData.GenerateState() +"," + generateData.GenerateCity() +"," + generateData.GenerateZipCode() + ");";
        System.out.println(query);

        GenerateDataObjectClass obj = new GenerateDataObjectClass();
    }
}
