package org.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class MenupageHelper extends PageBase {
    @FindBy(css = ".js-open-header-member-menu")
    WebElement headerMenuButton;
    @FindBy(xpath = "//a[@data-test-id = 'header-member-menu-profile']")
    WebElement profileAndVisibilityButton;
    @FindBy(xpath = "//span[contains(text(),'Activity')]")
    List<WebElement> activityMenuList;

    public MenupageHelper(WebDriver driver) {
        this.driver = driver;
    }


    public void openPage()
    {
        headerMenuButton.click();
    }

    public void waitUntilPageIsLoaded() {
        waitUntilElementIsClickable(profileAndVisibilityButton, 5);
        waitUntilElementIsClickable(activityMenuList.get(1), 5);
    }

    public String getProfileVisibilityButtonName() {
        return profileAndVisibilityButton.getText();
    }

    public void openActivitiesPage() {
        activityMenuList.get(1).click();
    }
}