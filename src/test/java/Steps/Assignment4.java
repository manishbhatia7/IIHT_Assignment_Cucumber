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

public class Assignment4 {
    public WebDriver driver;
    @Before
    public void driver_setup()
    {

        String cwd=System.getProperty("user.dir");
        System.setProperty("webdriver.chrome.driver",cwd+"\\src\\test\\resources\\chromedriver.exe");
        driver=new ChromeDriver();
        driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
        //driver.manage().window().maximize();

    }
    @After
    public void driver_teardown()
    {
        driver.manage().deleteAllCookies();
        driver.quit();
    }
    @Given("^i access Automation Practice url$")
    public void i_access_automation_practice_url() throws Throwable {
        driver.get("http://automationpractice.com/index.php");

    }

   @When("i click Registration link")
    public void iClickRegistrationLink() {
        driver.findElement(By.partialLinkText("Sign")).click();
    }

    @And("enter the valid {string} email")
    public void enterTheValidEmail(String email) {
        WebDriverWait w=new WebDriverWait(driver,5);
        w.until(ExpectedConditions.visibilityOfElementLocated(By.id("email_create")));
        driver.findElement(By.id("email_create")).sendKeys(email);

    }



    @And("click on create account")
    public void clickOnCreateAccount() {
        driver.findElement(By.id("SubmitCreate")).click();
    }


    @And("select the Title")
    public void selectTheTitle() throws InterruptedException {
        //WebDriverWait w=new WebDriverWait(driver,5);
        //w.until(ExpectedConditions.visibilityOfElementLocated(By.id("id_gender1")));
        Thread.sleep(3000);
        driver.findElement(By.name("id_gender")).click();
    }
    @And("Type the {string}  FirstName")
    public void typeTheFirstName(String firstname) {
        driver.findElement(By.id("customer_firstname")).sendKeys(firstname);

    }

    @And("Type the {string}   LastName")
    public void typeTheLastName(String lastname) {
        driver.findElement(By.id("customer_lastname")).sendKeys(lastname);

    }


    @And("^Assert that \"([^\"]*)\" is correct$")
    public void assert_that_something_is_correct(String email) throws Throwable {
        String expected_text=email;
        Assert.assertEquals(expected_text,driver.findElement(By.id("email")).getAttribute("value"));



    }

    @And("Type the {string}  passsword")
    public void typeThePasssword(String pwd) {
        driver.findElement(By.id("passwd")).sendKeys(pwd);

    }

    @And("Type the {string} Address")
    public void typeTheAddress(String address) {
        driver.findElement(By.id("address1")).sendKeys(address);
    }


    @And("Type the {string} city")
    public void typeTheCity(String city) {
        driver.findElement(By.id("city")).sendKeys(city);
    }
    @And("Type the {string} State")
    public void typeTheState(String state) {

            Select dropdown1=new Select(driver.findElement(By.id("id_state")));
            dropdown1.selectByVisibleText(state);
    }

    @And("Type the {string} Pincodde")
    public void typeThePincodde(String pincode) {
        driver.findElement(By.id("postcode")).sendKeys(pincode);
    }


    @And("Select {string}    Counttry")
    public void selectCounttry(String country) {
        Select dropdown2=new Select(driver.findElement(By.id("id_country")));
        dropdown2.selectByVisibleText(country);
    }


    @And("^enter \"([^\"]*)\" mobile$")
    public void enter_something_mobile(String mobile) throws Throwable {
    driver.findElement(By.id("phone_mobile")).sendKeys(mobile);
    }

    @And("Type {string} address")
    public void typeAddress(String assign) {
        driver.findElement(By.id("alias")).clear();
        driver.findElement(By.id("alias")).sendKeys(assign);
    }

    @And("^hit Register button$")
    public void hit_register_button() throws Throwable {
        driver.findElement(By.id("submitAccount")).click();


    }

    @Then("Assert that Registration should be successful")
    public void assertThatRegistrationShouldBeSuccessful() {
        WebDriverWait w=new WebDriverWait(driver,5);
        w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[contains(text(),'My account')]")));
        Assert.assertTrue(driver.findElement(By.xpath("//h1[contains(text(),'My account')]")).isDisplayed());
    }



}



