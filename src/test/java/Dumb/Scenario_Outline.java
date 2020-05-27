package Dumb;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;


public class Scenario_Outline {
    WebDriver driver;
    @Before
    public void setup()
    {

        System.setProperty("webdriver.chrome.driver","C:\\selenium-java-3.141.59\\chromedriver.exe");
        driver=new ChromeDriver();
        driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
        driver.manage().window().maximize();

    }
    @After
    public void teardown()
    {
        driver.manage().deleteAllCookies();
        driver.quit();
    }
    @Given("i access {string}")
    public void i_access(String url) {
        // Write code here that turns the phrase above into concrete actions
        driver.get(url);
    }

    @When("i click on login portal button")
    public void i_click_on_login_portal_button() {
        // Write code here that turns the phrase above into concrete actions
        driver.findElement(By.xpath("//h1[contains(text(),'LOGIN PORTAL')]")).click();
        String text = driver.findElement(By.xpath("//h1[contains(text(),'LOGIN PORTAL')]")).getText();
    }

    @When("i enter the {string} username")
    public void i_enter_the_username(String username) {
        // Write code here that turns the phrase above into concrete actions
        for(String CurrentWinHandle:driver.getWindowHandles())
        {
            driver.switchTo().window(CurrentWinHandle);
        }
        driver.findElement(By.id("text")).sendKeys(username);

    }

    @When("i enter the {string} password")
    public void i_enter_the_password(String password) {
        // Write code here that turns the phrase above into concrete actions
        driver.findElement(By.id("password")).sendKeys(password);
    }

    @When("clicks on login button")
    public void clicks_on_login_button() {
        // Write code here that turns the phrase above into concrete actions
        driver.findElement(By.id("login-button")).click();
    }

    @Then("User should be prompted with following alert {string}")
    public void user_should_be_prompted_with_following_alert(String text) throws InterruptedException {
        // Write code here that turns the phrase above into concrete actions
        Alert alert=driver.switchTo().alert();
        Assert.assertEquals(alert.getText(),text);

        Thread.sleep(2000);
        alert.accept();


    }
}
