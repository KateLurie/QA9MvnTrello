package org.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HelpPageHelper extends PageBase{
    @FindBy(xpath = "//span[contains(text(),'Help')]")
    WebElement helpButton;
    @FindBy(xpath = "//span[contains(text(),'Go to your boards')]")
    WebElement goToYourBoardsButton;
    @FindBy(xpath = "//h1[contains(text(),'Get help with Trello')]")
    WebElement getHelpWithTrello;
    public static String FIRSTWINDOWHANDLE ="";
    public static String SECONDWINDOWHANDLE ="";

    public  HelpPageHelper(WebDriver driver){
        this.driver = driver;
    }
    public void waitHelpButtonIsLoaded(){
        waitUntilElementIsClickable(helpButton, 5);
    }
    public void openHelpPage(){
        helpButton.click();
    }

    public void clickGoToYourBoardsButton(){
        goToYourBoardsButton.click();
    }
    public void switchToSecondWindow() {
        FIRSTWINDOWHANDLE=driver.getWindowHandle();
        for(String handle: driver.getWindowHandles()) {
            System.out.println("Handle: "+ handle);
            if(!handle.equals(FIRSTWINDOWHANDLE)) {
                SECONDWINDOWHANDLE=handle;
            }
        }
        System.out.println("Active first window handle: " + driver.getWindowHandle());
        driver.switchTo().window(SECONDWINDOWHANDLE);
        System.out.println("Now active is help window(second) handle: " + driver.getWindowHandle());

    }

    public void waitH1isVisible(){
        waitUntilElementIsVisible(getHelpWithTrello,5);
    }


    public void closeWindow() {
        driver.close();
        driver.switchTo().window(FIRSTWINDOWHANDLE);
        System.out.println("Active previous(first) window handle: " + driver.getWindowHandle());
    }
}
