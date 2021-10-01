package Data;

import com.github.javafaker.Faker;

public class GenerateDataObjectClass {
    private String _firstName;
    private String _lastName;
    private String _phone;
    private String _password;
    private String _address;
    private String _email;
    private String _country;
    private String _state;
    private String _city;
    private String _zip;

    public GenerateDataObjectClass(){
        Faker faker = new Faker();
        _firstName = faker.name().firstName();
        _lastName = faker.name().lastName();
        _phone =  faker.phoneNumber().subscriberNumber(10);
        System.out.println("Name: " + faker.name().firstName());
        System.out.println("LastName: " + faker.name().lastName());
        System.out.println("phone: " + faker.phoneNumber().subscriberNumber(10));
        System.out.println("Password: " + faker.internet().password());
        System.out.println("Email: " + faker.internet().emailAddress());
        System.out.println("address: " + faker.address().streetAddress());
        System.out.println("Country: " + faker.address().country());
        System.out.println("State: " + faker.address().state());
        System.out.println("City: " + faker.address().city());
        System.out.println("ZipCode: " + faker.address().zipCode());
        _password = faker.internet().password();
        _email = faker.internet().emailAddress();
        _address = faker.address().streetAddress();
        _country = faker.address().country();
        _state = faker.address().state();
        _city =  faker.address().city();
        _zip = faker.address().zipCode();
    }

    public String GenerateFirstName(){
        return _firstName;
    }
    public String GenerateLastName(){
        return _lastName;
    }
    public String GeneratePhoneNumber(){
        return _phone;
    }
    public String GeneratePassword(){
        return _password;
    }
    public String GenerateAddress(){
        return _address;
    }
    public String GenerateEmail(){
        return _email;
    }
    public String GenerateCountry(){
        return _country;
    }
    public String GenerateState(){
        return _state;
    }
    public String GenerateCity(){
        return _city;
    }
    public String GenerateZipCode(){
        return _zip;
    }
}
