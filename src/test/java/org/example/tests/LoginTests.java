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

        homePage.waitUntilPageIsLoaded();
        loginPage.openPage();
        loginPage.waitUntilPageIsLoaded();
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
        loginPage.loginNotAttl(login, password);
        Assert.assertEquals(loginPage.getErrorMessage(), message,
                "There isn't an account for this user");
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


