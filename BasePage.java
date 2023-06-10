package pages;
import java.time.Duration;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class BasePage {

    public WebDriver driver;
    public WebDriverWait wait;

    public BasePage (WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    
    public void waitVisability (By elementBy){
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(elementBy));
    }

    public void writeText (By elementBy, String text) {
        waitVisability(elementBy);
        driver.findElement(elementBy).clear();
        driver.findElement(elementBy).sendKeys(text);
    }

    public void click(By elementBy){
        waitVisability(elementBy);
        driver.findElement(elementBy).click();
    }    

    public String readText(By elementBy){
        waitVisability(elementBy);
        return driver.findElement(elementBy).getText();
        
    }

    public void assertTextEquals(String expectedText, String acutalText ){
        Assert.assertEquals(expectedText, acutalText);
    }   

    public int countItems(By elementBy){
        waitVisability(elementBy);
        return driver.findElements(elementBy).size();
    }
    

    public void assertIntegerEquals (int expectedInt, int actualInt) {
        Assert.assertEquals(expectedInt, actualInt);
    }

  public String readLink(By elementBy){
        waitVisability(elementBy);
        return driver.findElement(elementBy).getAttribute("href");
}

}
