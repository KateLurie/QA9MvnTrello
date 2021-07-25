package org.example.tests;


import org.example.pages.BoardsPageHelper;
import org.example.pages.LoginPageHelper;
import org.example.util.DataProviders;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginTests extends TestBase {
    //HomePageHelper homePage;
    LoginPageHelper loginPage;
    BoardsPageHelper boardsPage;


    @BeforeMethod
    public void initTests() {
        // homePage = PageFactory.initElements(driver, HomePageHelper.class);
        loginPage = PageFactory.initElements(driver, LoginPageHelper.class);
        boardsPage = PageFactory.initElements(driver, BoardsPageHelper.class);
        log4j.startMethod("LoginTests - initTests()");

        homePage.waitUntilPageIsLoaded();
        loginPage.openPage();
        loginPage.waitUntilPageIsLoaded();
        log4j.endMethod("LoginTests - initTests()");
    }
    @Test(dataProviderClass = DataProviders.class, dataProvider = "dataProviderThird2")
    public void negativeLoginThirddataProv2(String login, String password) {
        loginPage.loginNotAttl(login, password);
        Assert.assertEquals(loginPage.getErrorMessage(),
                "There isn't an account for this username");
        //"There isn't an account for this email"
    }

    @Test(dataProviderClass = DataProviders.class, dataProvider = "loginNegative2")
    public void negativeLogin(String login, String password, String message) {
        log4j.startMethod("negativeLogin(), parametres: login="+login + ",password= " + password + ",message=" + message);
        log4j.info("Enter login not Attl: login= " + login+" password "+password);
        loginPage.loginNotAttl(login, password);
        log4j.info("Assert message has to be - "+message);
        Assert.assertEquals(loginPage.getErrorMessage(), message,
                "There isn't an account for this user");
        log4j.endMethod("negativeLogin(), parametres: login="+login + ",password= " + password + ",message=" + message);
        //"There isn't an account for this email"
    }
    @Test(dataProviderClass = DataProviders.class, dataProvider = "dataProviderThird")
    public void negativeLoginThirddataProv(String login, String password) {
        loginPage.loginNotAttl(login, password);
        Assert.assertEquals(loginPage.getErrorMessage(), "There isn't an account for this email",
                "The error message is not correct");
    }
                                                                   //название метода
    @Test(dataProviderClass = DataProviders.class, dataProvider = "dataProviderSecond")
    public void positiveLogin(String login, String password, String nameButton) {
       // loginPage.loginAsAttl(LOGIN, PASSWORD);
        loginPage.loginAsAttl(login,password);
        boardsPage.waitUntilPageIsLoaded();
        Assert.assertEquals(boardsPage.getBoardsButtonName(), nameButton,
                "Name of the button is not 'Boards'");

    }
}


