package pages.tests;
import org.junit.Test;
import pages.HomePage;
import pages.LoginPage;

public class LoginTests extends BaseTest{

    public LoginPage loginpage ;
    public HomePage homePage;
    String standardUsername = "standard_user";
    String password = "secret_sauce";
    String homePageTitle = "Products";
    String emptyUsername = "";
    String emptyUsernameError = "Epic sadface: Username is required";
    String emptyPassword = "";
    String emptyPasswordError = "Epic sadface: Password is required";
    String invalidUsername = "test";
    String invalidCredentialIsError = "Epic sadface: Username and password do not match any user in this service";
    
@Test
public void verifyUnsuccessfulEmptyUsernameLogin(){
    LoginPage loginPage = new LoginPage(driver);
    loginPage.basePage();
    loginPage.login(emptyUsername, password);
    loginPage.verifyUnsuccessfulLogin(emptyUsernameError);

    try{
        Thread.sleep(5000);

    }catch(InterruptedException e){
        e.printStackTrace();
    }
}

@Test
public void verifyUnsuccessfulEmptyPasswordLogin(){
    LoginPage loginPage = new LoginPage(driver);
    loginPage.basePage();
    loginPage.login(standardUsername, emptyPassword);
    loginPage.verifyUnsuccessfulLogin(emptyPasswordError);
    try{
        Thread.sleep(5000);

    }catch(InterruptedException e){
        e.printStackTrace();
    }

}

@Test
public void verifyUnsuccessfulInvalidUsernameLogin(){
    LoginPage loginPage = new LoginPage(driver);
    loginPage.basePage();
    loginPage.login(invalidUsername,password);
    loginPage.verifyUnsuccessfulLogin(invalidCredentialIsError);
    try{
        Thread.sleep(5000);

    }catch(InterruptedException e){
        e.printStackTrace();
    }
}

@Test
public void verifySuccessfulLogin(){
    LoginPage loginPage = new LoginPage(driver);
    HomePage homePage = new HomePage(driver);
    loginPage.basePage();
    loginPage.login(standardUsername, password);
    homePage.verifySuccesfulLogin(homePageTitle);
    homePage.clickOnMenuButton();
    homePage.clickOnLogoutButton();
    loginPage.verifyLogout();

    try{
        Thread.sleep(5000);

    }catch(InterruptedException e){
        e.printStackTrace();

}
}
}