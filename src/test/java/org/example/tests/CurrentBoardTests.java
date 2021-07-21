package org.example.tests;

import org.example.pages.*;
import org.example.util.DataProviders;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CurrentBoardTests extends TestBase{
    //HomePageHelper homePage;
    LoginPageHelper loginPage;
    BoardsPageHelper boardsPage;
    CurrentBoardPageHelper qaHaifa9Board;
    //MenuPageHelper menuPage;
    


    @BeforeMethod
    public void initTests()  {
        //homePage = PageFactory.initElements(driver,HomePageHelper.class);
        loginPage = PageFactory.initElements(driver,LoginPageHelper.class);
        boardsPage = PageFactory.initElements(driver,BoardsPageHelper.class);
        qaHaifa9Board = new CurrentBoardPageHelper(driver, "QA Haifa 9");
       // menuPage = PageFactory.initElements(driver, MenuPageHelper.class);

        homePage.waitUntilPageIsLoaded();
        loginPage
                .openPage()
                .waitUntilPageIsLoaded()
                .loginAsAttl(LOGIN,PASSWORD);
        boardsPage
                .waitUntilPageIsLoaded()
                .openBoardsMenu();
        qaHaifa9Board
                .openPage()
                .waitUntilPageIsLoaded();
        /*menuPage.openPage();
        menuPage.openHelpPage();
        menuPage.waitUntilElementIsVisible();*/
    }

    @Test
    public void windowsHandlingTest() throws InterruptedException {

        driver.findElement(By.cssSelector(".js-open-header-member-menu")).click();

        driver.findElement(By.xpath("//span[contains(text(),'Help')]")).click();
        Thread.sleep(3000);
        String firstWindowHandle = driver.getWindowHandle();


        String secondWindowHandle = "";
        for(String handle: driver.getWindowHandles()) {
           System.out.println("Handle: "+ handle);
            if(!handle.equals(firstWindowHandle)) {
                secondWindowHandle=handle;
            }
        }
        driver.switchTo().window(secondWindowHandle);
        Thread.sleep(3000);
        System.out.println("Active help window handle: " + driver.getWindowHandle());

        driver.close();
        Thread.sleep(3000);
        driver.switchTo().window(firstWindowHandle);
        System.out.println("Active previous(first) window handle: " + driver.getWindowHandle());
    }
    @Test
    public void windowsHandlingTest2() throws InterruptedException {

        driver.findElement(By.cssSelector(".js-open-header-member-menu")).click();

        driver.findElement(By.xpath("//span[contains(text(),'Help')]")).click();
        Thread.sleep(3000);
        String firstWindowHandle = driver.getWindowHandle();
        String secondWindowHandle = "";
        for(String handle: driver.getWindowHandles()) {
            System.out.println("Handle: "+ handle);
            if(!handle.equals(firstWindowHandle)) {
                secondWindowHandle=handle;
            }
        }
        System.out.println("Active QA9 board window handle(before switch): " + driver.getWindowHandle());
        driver.switchTo().window(secondWindowHandle);
        Thread.sleep(3000);
        System.out.println("Active help window handle(after switch): " + driver.getWindowHandle());
        driver.findElement(By.xpath("//span[contains(text(),'Go to your boards')]")).click();
        System.out.println("Active 'Go to your boards' window handle(the action in the same window): " + driver.getWindowHandle());

    }

    @Test
    public void newListCreatingTest()  {
        int beginListsQuantity = qaHaifa9Board.getListsQuantity();
        qaHaifa9Board.addNewList("New");
        int endListsQuantity = qaHaifa9Board.getListsQuantity();
        Assert.assertEquals(endListsQuantity,beginListsQuantity+1,
                "endListsQuantity is not beginListsQuantity+1");
    }
    @Test(dataProviderClass = DataProviders.class, dataProvider = "newListCreating")
    public void newListCreatingTestParam(String nameList) {
        int beginListsQuantity = qaHaifa9Board.getListsQuantity();
        qaHaifa9Board.addNewList(nameList);
        int endListsQuantity = qaHaifa9Board.getListsQuantity();
        Assert.assertEquals(endListsQuantity,beginListsQuantity+1,
                "endListsQuantity is not beginListsQuantity+1");
    }


    @Test
    public void addNewCardTest()  {
        int beginLists = qaHaifa9Board.getListsQuantity();
        if (beginLists == 0){
            qaHaifa9Board.addNewList("ForNewCard");
        }
        int beginCards = qaHaifa9Board.getCardsQuantity();
        qaHaifa9Board.addNewCardToFirstList("card title");
        int endCardsQuantity = qaHaifa9Board.getCardsQuantity();
        Assert.assertEquals(endCardsQuantity,beginCards+1,
                "endCardsQuantity is not beginCards+1");
    }

    @Test
    public void archiveFirstList() {
        int beginLists = qaHaifa9Board.getListsQuantity();
        if (beginLists==0){
            qaHaifa9Board.addNewList("ForNewCard");
            beginLists++;
        }
        qaHaifa9Board.archiveFirstList();
        int endLists = qaHaifa9Board.getListsQuantity();
        Assert.assertEquals(beginLists-1,endLists,
                "beginLists-1 is not endLists");
    }
    @Test
    public void archiveListByName(){
        String nameList = "add";
        int beginLists = qaHaifa9Board.getListsQuantity();
        int number = qaHaifa9Board.getNumberOfElementWithName(nameList);
        if (number==-1){
            qaHaifa9Board.addNewList("add");
            number = beginLists;
            beginLists++;
        }
        qaHaifa9Board.archiveList(number);
        int endLists = qaHaifa9Board.getListsQuantity();
        Assert.assertEquals(beginLists-1,endLists,
                "beginLists-1 is not endLists");
    }

    @Test
    public void copyFirstList()  {
        int beginLists = qaHaifa9Board.getListsQuantity();
        if (beginLists == 0){
            qaHaifa9Board.addNewList("TestList");
            beginLists++;
        }
        qaHaifa9Board.copyFirstList("Copy");
        int endLists = qaHaifa9Board.getListsQuantity();
        Assert.assertEquals(endLists,beginLists+1, "endLists is not beginLists+1");
    }



}