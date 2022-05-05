import org.junit.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

class CssPseudoClassHoverPage extends PageBase {

    private By headerBy = By.xpath("//div[@class='page-body']/h1");
    private By hoverParaBy = By.id("hoverpara");
 
    public WebElement hoverParagraf;
    


    public CssPseudoClassHoverPage(WebDriver driver) {
        super(driver);
        this.driver.get("https://testpages.herokuapp.com/styled/csspseudo/css-hover.html");
        this.onInit();
    }

    private void onInit() {
        hoverParagraf = this.waitAndReturnElement(hoverParaBy);
    }

    public String getHeaderText() {
        return this.waitAndReturnElement(headerBy).getText();
    }

    public void performHoverAction() {
        this.actions.moveToElement(hoverParagraf);
        this.actions.click().build().perform();
    }

}
