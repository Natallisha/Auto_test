package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PastebinHomePage {

    private static final String HOME_PAGE = "https://pastebin.com";
    private WebDriver driver;

    @FindBy(className = "header__btn")
    private WebElement createNewPasteButton;

    public PastebinHomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public PastebinHomePage openPage(){
        driver.get(HOME_PAGE);
        new WebDriverWait(driver, 30)
                .until(ExpectedConditions.visibilityOf(createNewPasteButton));
        return this;
    }

    public NewPasteCreationPage createNewPaste(){
        createNewPasteButton.click();
        return new NewPasteCreationPage(driver);
    }
}
