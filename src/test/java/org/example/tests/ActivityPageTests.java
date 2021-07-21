package org.example.tests;

import org.example.pages.*;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ActivityPageTests extends TestBase{
    LoginPageHelper loginPage;
    BoardsPageHelper boardsPage;
    CurrentBoardPageHelper qaHaifa9Board;
    MenupageHelper menuPage;
    ActivityPageHelper activityPage;

    @BeforeMethod
    public void initTests(){
        loginPage = PageFactory.initElements(driver, LoginPageHelper.class);
        boardsPage = PageFactory.initElements(driver, BoardsPageHelper.class);
        qaHaifa9Board = new CurrentBoardPageHelper(driver, "QA Haifa 9");
        menuPage = PageFactory.initElements(driver, MenupageHelper.class);
        activityPage = PageFactory.initElements(driver, ActivityPageHelper.class);

        homePage.waitUntilPageIsLoaded();
        loginPage.openPage();
        loginPage.waitUntilPageIsLoaded();
        loginPage.loginAsAttl(LOGIN,PASSWORD);
        boardsPage.waitUntilPageIsLoaded();
        boardsPage.openBoardsMenu();
        qaHaifa9Board.openPage();
        qaHaifa9Board.waitUntilPageIsLoaded();
        //menuPage.openPage();
        //menuPage.waitUntilPageIsLoaded();
    }
    @Test
    public void creatingListInActivityTest(){
        String listName = "List new name";
        qaHaifa9Board.addNewList(listName);
        menuPage.openPage();
        menuPage.waitUntilPageIsLoaded();
        menuPage.openActivitiesPage();
        activityPage.waitUntilPageIsLoaded();
        Assert.assertTrue(activityPage.lastActivityListContains(listName));
    }
}
