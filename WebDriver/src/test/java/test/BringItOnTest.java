package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.PastePage;
import page.PastebinHomePage;

public class BringItOnTest {

    WebDriver driver;

    private static final String SCRIPT_FOR_INPUT = "git config --global user.name  \"New Sheriff in Town\"\n" +
            "git reset $(git commit-tree HEAD^{tree} -m \"Legacy code\")\n" +
            "git push origin master --force";
    private static final String EXPIRATION_PERIOD = "10 Minutes";
    private static final String TITLE_NAME = "how to gain dominance among developers";
    private static final String SYNTAX = "Bash";

    @BeforeMethod(alwaysRun = true)
    public void browserSetup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void parametersOfNewPasteAreSimilarToEntered() {

        PastePage pastePage = new PastebinHomePage(driver)
                .openPage()
                .createNewPaste()
                .inputScript(SCRIPT_FOR_INPUT)
                .setExpiration(EXPIRATION_PERIOD)
                .setSyntax(SYNTAX)
                .inputPasteName(TITLE_NAME)
                .pressBtnToCreatePaste();

        String actualSyntax = pastePage.getActualSyntax();
        String actualText = pastePage.getActualText();
        String actualTitle = pastePage.getActualTitle();

        Assert.assertEquals(actualSyntax, SYNTAX);
        Assert.assertEquals(actualText, SCRIPT_FOR_INPUT);
        Assert.assertTrue(actualTitle.contains(TITLE_NAME));

    }

    @AfterMethod(alwaysRun = true)
    public void browserTearDown() {
        driver.quit();
        driver = null;
    }
}


