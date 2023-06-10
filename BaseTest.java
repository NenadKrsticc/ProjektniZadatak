package pages.tests;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class BaseTest {
    public WebDriver driver;

    
    @Before
    public void setup(){
        System.setProperty("webdriver.chromedriver", "C:\\Users\\Nenad Krstic\\Desktop\\TestProject\\TestProject\\lib\\chromedrive.exe");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*", "ignore-certificate-errors");
        driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
}

    @After
    public void teardown(){
        driver.quit();
    } 
}    
