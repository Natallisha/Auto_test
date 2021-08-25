package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PastePage {

    private WebDriver driver;

    @FindBy(xpath = "//a[@class = 'btn -small h_800']")
    private WebElement actualSyntax;

    @FindBy(xpath = "//textarea[@class = 'textarea']")
    private WebElement actualText;

    public PastePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }


    public String getActualTitle() {
        return driver.getTitle();
    }

    public String getActualSyntax() {
        return new WebDriverWait(driver, 10)
                .until(ExpectedConditions.elementToBeClickable(actualSyntax))
                .getText();
    }

    public String getActualText() {
        return new WebDriverWait(driver, 10)
                .until(ExpectedConditions.visibilityOf(actualText))
                .getText();
    }

}
