package com.selenideTask10.app;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.source;

public class TestDDT {

    private static final String URL = "https://192.168.100.26/";

    private static final By USERNAME = By.id("Username");
    private static final By PASSWORD = By.id("Password");
    private static final By SUBMIT_BUTTON = By.id("SubmitButton");

    @DataProvider(name = "credentials")
    public Object[][] dataSet() {
        return new Object[][] {
                {"AnastasiaShumskaya", "1", "Shumskaya, Anastasia"},
                {"q",                  "1", "*Invalid credentials."},
                {"",                   "",  "Username is required"},
                {"",                   "",  "Password is required"},
                {"q",                  "2", "*Invalid credentials."},
                {"q",                  "",  "Password is required"},
                {"AnastasiaShumskaya", "",  "Password is required"},
                {"",                   "1", "Username is required"},
                {"",                   "2", "Username is required"}
        };
    }

    @BeforeMethod(alwaysRun = true)
    public void setUpTest() {

        open(URL);
    }

    @Test(dataProvider = "credentials")
    @Parameters({ "username", "password", "message"})
    public void testDDT(final String username, final String password, final String message) {

        $(USERNAME).setValue(username);
        $(PASSWORD).setValue(password);
        $(SUBMIT_BUTTON).click();

        assert source().contains(message);
    }
}
