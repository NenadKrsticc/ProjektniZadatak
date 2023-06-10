package pages.tests;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.openqa.selenium.By;
import pages.HomePage;
import pages.LoginPage;

public class ShoppingTests extends BaseTest{
    public LoginPage loginPage;
    public HomePage homePage;
    String standardUsername = "standard_user";
    String password = "secret_sauce";
    String homePageTitle = "Products";
    int numberOfAllItems = 6;
    String expectedAboutLink = "https://saucelabs.com/";

@Test //Verivikovati da su dva proizvoda dodata u korpu
public void verifySuccessfulAddToCart (){
    LoginPage loginPage = new LoginPage(driver);
    HomePage homePage = new HomePage(driver);
    loginPage.basePage();
    loginPage.login(standardUsername,password);
    homePage.verifySuccesfulLogin(homePageTitle);
    homePage.verifySuccessfulAddToCart();

    try{
        Thread.sleep(5000);

    }catch(InterruptedException e){
        e.printStackTrace();
    }
}  

@Test //Verifikovati da ima 6 proizvoda
public void numberOffItemsHomePage(){
    LoginPage loginPage = new LoginPage(driver);
    HomePage homePage = new HomePage(driver);
    loginPage.basePage();
    loginPage.login(standardUsername,password);
    homePage.verifySuccesfulLogin(homePageTitle);
    homePage.numberOfProducts(numberOfAllItems);
    
    try{
        Thread.sleep(5000);

    }catch(InterruptedException e){
        e.printStackTrace();
    }
}

public void logIn(){
    LoginPage loginPage = new LoginPage(driver);
    loginPage.basePage();
    loginPage.login(standardUsername, password);
}

@Test
public void validateTotalPrice(){
    logIn();
    driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
    driver.findElement(By.id("add-to-cart-sauce-labs-bolt-t-shirt")).click();
    driver.findElement(By.className("shopping_cart_link")).click();
    driver.findElement(By.id("shopping_cart_container")).click();
    driver.findElement(By.id("checkout")).click();
    driver.findElement(By.id("first-name")).sendKeys("Nenad");
    driver.findElement(By.id("last-name")).sendKeys("Krstic");
    driver.findElement(By.id("postal-code")).sendKeys("18300");
    driver.findElement(By.id("continue")).click();
    String item_total = driver.findElement(By.className("summary_subtotal_label")).getText();
    // System.out.println(item_total);
    String replace_item_total = item_total.replace("Item total: $", "");
    // System.out.println(t);
    float item_value = Float.parseFloat(replace_item_total);
    // System.out.println(i);
    String tax = driver.findElement(By.className("summary_tax_label")).getText();
    String replace_tax = tax.replace("Tax: $", "");
    float tax_value = Float.parseFloat(replace_tax);
    float combined = item_value + tax_value;
    // System.out.println(combined);
    String total_price = driver.findElement(By.className("summary_total_label")).getText(); 
    String trimmed_total_price = total_price.replace("Total: $", "");
    float total_price_num = Float.parseFloat(trimmed_total_price);
    assert combined == total_price_num;
}

@Test 
public void validate_message(){
    logIn();
    driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
    driver.findElement(By.id("add-to-cart-sauce-labs-bolt-t-shirt")).click();
    driver.findElement(By.className("shopping_cart_link")).click();
    driver.findElement(By.id("shopping_cart_container")).click();
    driver.findElement(By.id("checkout")).click();
    driver.findElement(By.id("first-name")).sendKeys("Nenad");
    driver.findElement(By.id("last-name")).sendKeys("Krstic");
    driver.findElement(By.id("postal-code")).sendKeys("18300");
    driver.findElement(By.id("continue")).click();
    driver.findElement(By.id("finish")).click();
    String title = driver.findElement(By.className("complete-header")).getText();
    System.out.println(title);
    assertEquals(title, "Thank you for your order!");

}
}
