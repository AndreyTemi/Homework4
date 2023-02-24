import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;



public class Homework4 {
    @BeforeAll
     static void beforeAll() {
        Configuration.browserSize = "1920x1080";
}

    @Test
    void testGitHubForm() {
        open("https://github.com/");

        $("[placeholder='Search GitHub']").setValue("selenide").pressEnter();
        $$("ul.repo-list li").first().$("a").click();
        $("#wiki-tab").click();
        $(".markdown-body a[href=\"/selenide/selenide/wiki/SoftAssertions\"]").shouldHave(text("Soft Assertions"));
        $(".markdown-body a[href=\"/selenide/selenide/wiki/SoftAssertions\"]").click();
        $(".markdown-body").shouldHave(text("Using JUnit5 extend test class:"));
    }
}
