package DataObject;

import com.github.javafaker.Faker;

import java.sql.*;

public class GenerateDataObject {
    private String _firstName;
    private String _lastName;
    private String _phone;
    private String _password;
    private String _address;
    private String _email;
    private String _country;
    private String _state;
    private String _city;
    private Integer _zip;

    public GenerateDataObject() {
        Faker faker = new Faker();
        _firstName = faker.name().firstName();
        _lastName = faker.name().lastName();
        _phone = faker.phoneNumber().subscriberNumber(10);
        _password = faker.internet().password();
        _email = faker.internet().emailAddress();
        _address = faker.address().streetAddress();
        _country = faker.address().country();
        _state = faker.address().state();
        _city = faker.address().city();
        String zipCode = faker.address().zipCode();
        _zip = Integer.parseInt(zipCode.substring(0, 4));
    }

    public String GenerateFirstName() {
        return _firstName;
    }

    public String GenerateLastName() {
        return _lastName;
    }

    public String GeneratePhoneNumber() {
        return _phone;
    }

    public String GeneratePassword() {
        return _password;
    }

    public String GenerateAddress() {
        return _address;
    }

    public String GenerateEmail() {
        return _email;
    }

    public String GenerateCountry() {
        return _country;
    }

    public String GenerateState() {
        return _state;
    }

    public String GenerateCity() {
        return _city;
    }

    public Integer GenerateZipCode() {
        return _zip;
    }

    public void InsertNewRowInSqsTable(Connection connect) {
        String query = "INSERT INTO users (firstName, lastName, phone, password, address, email, country, state, city, zip)\n" +
                "VALUES (?,?,?,?,?,?,?,?,?,?);";
        try {
            PreparedStatement preStatement = connect.prepareStatement(query);
            preStatement.setString(1, _firstName);
            preStatement.setString(2, _lastName);
            preStatement.setString(3, _phone);
            preStatement.setString(4, _password);
            preStatement.setString(5, _address);
            preStatement.setString(6, _email);
            preStatement.setString(7, _country);
            preStatement.setString(8, _state);
            preStatement.setString(9, _city);
            preStatement.setInt(10, _zip);

            preStatement.executeUpdate();

        } catch (SQLException throwables) {
            System.out.println("Error cennecting to the database");
            throwables.printStackTrace();
        }

    }

    public ResultSet ReturnLastRowFromDataTable(Connection connect) {
        String query = "SELECT Top 1 *  FROM users  Order by id Desc";
        ResultSet result = null;

        try {
            Statement statement = connect.createStatement();
            result = statement.executeQuery(query);

        } catch (SQLException throwables) {
            System.out.println("Error cennecting to the database");
            throwables.printStackTrace();
        }
        return result;
    }
}
