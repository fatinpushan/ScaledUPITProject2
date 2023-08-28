package utility;

import com.github.javafaker.Faker;

public class FakerClass {


    Faker faker = new Faker() ;
    private String firstName ;
    private String lastName ;
    private String address ;
    private String city ;
    private String state ;
    private String zipCode ;
    private String phoneNumber ;
    private String SSN ;
    private String email ;
    private String password ;



    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public FakerClass() {
        this.firstName = faker.name().firstName() ;
        this.lastName = faker.name().lastName() ;
        this.address = faker.address().streetAddress() ;
        this.city = faker.address().city() ;
        this.state = faker.address().state() ;
        this.zipCode = faker.address().zipCode() ;
        this.phoneNumber = faker.phoneNumber().phoneNumber() ;
        this.SSN = faker.idNumber().ssnValid() ;
        this.email = faker.internet().emailAddress() ;
        this.password = faker.internet().password() ;

    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getAddress() {
        return address;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getZipCode() {
        return zipCode;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getSSN() {
        return SSN;
    }









}
