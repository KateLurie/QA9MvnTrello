package org.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ActivityPageHelper extends PageBase {
    @FindBy(css = ".phenom-desc")
    List<WebElement> activitiesList;

    public  ActivityPageHelper(WebDriver driver){
        this.driver = driver;
    }

    public void waitUntilPageIsLoaded(){
        waitUntilAllElementsAreVisible(activitiesList,10);
    }

    public boolean lastActivityListContains(String text){
        return activitiesList.get(0).getText().contains(text);
    }
}