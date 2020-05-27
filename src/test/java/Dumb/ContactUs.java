package Dumb;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class ContactUs
{
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
    @Given("^I access Webdriver University$")
    public void i_access_webdriver_university() throws Throwable {
        driver.get("http://webdriveruniversity.com/Page-Object-Model/index.html");

    }

    @When("^I click on contact-us link$")
    public void i_click_on_contactus_link() throws Throwable {
        driver.findElement(By.linkText("Contact Us")).click();

    }

    @Then("^Information should be submitted sucessfully.$")
    public void information_should_be_submitted_sucessfully() throws Throwable {
        for(String Currenthandle:driver.getWindowHandles())
        {
            driver.switchTo().window(Currenthandle);
        }
        System.out.println(driver.findElement(By.tagName("h1")).getText());

    }

    @And("^I enter a valid firstname$")
    public void i_enter_a_valid_firstname() throws Throwable {
        for(String Currenthandle:driver.getWindowHandles())
        {
            driver.switchTo().window(Currenthandle);
        }
        driver.findElement(By.name("first_name")).sendKeys("Rock");

    }

    @And("^I enter a valid lastname$")
    public void i_enter_a_valid_lastname(DataTable table) throws Throwable {
        List<String> list=table.asList(String.class);
        driver.findElement(By.name("last_name")).sendKeys(list.get(0));
        driver.findElement(By.name("last_name")).sendKeys(list.get(1));



    }

    @And("^I enter a valid email adddress$")
    public void i_enter_a_valid_email_adddress() throws Throwable {
        driver.findElement(By.name("email")).sendKeys("abc@aol.com");

    }

    @And("^I enter comments$")
    public void i_enter_comments() throws Throwable {
        driver.findElement(By.cssSelector("textarea[name='message']")).sendKeys("Comments1");

    }

    @And("^I click on submit button$")
    public void i_click_on_submit_button() throws Throwable {
        driver.findElement(By.cssSelector("input[type='submit']")).click();

    }


}
