package Steps;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class Assignment3 {
    public WebDriver driver;
    @Before
    public void setup()
    {

        String cwd=System.getProperty("user.dir");
        System.setProperty("webdriver.chrome.driver",cwd+"\\src\\test\\resources\\chromedriver.exe");
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

    @Given("^i access url$")
    public void i_access_url() throws Throwable {
        driver.get("http://newtours.demoaut.com/");

    }

    @When("^i click Register link$")
    public void i_click_register_link() throws Throwable {
        driver.findElement(By.linkText("REGISTER")).click();

    }



    @And("enter the {string} FirstName")
    public void enterTheFirstName(String first) {
        driver.findElement(By.name("firstName")).sendKeys(first);
    }

    @And("^enter the \"([^\"]*)\"  LastName$")
    public void enter_the_something_lastname(String last) throws Throwable {
        driver.findElement(By.name("lastName")).sendKeys(last);


    }

    @And("^enter the \"([^\"]*)\"     Phone$")
    public void enter_the_something_phone(String phone) throws Throwable {
        driver.findElement(By.name("phone")).sendKeys(phone);

    }

    @And("^enter the \"([^\"]*)\"     Email$")
    public void enter_the_something_email(String email) throws Throwable {
        driver.findElement(By.name("userName")).sendKeys(email);

    }

    @And("^enter the \"([^\"]*)\"      City$")
    public void enter_the_something_city(String city) throws Throwable {
        driver.findElement(By.name("city")).sendKeys(city);

    }

    @And("^enter the \"([^\"]*)\"     State$")
    public void enter_the_something_state(String state) throws Throwable {
        driver.findElement(By.name("state")).sendKeys(state);

    }

    @And("^enter the \"([^\"]*)\" Pincode$")
    public void enter_the_something_pincode(String postalcode) throws Throwable {
        driver.findElement(By.name("postalCode")).sendKeys(postalcode);

    }

    @And("^Select \"([^\"]*)\"      Country$")
    public void select_something_country(String country) throws Throwable {
        Select select=new Select(driver.findElement(By.name("country")));
        select.selectByVisibleText(country);


    }

    @And("^enter the \"([^\"]*)\"  UserName$")
    public void enter_the_something_username(String username) throws Throwable {
        driver.findElement(By.name("email")).sendKeys(username);

    }

    @And("^enter the \"([^\"]*)\"  Password$")
    public void enter_the_something_password(String password) throws Throwable {
        driver.findElement(By.name("password")).sendKeys(password);
    }

    @And("^re-enter the \"([^\"]*)\" Confirm Password$")
    public void reenter_the_something_confirm_password(String confirmpassword) throws Throwable {
        driver.findElement(By.name("confirmPassword")).sendKeys(confirmpassword);
    }

    @And("^hit submit button$")
    public void hit_submit_button() throws Throwable {
        driver.findElement(By.name("register")).click();

    }

    @Then("Registration should be successful")
    public void registrationShouldBeSuccessful() {
        WebDriverWait w=new WebDriverWait(driver,5);
        w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'Thank you for registering')]")));

        Assert.assertTrue(driver.findElement(By.xpath("//*[contains(text(),'Thank you for registering')]")).isDisplayed());
    }


    @And("Verify the Username")
    public void verifyTheUsername() {
        WebDriverWait w=new WebDriverWait(driver,5);
        w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'Note: Your user name is')]")));
        Assert.assertTrue(driver.findElement(By.xpath("//*[contains(text(),'Note: Your user name is')]")).isDisplayed());
    }
}
