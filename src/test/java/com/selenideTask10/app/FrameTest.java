package com.selenideTask10.app;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.switchTo;

public class FrameTest {

    private static final String URL = "https://the-internet.herokuapp.com/iframe";
    private static final String TEXT = "Hello, world!";

    private static final By INPUT = By.cssSelector("#tinymce");

    @BeforeMethod(alwaysRun = true)
    public void setUpTest() {

        open(URL);
    }

    @Test
    public void seleniumTest() {

        switchTo().frame(0);
        $(INPUT).clear();
        $(INPUT).sendKeys(TEXT);

        $(INPUT).shouldHave(text(TEXT));
    }

}
