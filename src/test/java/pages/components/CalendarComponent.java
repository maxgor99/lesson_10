package pages.components;


import com.codeborne.selenide.Selenide;

public class CalendarComponent {
    public void setDate(String day, String month, String year) {
        Selenide.$(".react-datepicker__month-select").selectOption(month);
        Selenide.$(".react-datepicker__year-select").selectOption(year);
        Selenide.$(".react-datepicker__day.react-datepicker__day--0" + day + ":not(.react-datepicker__day--outside-month)").click();
    }
}
