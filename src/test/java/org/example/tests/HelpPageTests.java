package org.example.tests;

import org.example.pages.*;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HelpPageTests extends TestBase{
    LoginPageHelper loginPage;
    BoardsPageHelper boardsPage;
    CurrentBoardPageHelper qaHaifa9Board;
    MenupageHelper menuPage;

    HelpPageHelper helpPage;


    @BeforeMethod
    public void initTests() {
        loginPage = PageFactory.initElements(driver, LoginPageHelper.class);
        boardsPage = PageFactory.initElements(driver, BoardsPageHelper.class);
        qaHaifa9Board = new CurrentBoardPageHelper(driver, "QA Haifa 9");
        menuPage = PageFactory.initElements(driver, MenupageHelper.class);
        helpPage =  PageFactory.initElements(driver, HelpPageHelper.class);

        homePage.waitUntilPageIsLoaded();
        loginPage
                .openPage()
                .waitUntilPageIsLoaded()
                .loginAsAttl(LOGIN, PASSWORD);
        boardsPage
                .waitUntilPageIsLoaded()
                .openBoardsMenu();
        qaHaifa9Board
                .openPage()
                .waitUntilPageIsLoaded();
        menuPage.openPage();

        helpPage.waitHelpButtonIsLoaded();
        helpPage.openHelpPage();
        helpPage.waitH1isVisible();

                 }
    @Test
    public void windowsHandlingTest() throws InterruptedException {
        helpPage.switchToSecondWindow();
        helpPage.closeWindow();

    }
    @Test
    public void windowsHandlingTest2() throws InterruptedException {
        helpPage.switchToSecondWindow();
        helpPage.clickGoToYourBoardsButton();
        System.out.println("Active 'Go to your boards' window handle(the action in the same window): " + driver.getWindowHandle());

    }

}