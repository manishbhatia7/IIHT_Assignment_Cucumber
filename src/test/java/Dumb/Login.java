package Dumb;

import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Login {
    WebDriver driver;
    @Before
    public void setup()
    {
        System.setProperty("webdriver.chrome.driver","C:\\selenium-java-3.141.59\\chromedriver.exe");
        this.driver=new ChromeDriver();
        driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }
    @Given("^I access Webdriver University$")
    public void i_access_webdriver_university() throws Throwable {
        driver.get("http://webdriveruniversity.com/");
    }

    @When("^i click on login portal button$")
    public void i_click_on_login_portal_button() throws Throwable {
        driver.findElement(By.xpath("//h1[contains(text(),'LOGIN PORTAL')]")).click();
    }

    @Then("^i should be presented with sucessful validation alert$")
    public void i_should_be_presented_with_sucessful_validation_alert() throws Throwable {
        Alert alert=driver.switchTo().alert();
        Assert.assertEquals("validation failed",alert.getText());

    }

    @Then("^i should be presented with unsucessful validation alert$")
    public void i_should_be_presented_with_unsucessful_validation_alert() throws Throwable {
        Alert alert=driver.switchTo().alert();
        Assert.assertEquals("No validation failed",alert.getText());

    }

    @And("^i enter the username$")
    public void i_click_on_username() throws Throwable
    {
    String winHandleBefore=driver.getWindowHandle();
    for(String CurrentWinHandle:driver.getWindowHandles())
    {
        driver.switchTo().window(CurrentWinHandle);
    }
    driver.findElement(By.id("text")).sendKeys("Tom");

    }

    @And("^I click on \"([^\"]*)\" password$")
    public void i_click_on_something_password(String password) throws Throwable {
        driver.findElement(By.id("password")).sendKeys(password);


    }

    @And("^I click on login button$")
    public void i_click_on_login_button() throws Throwable {
        driver.findElement(By.id("login-button")).click();


    }

}
