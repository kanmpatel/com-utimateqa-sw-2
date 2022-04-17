package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginTest extends BaseTest {
    String baseUrl = "https://courses.ultimateqa.com/";

    @Before
    public void setUp(){
        openBrowser(baseUrl);
    }
    @Test
    public void userShouldNavigateToLoginPageSuccessfully(){
        //find the element of sign in click on sign in
        WebElement signInLink = driver.findElement(By.linkText("Sign In"));
        signInLink.click();
        //this os form requirement
        String expectedLogInText = "Welcome Back!";
        //find the welcome text element and get the text
        WebElement actualLogInTextElements = driver.findElement(By.xpath("//h1[@class='page__heading']"));
        String actualLogInText = actualLogInTextElements.getText();
        //Verify the text error message with assert
        Assert.assertEquals(expectedLogInText,actualLogInText);
    }

    @Test
    public void verifyTheErrorMessage(){
        //find the element of sign in click on sign in
        WebElement signInLink = driver.findElement(By.linkText("Sign In"));
        signInLink.click();
        //find the element of username and send the username key
        WebElement UserNameElement = driver.findElement(By.id("user[email]"));
        UserNameElement.sendKeys("megha");
        //find the element of password and send the password key
        WebElement passwordElement = driver.findElement(By.name("user[password]"));
        passwordElement.sendKeys("megha1234");
        //click on loging button using elements
        WebElement loginButton = driver.findElement(By.xpath("//input[@class='button button-primary g-recaptcha']"));
        loginButton.click();
        //this os form requirement
        String expectedErrorMessage = "Invalid email or password.";
        //find the welcome text element and get the text
        WebElement actualErrorMessageElements = driver.findElement(By.cssSelector(".form-error__list-item"));
        String actualErrorMessage = actualErrorMessageElements.getText();
        //Verify the text error message with assert
        Assert.assertEquals(expectedErrorMessage,actualErrorMessage);
    }

    @After
    public void tearDown(){
        //close the browser
        closeBrowser();
    }


}
