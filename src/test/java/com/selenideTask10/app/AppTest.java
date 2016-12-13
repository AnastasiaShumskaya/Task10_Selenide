package com.selenideTask10.app;

import org.openqa.selenium.By;
import org.testng.annotations.*;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.title;

public class AppTest {

    private static final String URL = "https://192.168.100.26/";
    private static final String NAME = "AnastasiaShumskaya";
    private static final String PASS = "1";
    private static final String LOGIN_TITLE = "RMSys - Sign In";
    private static final String HOME = "Home";

    private static final By USERNAME = By.id("Username");
    private static final By PASSWORD = By.id("Password");
    private static final By SUBMIT_BUTTON = By.id("SubmitButton");
    private static final By OFFICE_MENU = By.id("officeMenu");
    private static final By INPUT_SEARCH = By.id("input-search");
    private static final By SIGN_OUT_CSS = By.cssSelector("a[title='Sign out']");
    private static final By SPAN_USER = By.cssSelector("div[id='user-box-validation'] > span");
    private static final By SPAN_PASS = By.cssSelector("div[id='PASSWORD-box-validation'] > span");


    @BeforeMethod(alwaysRun = true)
    public void setUpTest() {

        open(URL);
    }

    @Test
    public void seleniumTest() {

        $(USERNAME).setValue(NAME);
        $(PASSWORD).setValue(PASS);
        $(SUBMIT_BUTTON).click();

        $(SIGN_OUT_CSS).should(exist);
    }

    @Test
    public void testCase() {

        assert title().contains(LOGIN_TITLE);

        $(USERNAME).setValue(NAME);
        $(PASSWORD).setValue(PASS);

        $(SPAN_USER).shouldNot(appear);
        $(SPAN_PASS).shouldNot(appear);
        $(SUBMIT_BUTTON).click();

        assert title().contains(HOME);

        $(OFFICE_MENU).click();

        $(INPUT_SEARCH).should(exist);
    }

}
