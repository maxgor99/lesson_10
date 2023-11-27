package fixture;

import org.junit.jupiter.params.provider.Arguments;

import java.util.List;
import java.util.stream.Stream;

public enum LanguageEnumTest {
    Deutsch("ein neues Messaging-Zeitalter"),
    English("a new era of messaging");

    public final String description;

    LanguageEnumTest(String description) {
    this.description = description;
    }





}
