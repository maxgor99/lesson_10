package fixture;

import com.github.javafaker.Faker;

import java.util.Locale;

public class PracticeFormPageFixture {

    static Faker faker = new Faker(new Locale("en-GB"));

    public String firstName = faker.name().firstName(),
            lastName = faker.name().lastName(),
            email = faker.internet().emailAddress(),
            phoneNumber = faker.phoneNumber().subscriberNumber(10),
            incorrectPhoneNumber = faker.phoneNumber().subscriberNumber(9),
            currentAdress = faker.address().fullAddress(),
            gender = faker.options().option("Male", "Female", "Other"),
            dayOfBirth = String.format("%02d", faker.number().numberBetween(1, 28)),
            mountOfBirther = faker.options().option("January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"),
            yearOfBirth = String.valueOf(faker.number().numberBetween(1960, 1999)),
            subjects = faker.options().option("English", "Maths", "Physics"),
            hobbies = faker.options().option("Sports", "Reading", "Music"),
            state = faker.options().option("NCR", "Uttar Pradesh", "Haryana", "Rajasthan"),
            city = getRandomCity(state);


    public static String getRandomCity(String state) {
        switch (state) {
            case "NCR":
                return faker.options().option("Delhi", "Gurgaon", "Noida");
            case "Uttar Pradesh":
                return faker.options().option("Agra", "Lucknow", "Merrut");
            case "Haryana":
                return faker.options().option("Karnal", "Panipat");
            case "Rajasthan":
                return faker.options().option("Jaipur", "Jaiselmer");
            default:
                return state;
        }

    }
}
