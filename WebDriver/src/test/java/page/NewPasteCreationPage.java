package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class NewPasteCreationPage {

    private WebDriver driver;

    @FindBy(id = "postform-text")
    private WebElement scriptInputField;

    @FindBy(id = "select2-postform-format-container")
    private WebElement syntaxField;

    @FindBy(className = "select2-search__field")
    private WebElement searchSyntaxField;

    @FindBy(id = "select2-postform-expiration-container")
    private WebElement expirationField;

    @FindBy(id = "postform-name")
    private WebElement pasteNameField;

    @FindBy(xpath = "//button[@class = 'btn -big']")
    private WebElement createPasteButton;

    private static final By SYNTAX_ELEMENT_LOCATOR = By.xpath("//li[@class='select2-results__option']");
    private static final By EXPIRATION_ELEMENT_LOCATOR = By.xpath("//li[@class='select2-results__option']");

    public NewPasteCreationPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    public NewPasteCreationPage inputScript(String script) {
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.visibilityOf(scriptInputField))
                .sendKeys(script);
        return this;
    }

    public NewPasteCreationPage setSyntax(String syntax) {
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.elementToBeClickable(syntaxField))
                .click();
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.visibilityOf(searchSyntaxField))
                .sendKeys(syntax);
        List<WebElement> listOfSyntax = new WebDriverWait(driver, 10)
                .until(ExpectedConditions.visibilityOfAllElementsLocatedBy(SYNTAX_ELEMENT_LOCATOR));
        for (WebElement element : listOfSyntax) {
            if (element.getText().contains(syntax)) {
                element.click();
                break;
            }
        }
        return this;
    }

    public NewPasteCreationPage setExpiration(String expirationValue) {
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.elementToBeClickable(expirationField))
                .click();
        List<WebElement> listOfExpirations = new WebDriverWait(driver, 10)
                .until(ExpectedConditions.visibilityOfAllElementsLocatedBy(EXPIRATION_ELEMENT_LOCATOR));
        for (WebElement element : listOfExpirations) {
            if (element.getText().contains(expirationValue)) {
                element.click();
                break;
            }
        }
        return this;
    }

    public NewPasteCreationPage inputPasteName(String nameOfTitle) {
        WebElement pasteName = new WebDriverWait(driver, 10)
                .until(ExpectedConditions.visibilityOf(pasteNameField));
        pasteName.sendKeys(nameOfTitle);

        return this;
    }

    public PastePage pressBtnToCreatePaste() {
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.elementToBeClickable(createPasteButton))
                .click();
        return new PastePage(driver);
    }

}
