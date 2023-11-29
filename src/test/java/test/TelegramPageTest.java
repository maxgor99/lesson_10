package test;

import com.codeborne.selenide.Configuration;
import fixture.LanguageEnum;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class TelegramPageTest {


    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1366x766";
        Configuration.pageLoadStrategy = "eager";
    }

    @EnumSource(LanguageEnum.class)
    @ParameterizedTest(name = "выбор языка на сайте")
    void telegramSiteShouldDisplayCorrectText(LanguageEnum language) {
        open("https://telegram.org/");
        $(".dropdown.top_lang_select").click();
        $$(".dropdown-menu li").find(text(language.name())).click();
        $(".tl_main_logo_lead").shouldHave(text(language.description));


    }


}

