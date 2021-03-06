package org.example.tests;


import org.example.pages.BoardsPageHelper;
import org.example.pages.CurrentBoardPageHelper;
import org.example.pages.LoginPageHelper;
import org.example.pages.MenupageHelper;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MenuPageTests extends TestBase{
    LoginPageHelper loginPage;
    BoardsPageHelper boardsPage;
    CurrentBoardPageHelper qaHaifa9Board;
    MenupageHelper menuPage;


    @BeforeMethod
    public void initTests(){
        loginPage = PageFactory.initElements(driver,LoginPageHelper.class);
        boardsPage = PageFactory.initElements(driver,BoardsPageHelper.class);
        qaHaifa9Board = new CurrentBoardPageHelper(driver, "QA Haifa 9");
        menuPage = PageFactory.initElements(driver, MenupageHelper.class);

        homePage.waitUntilPageIsLoaded();
        loginPage.openPage();
        loginPage.waitUntilPageIsLoaded();
        loginPage.loginAsAttl(LOGIN,PASSWORD);
        boardsPage.waitUntilPageIsLoaded();
        boardsPage.openBoardsMenu();
        qaHaifa9Board.openPage();
        qaHaifa9Board.waitUntilPageIsLoaded();
        menuPage.openPage();
        menuPage.waitUntilPageIsLoaded();
    }

    @Test
    public void profileVisibilityMenuExists(){
        Assert.assertEquals(menuPage.getProfileVisibilityButtonName(),"Profile and visibility");
    }
}