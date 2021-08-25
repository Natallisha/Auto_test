package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import page.PastePage;
import page.PastebinHomePage;


public class ICanWin {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        String scriptForInput = "Hello from WebDriver";
        String expirationPeriod = "10 Minutes";
        String titleName = "helloweb";

        new PastebinHomePage(driver)
                .openPage()
                .createNewPaste()
                .inputScript(scriptForInput)
                .setExpiration(expirationPeriod)
                .inputPasteName(titleName)
                .pressBtnToCreatePaste();

        driver.quit();

    }
}


