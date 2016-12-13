package com.selenideTask10.app;

import org.openqa.selenium.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class AlertsTest {

    private static final String URL = "https://the-internet.herokuapp.com/javascript_alerts";
    private static final String TEXT_ON_ALLERT = "I am a JS Alert";
    private static final String TEXT_ON_CONFIRM = "I am a JS Confirm";
    private static final String TEXT_PROMPT = "Work is done!";

    private static final By ALERT = By.cssSelector("button[onclick='jsAlert()']");
    private static final By CONFIRM = By.cssSelector("button[onclick='jsConfirm()']");
    private static final By PROMPT = By.cssSelector("button[onclick='jsPrompt()']");
    private static final By PROMPT_RESULT = By.id("result");

    @BeforeMethod(alwaysRun = true)
    public void setUpTest() {

        open(URL);
    }

    @Test
    public void alertFirst() {

        $(ALERT).click();

        assert switchTo().alert().getText().contains(TEXT_ON_ALLERT);

        confirm();
    }

    @Test
    public void alertSecond() {

        $(CONFIRM).click();

        assert switchTo().alert().getText().contains(TEXT_ON_CONFIRM);

        dismiss();
    }

    @Test
    public void alertThird() {

        $(PROMPT).click();
        switchTo().alert().sendKeys(TEXT_PROMPT);
        confirm();

        $(PROMPT_RESULT).shouldHave(text("You entered: " + TEXT_PROMPT));
    }
}
