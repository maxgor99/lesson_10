package test;


import fixture.PracticeFormPageFixture;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import pages.PracticeFormPage;


public class PracticeFormPageTest extends BaseTest {
    PracticeFormPage practiceFormPage = new PracticeFormPage();
    PracticeFormPageFixture fixture = new PracticeFormPageFixture();


    @ValueSource(strings = {"Макс", "Max"})
    @ParameterizedTest
    @Tag("SMOKE")
    @DisplayName("Проверка возможности заполнения поля имени на разной раскладке, вводим {0} ")
    void checkFirstNameEntryInDifferentCountriesTest(String name) {
        practiceFormPage.openPage().
                setFirstName(name).
                lastNameInput(fixture.lastName).
                userNumberInput(fixture.phoneNumber).
                genderWrapper(fixture.gender).
                setDateOfBirth(fixture.dayOfBirth, fixture.mountOfBirther, fixture.yearOfBirth).
                pressSubmit();

        practiceFormPage.checkResult("Student Name", name + " " + fixture.lastName)
                .checkResult("Gender", fixture.gender)
                .checkResult("Mobile", fixture.phoneNumber)
                .checkResult("Date of Birth", fixture.dayOfBirth + " " + fixture.mountOfBirther + "," + fixture.yearOfBirth);


    }

    @CsvSource(value = {
            "Max, Gor",
            "Макс, Гор",
            "Max, Гор",
            "Макс, Gor"})
    @ParameterizedTest(name = "Проверка возможности заполнения поля имени на разной раскладке, вводим {0} {1}")
    @Tag("WEB")

    void checkFullNameEntryInDifferentCountriesTest(String firstName, String lastName) {
        practiceFormPage.openPage().
                setFirstName(firstName).
                lastNameInput(lastName).
                userNumberInput(fixture.phoneNumber).
                genderWrapper(fixture.gender).
                setDateOfBirth(fixture.dayOfBirth, fixture.mountOfBirther, fixture.yearOfBirth).
                pressSubmit();

        practiceFormPage.checkResult("Student Name", firstName + " " + lastName)
                .checkResult("Gender", fixture.gender)
                .checkResult("Mobile", fixture.phoneNumber)
                .checkResult("Date of Birth", fixture.dayOfBirth + " " + fixture.mountOfBirther + "," + fixture.yearOfBirth);


    }

    @CsvFileSource(resources = "/test_data/FullNameFixture.csv")
    @ParameterizedTest(name = "Проверка возможности заполнения поля имени на разной раскладке, вводим {0} {1}")
    @Tag("SMOKE")

    void checkFullNameEntryInDifferentCountriesNewTest(String firstName, String lastName) {
        practiceFormPage.openPage().
                setFirstName(firstName).
                lastNameInput(lastName).
                userNumberInput(fixture.phoneNumber).
                genderWrapper(fixture.gender).
                setDateOfBirth(fixture.dayOfBirth, fixture.mountOfBirther, fixture.yearOfBirth).
                pressSubmit();

        practiceFormPage.checkResult("Student Name", firstName + " " + lastName)
                .checkResult("Gender", fixture.gender)
                .checkResult("Mobile", fixture.phoneNumber)
                .checkResult("Date of Birth", fixture.dayOfBirth + " " + fixture.mountOfBirther + "," + fixture.yearOfBirth);


    }


}

