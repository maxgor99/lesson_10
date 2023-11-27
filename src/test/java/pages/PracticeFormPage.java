package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import fixture.PracticeFormPageFixture;
import pages.components.CalendarComponent;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class PracticeFormPage {
    private SelenideElement firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            userEmailInput = $("#userEmail"),
            genderWrapper = $("#genterWrapper"),
            userNumberInput = $("#userNumber"),
            userCurrentAdressInput = $("#currentAddress"),
            calendarInput = $("#dateOfBirthInput"),
            subjectInput = $("#subjectsInput"),
            uploadPicture = $("#uploadPicture"),
            hobbiesWrapper = $("#hobbiesWrapper"),
            selectCity = $("#city"),
            selectState = $("#state"),
            pressSubmit = $("#submit"),
            checkResult = $(".table-responsive");


    CalendarComponent calendarComponent = new CalendarComponent();
    PracticeFormPageFixture practiceFormPageFixture = new PracticeFormPageFixture();

    public PracticeFormPage openPage() {
        open("/automation-practice-form");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        return this;
    }

    public PracticeFormPage setFirstName(String value) {
        firstNameInput.setValue(value);
        return this;

    }

    public PracticeFormPage lastNameInput(String value) {
        lastNameInput.setValue(value);
        return this;

    }

    public PracticeFormPage userEmailInput(String value) {
        userEmailInput.setValue(value);
        return this;

    }

    public PracticeFormPage userNumberInput(String value) {
        userNumberInput.setValue(value);
        return this;

    }

    public PracticeFormPage genderWrapper(String value) {
        genderWrapper.$(byText(value)).click();
        return this;

    }

    public PracticeFormPage userCurrentAdressInput(String value) {
        userCurrentAdressInput.setValue(value);
        return this;

    }

    public PracticeFormPage setDateOfBirth(String day, String month, String year) {
        calendarInput.click();
        calendarComponent.setDate(day, month, year);

        return this;
    }

    public PracticeFormPage subjectInput(String value) {
        subjectInput.val(value).pressEnter();
        return this;

    }

    public PracticeFormPage hobbiesWrapper(String value) {
        hobbiesWrapper.$(byText(value)).click();
        return this;

    }

    public PracticeFormPage uploadPicture(String value) {
        uploadPicture.uploadFromClasspath(value);
        return this;

    }

    public PracticeFormPage selectState(String value) {
        selectState.click();
        selectState.$(byText(value)).click();
        return this;

    }

    public PracticeFormPage selectCity(String value) {
        selectCity.click();
        selectCity.$(byText(value)).click();
        return this;

    }

    public void pressSubmit() {
        pressSubmit.pressEnter();

    }

    public PracticeFormPage checkResult(String key, String value) {
        checkResult.$(byText(key)).parent()
                .shouldHave(text(value));
        return this;
    }

    public PracticeFormPage formResult() {
        checkResult.shouldNotBe(Condition.visible);
        return this;
    }

}
