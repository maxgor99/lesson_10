package test;

import com.codeborne.selenide.Configuration;
import fixture.LanguageEnumTest;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class TelegramPageTest {


    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1366x766";
        Configuration.pageLoadStrategy = "eager";
        Configuration.timeout = 5000; // default 4000
    }

    @EnumSource(LanguageEnumTest.class)
    @ParameterizedTest(name = "выбор языка на сайте")
    void telegramSiteShouldDisplayCorrectText(LanguageEnumTest language) {
        open("https://telegram.org/");
        $(".dropdown.top_lang_select").click();
        $$(".dropdown-menu li").find(text(language.name())).click();
        $(".tl_main_logo_lead").shouldHave(text(language.description));


    }


}

